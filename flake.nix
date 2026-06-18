{
  inputs = {
    flake-utils = {
      url = "github:numtide/flake-utils";
    };
    nixpkgs = {
      url = "github:NixOS/nixpkgs/nixos-26.05";
    };
    scip = {
      url = "github:scip-code/scip";
    };
  };

  outputs =
    {
      self,
      flake-utils,
      nixpkgs,
      scip,
    }:
    flake-utils.lib.eachDefaultSystem (
      system:
      let
        pkgs = import nixpkgs { inherit system; };
        scipCli = scip.packages.${system}.default;
        mkDevShell =
          jdk:
          pkgs.mkShellNoCC {
            buildInputs = with pkgs; [
              bazelisk
              git
              (gradle.override ({ java = jdk; }))
              jdk
              jq
              ktfmt
              (maven.override ({ jdk_headless = jdk; }))
              nixfmt
              nodejs
              (sbt.override ({ jre = jdk; }))
              scalafmt
              scipCli
              yarn
            ];
          };
      in
      {
        checks = {
          actionlint = pkgs.runCommand "check-actionlint" { } ''
            ${pkgs.actionlint}/bin/actionlint ${./.github/workflows}/*.yml
            touch $out
          '';
          ktfmt =
            pkgs.runCommand "check-ktfmt"
              {
                nativeBuildInputs = [
                  pkgs.findutils
                  pkgs.git
                  pkgs.gnugrep
                ];
              }
              ''
                cp -r ${./.}/. .
                chmod -R u+w .
                git init -q
                git add -A
                # Exclude minimized Kotlin snapshots: the input fixtures are
                # coupled to generated SCIP goldens with exact line/column
                # annotations, so their layout must not be reformatted here.
                git ls-files -z -- '*.kt' '*.kts' \
                  | grep -zv '^scip-kotlinc/minimized/' \
                  | xargs -0 -r ${pkgs.ktfmt}/bin/ktfmt \
                      --kotlinlang-style \
                      --dry-run \
                      --set-exit-if-changed
                touch $out
              '';
          nixfmt = pkgs.runCommand "check-nixfmt" { } ''
            ${pkgs.nixfmt}/bin/nixfmt --check ${./flake.nix}
            touch $out
          '';
          renovate = pkgs.runCommand "check-renovate" { } ''
            LOG_LEVEL=warn ${pkgs.renovate}/bin/renovate-config-validator \
              ${./.github/renovate.json}
            touch $out
          '';
          scalafmt =
            pkgs.runCommand "check-scalafmt"
              {
                buildInputs = [ pkgs.git ];
              }
              ''
                cp -r ${./.}/. .
                chmod -R u+w .
                git init -q
                git add -A
                ${pkgs.scalafmt}/bin/scalafmt --check --non-interactive
                touch $out
              '';
          shellcheck = pkgs.runCommand "check-shellcheck" { } ''
            ${pkgs.shellcheck}/bin/shellcheck ${./bin}/*.sh
            touch $out
          '';
        };

        devShells = {
          default = mkDevShell pkgs.temurin-bin-11;
          # https://github.com/NixOS/nixpkgs/issues/526834
          jdk11 = mkDevShell pkgs.temurin-bin-11;
          jdk17 = mkDevShell pkgs.jdk17;
          jdk21 = mkDevShell pkgs.jdk21;
        };
      }
    );
}

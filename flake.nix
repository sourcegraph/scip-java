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
              google-java-format
              (gradle.override ({ java = jdk; }))
              jdk
              jq
              ktfmt
              (maven.override ({ jdk_headless = jdk; }))
              nixfmt
              nodejs
              scipCli
              yarn
            ];
          };
      in
      {
        checks = {
          actionlint = pkgs.runCommand "check-actionlint" { } ''
            ${pkgs.actionlint}/bin/actionlint ${./.github/workflows}/*.yaml
            touch $out
          '';
          javafmt = pkgs.runCommand "check-javafmt" { } ''
            cd ${./.}
            # Exclude minimized fixtures and generated SCIP snapshot goldens
            # (coupled to exact line/column annotations), the standalone example
            # projects, and the scip-java build-tool test fixtures: these all mirror
            # real-world project layouts that must not be reformatted here.
            find . -name '*.java' \
              -not -path './examples/*' \
              -not -path './scip-snapshots/cases/*' \
              -not -path './scip-snapshots/expected/*' \
              -not -path './scip-java/src/test/resources/fixtures/*' \
              -exec ${pkgs.google-java-format}/bin/google-java-format --dry-run --set-exit-if-changed {} +
            touch $out
          '';
          ktfmt = pkgs.runCommand "check-ktfmt" { } ''
            cd ${./.}
            # Exclude minimized Kotlin snapshots (coupled to generated SCIP
            # goldens with exact line/column annotations) and the scip-java
            # build-tool test fixtures (real-world project layouts): neither may
            # be reformatted.
            find . -name '*.kt' \
              -not -path './scip-snapshots/cases/*' \
              -not -path './scip-snapshots/expected/*' \
              -not -path './scip-java/src/test/resources/fixtures/*' \
              -exec ${pkgs.ktfmt}/bin/ktfmt --kotlinlang-style --dry-run --set-exit-if-changed {} +
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
          jdk25 = mkDevShell pkgs.jdk25;
        };
      }
    );
}

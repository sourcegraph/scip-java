{
  inputs = {
    flake-utils = {
      url = "github:numtide/flake-utils";
    };
    nixpkgs = {
      url = "github:NixOS/nixpkgs/nixos-26.05";
    };
  };

  outputs =
    {
      self,
      flake-utils,
      nixpkgs,
    }:
    flake-utils.lib.eachDefaultSystem (
      system:
      let
        pkgs = import nixpkgs { inherit system; };
        mkDevShell =
          jdk:
          pkgs.mkShellNoCC {
            buildInputs = with pkgs; [
              bazelisk
              git
              (gradle.override ({ java = jdk; }))
              jdk
              jq
              (maven.override ({ jdk_headless = jdk; }))
              nixfmt
              nodejs
              (sbt.override ({ jre = jdk; }))
              scalafmt
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

        devShells =
          let
            # The source-built openjdk 11 segfaults at runtime (UB in markOop
            # exposed by the toolchain in nixpkgs 26.05), so use the prebuilt
            # Temurin binary instead. See NixOS/nixpkgs#526834.
            jdk11 = pkgs.temurin-bin-11;
          in
          {
            default = mkDevShell jdk11;
            jdk11 = mkDevShell jdk11;
            jdk17 = mkDevShell pkgs.jdk17;
            jdk21 = mkDevShell pkgs.jdk21;
          };
      }
    );
}

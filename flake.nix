{
  inputs = {
    flake-utils = {
      url = "github:numtide/flake-utils";
    };
    nixpkgs = {
      url = "github:NixOS/nixpkgs/nixos-25.11";
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
              (coursier.override ({ jre = jdk; }))
              docker
              git
              (gradle.override ({ java = jdk; }))
              jdk
              jq
              (maven.override ({ jdk_headless = jdk; }))
              (mill.override ({ jre = jdk; }))
              nixfmt
              nodejs
              (sbt.override ({ jre = jdk; }))
              yarn
            ];
          };
      in
      {
        checks = {
          nixfmt = pkgs.runCommand "check-nixfmt" { } ''
            ${pkgs.nixfmt}/bin/nixfmt --check ${./flake.nix}
            touch $out
          '';
          renovate = pkgs.runCommand "check-renovate" { } ''
            LOG_LEVEL=warn ${pkgs.renovate}/bin/renovate-config-validator \
              ${./.github/renovate.json}
            touch $out
          '';
        };

        devShells = {
          default = mkDevShell pkgs.jdk11;
          jdk11 = mkDevShell pkgs.jdk11;
          jdk17 = mkDevShell pkgs.jdk17;
          jdk21 = mkDevShell pkgs.jdk21;
        };
      }
    );
}

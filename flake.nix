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
        lib = pkgs.lib;
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
              scalafmt
              yarn
            ];
          };

        # A standalone scip-java launcher built via `coursier bootstrap`.
        # The fixed-output derivation lets Nix cache the result; bump
        # `scipJavaVersion` and rebuild to get a new outputHash.
        scipJavaVersion = "0.12.3";
        runtimeJdk = pkgs.jdk17;
        scipJavaStandalone = pkgs.stdenvNoCC.mkDerivation {
          pname = "scip-java-standalone";
          version = scipJavaVersion;
          dontUnpack = true;
          dontFixup = true;
          nativeBuildInputs = [ (pkgs.coursier.override ({ jre = runtimeJdk; })) ];
          outputHashMode = "recursive";
          outputHashAlgo = "sha256";
          outputHash = "sha256-ifYIQQJftpwvDa7BUSL+OwfQ6W23l1Au9QP6tUmq0mQ=";
          buildPhase = ''
            export HOME="$TMPDIR/home"
            export COURSIER_CACHE="$TMPDIR/coursier-cache"
            export COURSIER_PROGRESS=0
            export SSL_CERT_FILE="${pkgs.cacert}/etc/ssl/certs/ca-bundle.crt"
            export NIX_SSL_CERT_FILE="$SSL_CERT_FILE"
            mkdir -p "$HOME" "$COURSIER_CACHE"
            cs bootstrap \
              "com.sourcegraph:scip-java_2.13:${scipJavaVersion}" \
              -M com.sourcegraph.scip_java.ScipJava \
              --standalone \
              -f \
              -o scip-java
          '';
          installPhase = ''
            install -Dm755 scip-java "$out/bin/scip-java"
          '';
        };
        scipJava = pkgs.stdenvNoCC.mkDerivation {
          pname = "scip-java";
          version = scipJavaVersion;
          dontUnpack = true;
          nativeBuildInputs = [ pkgs.makeWrapper ];
          installPhase = ''
            install -Dm755 ${scipJavaStandalone}/bin/scip-java "$out/bin/scip-java"
            patchShebangs "$out/bin/scip-java"
            wrapProgram "$out/bin/scip-java" \
              --prefix PATH : ${lib.makeBinPath [ runtimeJdk ]}
          '';
          meta.mainProgram = "scip-java";
        };
      in
      {
        packages = {
          default = scipJava;
          scip-java = scipJava;
        };

        apps = {
          default = flake-utils.lib.mkApp { drv = scipJava; };
          scip-java = flake-utils.lib.mkApp { drv = scipJava; };
        };

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
          scalafmt = pkgs.runCommand "check-scalafmt" { buildInputs = [ pkgs.git ]; } ''
            cp -r ${./.}/. .
            chmod -R u+w .
            git init -q
            git add -A
            HOME=$(mktemp -d) ${pkgs.scalafmt}/bin/scalafmt --check --non-interactive
            touch $out
          '';
          shellcheck = pkgs.runCommand "check-shellcheck" { } ''
            ${pkgs.shellcheck}/bin/shellcheck ${./bin}/*.sh
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

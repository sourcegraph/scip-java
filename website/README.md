# SCIP-Java Website

## Setup

```bash
$ git@github.com:sourcegraph/scip-java.git
$ cd scip-java/
$ yarn install
```

## Start

```bash
# In one terminal window, requires a Java installation
$ ./sbt "docs/mdoc -w"
# In a separate terminal window
$ cd website/
$ yarn run start
```

## Troubleshoot

```bash
$ yarn global add docusaurus --dev
```
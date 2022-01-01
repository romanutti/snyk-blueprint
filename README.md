# Snyk demo application

This repository contains a vulnerable application, used to showcase how to secure your application using [Snyk ecosystem](https://snyk.io/).

It depends on a [pre-initialized project](https://start.spring.io/) using
* `spring-boot` on version `2.6.1`,
* `log-4j-core` (through `spring-boot-starter-log4j2`) and
* `openjdk:8u181`

## Getting started

### Running the application

Run it:

```bash
docker run --name snyk-demo-app --rm -p 8080:8080 romanutti/snyk-demo-app
```

Or alternatively, build it yourself:

```bash
docker build . -t snyk-demo-app
docker run -p 8080:8080 --name snyk-demo-app --rm snyk-demo-app
```

### Fixing the application

We will step by step fix the following aspects of the application (see respective branches):
* [code-vulnerabilities](https://github.com/romanutti/snyk-demo-app/tree/code-vulnerabilities)
* [oss-vulnerabilities](https://github.com/romanutti/snyk-demo-app/tree/oss-vulnerabilities)
* [container-vulnerabilities](https://github.com/romanutti/snyk-demo-app/tree/container-vulnerabilities)
* [iac-vulnerabilities](https://github.com/romanutti/snyk-demo-app/tree/iac-vulnerabilities)

By merging those changes to the `main` branch you will end up with a secure application.
The initial state is always available in branch `initial-setup`.

## Reference

https://docs.snyk.io/tutorials/github   
https://github.com/romanutti/log4shell-vulnerable-app


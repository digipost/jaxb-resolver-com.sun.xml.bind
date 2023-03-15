[![Maven Central](https://maven-badges.herokuapp.com/maven-central/no.digipost/jaxb-resolver-com.sun.xml.bind/badge.svg)](https://maven-badges.herokuapp.com/maven-central/no.digipost/jaxb-resolver-com.sun.xml.bind)
[![Build and publish](https://github.com/digipost/jaxb-resolver-com.sun.xml.bind/workflows/Build%20and%20publish/badge.svg)](https://github.com/digipost/jaxb-resolver-com.sun.xml.bind/actions)
[![License](https://img.shields.io/badge/license-Apache%202-blue)](LICENSE)

# Digipost JAXB Resolver for com.sun.xml.bind

This is a helper library to enable using the earlier JAXB stack (where the API
is using the package `javax.xml.bind`) _together_ with the newer Jakarta-branded
JAXB versions.


## Usage

The preferred way to use this library is to declare _dependency management_ on
the BOM:
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>no.digipost</groupId>
      <artifactId>jaxb-resolver-com.sun.xml.bind-bom</artifactId>
      <version><!-- insert latest version --></version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
```

And declare runtime dependency on `no.digipost:jaxb-resolver-com.sun.xml.bind`:
```xml
<dependency>
  <groupId>no.digipost</groupId>
  <artifactId>jaxb-resolver-com.sun.xml.bind</artifactId>
  <scope>runtime</scope>
</dependency>
```

`jaxb-resolver-com.sun.xml.bind` sets up JAXB discovery for `javax.xml.bind` to
resolve to the `com.sun.xml.bind` implementation, and the BOM also ensures
dependencies to the old non-Jakarta JAXB API and commonly used reference
implementation, i.e:
- javax.xml.bind:jaxb-api:2.3.1
- com.sun.xml.bind:jaxb-impl:2.3.2

The JAXB-dependencies are carefully chosen so that no Jakarta-branded
dependencies are included, which means that anyone depending
on this library are free to _also_ depend on and resolve JAXBContexts using the
newer Jakarta-branded dependencies, and the two variants should not interfere
with each other.



## Validate

Whenever an invocation happens to `JAXBContext.newInstance(..)`, you should see
an INFO-message logged to the `no.digipost.jaxb.context.OldJaxb2ContextFactory`
logger with information about the created JAXB context, which should be
`com.sun.xml.bind.v2.runtime.JAXBContextImpl`, and the classes bound to the
context.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/no.digipost/jaxb-resolver-com.sun.xml.bind/badge.svg)](https://maven-badges.herokuapp.com/maven-central/no.digipost/jaxb-resolver-com.sun.xml.bind)
[![Build and publish](https://github.com/digipost/jaxb-resolver-com.sun.xml.bind/workflows/Build%20and%20publish/badge.svg)](https://github.com/digipost/jaxb-resolver-com.sun.xml.bind/actions)
[![License](https://img.shields.io/badge/license-Apache%202-blue)](LICENSE)

# Digipost JAXB Resolver for com.sun.xml.bind

This is a helper library to enable using the earlier JAXB stack (where the API
is using the package `javax.xml.bind`) _together_ with the newer Jakarta-branded
JAXB versions.

Depending on this library will set up dependencies on specifically:
- javax.xml.bind:jaxb-api:2.3.1
- com.sun.xml.bind:jaxb-impl:2.3.2

As well as set up JAXB discovery for `javax.xml.bind` to resolve to the
`com.sun.xml.bind` implementation. The dependencies are carefully chosen so
that no jakarta-branded dependencies are included, which means that anyone depending
on this library are free to _also_ depend on and resolve JAXBContexts using the
newer jakarta-branded dependencies, and the two versions should not interfere.

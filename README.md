



instagram4j-rx
========

RxJava wrapper for Java wrapper using OkHttpClient for Instagram's private api (Android emulation)
## Table of contents
- [Install](#install)
- [Overview](#overview)
    - [Features](#features)
- [Usage](#usage)
    - [Terms and Conditions](#terms-and-conditions)
    - [Quick Usage](#quick-usage)
    - [Serialization](#serialization)
- [Contributing](#contributing)

# Install

#### Example for gradle:
```java
dependencies {
    implementation 'com.github.instagram4j:instagram4j:2.0.2'
    implementation 'com.github.smclt30p.instagram4j-rx:1.2'
    implementation "io.reactivex.rxjava3:rxjava:3.0.9"
}
```

## Requirements
This project depends on
- Java 8+
- RxJava 3
- instagram4j and its dependencies
# Overview
This Java library provides requests that emulate the Android Instagram app. Most of the official app functionality is supported here. This library has undergone a massive rewrite (instagram4j 1.x.x is not compatible) The rewrite intends to help with maintainability and flexibility throughout time.
## Features
Most of the Android Instagram app features are supported. Here are some notable ones.
- OkHttpClient and jackson-databind
- two factor login
- support for challenges
- iterable feeds
- serialization
- timeline, story, live, direct messaging, shopping, and more!

# Usage
## Terms and Conditions
This library is intended for personal use and for educational experiences due to limitations of Instagram's public API.

- Please use Instagram's public API if possible
- Do not use this library to spam (botting, spam messaging, etc...)
- There will be no support for those with malicious intent
- Use reasonable (human) delay in between sending requests
- Don't be evil.

This library is in no way affiliated with, authorized, maintained, sponsored or endorsed by Instagram or any of its affiliates or subsidiaries. This is an independent and unofficial API. Use at your own risk.

Contributors are not responsible for usage and maintainability. Due to the nature of this project, some features of the library are not guaranteed as they make change and break in the future. This library is licensed under ASL.

---
## Quick Usage
**Login:**
```java
RXIGClient.login("user", "password")
    .subscribe((client) -> {
        // use the client
    }, (e) -> {
        // handle error
    }).dispose();
```
**Actions:**
```java
RXIGClient.login ...

client.timelineActions().uploadPhoto(new File("file.jpg"), "My Caption")
    .subscribe((response) -> {
        // handle response
    }, (e) -> {
        // handle error
    }).dispose();
```

## Serialization
IGClient is a Serializable object that can be saved and later reconstructed. **Session cookies however must be separately serialized**. Session cookies for OkHttpClient are done through an implementation of CookieJar. You may provide your own implementation of a serializable cookie jar and then serialize your cookies for later use. Session cookies are good for 90 days and avoids relogins.

See example for serialization and deserialization [here](https://github.com/instagram4j/instagram4j/blob/c2c4a0da8b18dce86900bb1af2393b6d0265b096/src/examples/java/serialize/SerializeTestUtil.java#L34).
# Contributing
See Issues tab to find good starting issues to work on. If you have an addition you would like to make, please do not hesitate to make a pull request!
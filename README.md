# FancyLog
Super simple library for super easy console logging

## Installation
Include the Maven artifact:
```xml
<dependency>
    <groupId>com.github.m4schini</groupId>
    <artifactId>FancyLog</artifactId>
    <version>1.0.0</version>
</dependency>
```
Or include the [JAR](https://github.com/m4schini/FancyLog/releases) in your project.

## Features
Every line is printed with a timestamp: "HH:mm:ss > "
```java
Log.status(Object text);    //Standard println output
Log.success(Object text);   //green text
Log.warning(Object text);   //"Warning: " yellow text
Log.error(Object text);     //"Error: " red text)
Log.critical(Object text);  //"Critical: " Red background and black text   

Log.divide();   //Prints: -------------------------------------
```
```java
Log.loading(10);  =>  |##############################| 100%
Log.loading(5);   =>  |###############               |  50%
Log.loading(1);   =>  |###                           |  10%

Log.loading(-1);  =>  |------------------------------| 0%
```

# FancyLog
Super simple library for super easy console logging

## Installation
Include the Maven artifact:
```xml
<dependency>
    <groupId>com.github.m4schini</groupId>
    <artifactId>FancyLog</artifactId>
    <version>2.1.0</version>
</dependency>
```
Or include the [JAR](https://github.com/m4schini/FancyLog/releases) in your project.

## Features
Every line is printed with a timestamp: "HH:mm:ss > "
```java
Log.status(Object text);    //Standard println output
Log.success(Object text);   //green text
Log.warning(Object text);   //"Warning: " yellow text
Log.error(Object text);     //"Error: " red text
Log.critical(Object text);  //"Critical: " Red background and black text   

Log.divide();   //Prints: -------------------------------------
```
You can also print a loadingbar if your programm, well, needs to load something...
This was propably kind of obvious.
```java
//Range: 0-10
Log.loading(10);  =>  |##############################| 100%
Log.loading(0);   =>  |                              |  0%

Log.loading(-1);  =>  |------------------------------| 0%
```
You can easily turn logging on and off.
```java
log.enableLog(true);        //enable log
log.enableLog(false);       //disable log
```

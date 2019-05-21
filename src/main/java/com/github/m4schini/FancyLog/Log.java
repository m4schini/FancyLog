package com.github.m4schini.FancyLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 * Super simple library for super easy console logging
 * @author m4schini
 *
 * MIT License
 * Copyright (c) 2019 Malte Schink (malteschink.de)
 */
public class Log {
  
  /**
   * Settings
   */
  private static boolean enableLog = true;
  private static String TIMESTAMP_PATTERN = "HH:mm:ss:SSS > ";
  
  /**
   * Turn logging to console on or off
   * @param enable true = on | false = off
   */
  public static void enableLog(boolean enable) {
    enableLog = enable;
  }
  
  
  /**
   * Prints input with timestamp
   * @param input content of console output
   */
  public static void status(Object input) {
    write(input);
  }
  
  /**
   * Prints input in green with timestamp
   * @param input content of console output
   */
  public static void success(Object input) {
    write(ANSI_GREEN + input + ANSI_RESET);
  }
  
  /**
   * Prints input in red with timestamp and "Error: " at the start
   * @param input content of console output
   */
  public static void error(Object input) {
    write(ANSI_RED + "Error: " + input + ANSI_RESET);
  }
  
  /**
   * Prints input in yelloq with timestamp and "Warning: " at the start
   * @param input content of console output
   */
  public static void warning(Object input) {
    write(ANSI_YELLOW + "Warning: " + input + ANSI_RESET);
  }
  
  /**
   * Prints input with red background, timestamp and "CRITICAL: " at the start
   * @param input content of console output
   */
  public static void critical(Object input) {
    write(ANSI_RED_BACKGROUND + ANSI_BLACK + "CRITICAL: " + input + ANSI_RESET);
  }
  
  /**
   * Prints error, location and cause
   * @param exception thrown exception
   */
  public static void exception(Exception exception) {
    error("\b\b in: " + exception.getStackTrace()[0]);
    error("\b\b was caused by: " + ANSI_RESET + exception.getCause());
    error(ANSI_RESET + exception.toString());
  }
  
  
  /**
   * Prints dashed line to console
   */
  public static void divide() {
    write(DIV_DASH);
  }
  
  /**
   * Checks if logging is enabled and prints Log to console if enabled
   * @param input content of user specified console output
   */
  private static void write(Object input) {
    if (enableLog) {
      System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN)) + input);
    }
  }
  
  /**
   * Prints a loadingbar to console. You can have a maximun of 10 10%-steps.
   * If you have to abort the loading process input -1 or you have to print \n before the next line of output
   * @implNote This is not dependend on the "write" method
   * @implNote This is a console-only method
   *
   * @param part 0-10 = 10% Steps | -1 = abort
   */
  public static void loading(int part) {
    if (enableLog) {
      int percentage;
      StringBuilder dashes = new StringBuilder();
      
      switch (part) {
        case -1:
          percentage = 0;
          dashes.append(ANSI_RED + "------------------------------" + ANSI_RESET);
          break;
        default:
          percentage = part * 10;
          dashes.append("###".repeat(part));
          break;
      }
      
      System.out.print(
              DELETE_LINE +
              LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN)) +
              String.format("|%-30s| ", dashes) + percentage + "%");
  
      if (percentage >= 100 || part == -1)
        System.out.println();
    }
  }
  
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_BLACK = "\u001B[30m";
  private static final String ANSI_GREY = "\u001B[37m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_BLUE = "\u001B[34m";
  private static final String ANSI_PURPLE = "\u001B[35m";
  private static final String ANSI_CYAN = "\u001B[36m";
  private static final String ANSI_WHITE = "\u001B[37m";
  
  private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
  
  private static final String DIV_DASH = "-------------------------------------";
  private static final String DIV_PLUS = "+++++++++++++++++++++++++++++++++++++";
  private static final String DIV_HSHT = "#####################################";
  private static final String DELETE_LINE = "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b";
}
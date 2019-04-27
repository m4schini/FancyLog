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
  private static boolean enableLog = true;
  
  public Log() {
  }
  
  public void enableLog(boolean enable) {
    enableLog = enable;
  }
  public void enableLog(boolean enable, boolean log_change) {
    if (log_change) {
      if (enable) {
        enableLog = true;
        warning("Log is now enabled");
      } else {
        warning("Log is now disabled");
        enableLog = false;
      }
    }
  }
  
  private static void write(Object text) {
    if (enableLog) {
      System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " > " + text);
    }
  }
  
  public static void status(Object text) {
    write(text);
  }
  
  public static void success(Object text) {
    write(ANSI_GREEN + text + ANSI_RESET);
  }
  
  public static void error(Object text) {
    write(ANSI_RED + "Error: " + text + ANSI_RESET);
  }
  
  public static void warning(Object text) {
    write(ANSI_YELLOW + "Warning: " + text + ANSI_RESET);
  }
  
  public static void critical(Object text) {
    write(ANSI_RED_BACKGROUND + ANSI_BLACK + "CRITICAL: " + text + ANSI_RESET);
  }
  
  public static void divide() {
    write(DIV_DASH);
  }
  
  /**
   * Prints a loadingbar to console. You can have a maximun of 10 10%-steps.
   * If you have to abort the loading process input -1 or you have to print \n before the next line of output
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
              LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " > " +
              String.format("|%-30s| ", dashes) + percentage + "%");
  
      if (percentage >= 100 || part == -1)
        System.out.println();
    }
  }
  
  private static final String ANSI_BLACK = "\u001B[30m";
  private static final String ANSI_RESET = "\u001B[0m";
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
  private static final String DELETE_LINE = "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b";
}
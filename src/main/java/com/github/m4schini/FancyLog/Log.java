package com.github.m4schini.FancyLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 * A method that makes console logging a lot prettier and easier.
 *
 * MIT License
 * Copyright (c) 2019 Malte Schink (malteschink.de)
 */
public class Log {
  //This will not disable the loading methode
  private static boolean enable_log = true;
  public Log(boolean enable) {
    enable_log = enable;
  }
  
  private void write(Object text) {
    if (enable_log) {
      System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " > " + text);
    }
  }
  
  public void status(Object text) {
    write(text);
  }
  
  public void success(Object text) {
    write(ANSI_GREEN + text + ANSI_RESET);
  }
  
  public void error(Object text) {
    write(ANSI_RED + "Error: " + text + ANSI_RESET);
  }
  
  public void warning(Object text) {
    write(ANSI_YELLOW + "Warning: " + text + ANSI_RESET);
  }
  
  public void critical(Object text) {
    write(ANSI_RED_BACKGROUND + ANSI_BLACK + "CRITICAL: " + text + ANSI_RESET);
  }
  
  public void divide() {
    write(DIV_DASH);
  }
  
  public void loading(int part) {
    if (enable_log) {
      int percentage = part * 10;
      StringBuilder dashes = new StringBuilder();
  
      for (int i = 0; i < part; i++) {
        dashes.append("###");
      }
      
      System.out.print(
              DELETE_LINE +
              LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " > " +
              String.format("|%-30s| ", dashes) + percentage + "%");
  
      if (percentage >= 100)
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
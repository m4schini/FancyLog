import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 * A method that makes console logging a lot prettier and easier.
 *
 * MIT License
 * Copyright (c) 2019 Malte Schink (malteschink.de)
 */
public class Log {
  static boolean enable_log = true;
  private static void write(Object text) {
    if (enable_log) {
      System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " > " + text);
    }
  }
  
  static void status(Object text) {
    write(text);
  }
  
  static void success(Object text) {
    write(ANSI_GREEN + text + ANSI_RESET);
  }
  
  static void error(Object text) {
    write(ANSI_RED + "Error: " + text + ANSI_RESET);
  }
  
  static void warning(Object text) {
    write(ANSI_YELLOW + "Warning: " + text + ANSI_RESET);
  }
  
  static void critical(Object text) {
    write(ANSI_RED_BACKGROUND + ANSI_BLACK + "CRITICAL: " + text + ANSI_RESET);
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
}
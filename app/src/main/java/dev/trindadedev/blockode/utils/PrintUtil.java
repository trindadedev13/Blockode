package dev.trindadedev.blockode.utils;

import java.util.ArrayList;
import java.util.List;

public class PrintUtil {

  private static final List<String> allLogs = new ArrayList<>();

  public static void print(final Object toPrint) {
    allLogs.add(String.valueOf(toPrint));
    System.out.print(toPrint);
  }
}

package dev.trindadedev.blockode.utils;

import dev.trindadedev.blockode.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

  FileUtil() {}

  public static boolean isExistFile(String path) {
    return new File(path).exists();
  }

  public static void makeDir(String path) {
    if (!isExistFile(path)) {
      new File(path).mkdirs();
    }
  }

  public static void createNewFileIfNotPresent(String path) {
    int lastSep = path.lastIndexOf(File.separator);
    if (lastSep > 0) {
      String dirPath = path.substring(0, lastSep);
      makeDir(dirPath);
    }

    File file = new File(path);

    try {
      if (!file.exists()) file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String readFile(String path, boolean createIfNotExists) {
    if (createIfNotExists) createNewFileIfNotPresent(path);
    StringBuilder sb = new StringBuilder();
    try (FileReader fr = new FileReader(path)) {
      char[] buff = new char[1024];
      int length;

      while ((length = fr.read(buff)) > 0) {
        sb.append(new String(buff, 0, length));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return sb.toString();
  }

  public static String readFileIfExist(String path) {
    StringBuilder sb = new StringBuilder();
    try (FileReader fr = new FileReader(path)) {
      char[] buff = new char[1024];
      int length;

      while ((length = fr.read(buff)) > 0) {
        sb.append(new String(buff, 0, length));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return sb.toString();
  }

  public static void writeText(final String path, final String text) {
    createNewFileIfNotPresent(path);

    try (FileWriter fileWriter = new FileWriter(path, false)) {
      fileWriter.write(text);
      fileWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

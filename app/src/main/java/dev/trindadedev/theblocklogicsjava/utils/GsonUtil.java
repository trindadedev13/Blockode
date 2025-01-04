package dev.trindadedev.theblocklogicsjava.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
  GsonUtil() {}

  public static Gson getGson() {
    return new GsonBuilder().setPrettyPrinting().create();
  }
}

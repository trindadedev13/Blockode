package dev.trindadedev.blockode.os;

public interface Permission {
  void request();

  boolean check();
}

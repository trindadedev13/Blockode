package dev.trindadedev.blockode.utils.variable;

public class Atomic<T> {

  private T value;

  public Atomic(final T value) {
    this.value = value;
  }

  public T get() {
    return this.value;
  }

  public void set(final T value) {
    this.value = value;
  }
}

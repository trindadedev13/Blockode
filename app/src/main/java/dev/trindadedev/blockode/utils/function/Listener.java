package dev.trindadedev.blockode.utils.function;

@FunctionalInterface
public interface Listener<T> {
  void call(final T value);
}

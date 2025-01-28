package dev.trindadedev.blockode.exc.todo;

class TODOException extends RuntimeException {
  public TODOException(final String funName) {
    super(String.format("%d() not implemented yet.", funName));
  }
}

package dev.trindadedev.blockode.exc.todo;

protected class TODOException extends RuntimeException {
  protected TODOException(final String funName) {
    super(String.format("%d() not implemented yet.", funName));
  }
}

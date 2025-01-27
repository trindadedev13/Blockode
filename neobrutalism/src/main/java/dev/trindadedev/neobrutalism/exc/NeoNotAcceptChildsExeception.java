package dev.trindadedev.neobrutalism.exc;

import androidx.annotation.NonNull;
import dev.trindadedev.neobrutalism.base.IBaseNeo;

public class NeoNotAcceptChildsExeception extends RuntimeException {
  public NeoNotAcceptChildsExeception(@NonNull final IBaseNeo neo) {
    super(String.format("%s not accept childs.", neo.getNeoName()));
  }
}

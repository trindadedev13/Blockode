package dev.trindadedev.blockode.base;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;

public class Inflator extends Contextualizable {

  protected LayoutInflater layoutInflater;

  public Inflator(@NonNull final Context context) {
    super(context);
    layoutInflater = LayoutInflater.from(context);
  }

  @NonNull
  protected LayoutInflater getLayoutInflater() {
    return layoutInflater;
  }
}

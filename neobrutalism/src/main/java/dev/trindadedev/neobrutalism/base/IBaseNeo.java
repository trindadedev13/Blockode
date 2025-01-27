package dev.trindadedev.neobrutalism.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IBaseNeo {
  void init(
      @NonNull final Context context,
      @Nullable final AttributeSet attrs,
      @Nullable final int defStyleRes);

  @NonNull
  String getNeoName();

  @NonNull
  View getNeoRoot();
}

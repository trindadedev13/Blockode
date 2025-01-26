package dev.trindadedev.neobrutalism;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

public abstract class BaseNeoRelativeLayout extends RelativeLayout {
  public BaseNeoRelativeLayout(final Context context) {
    super(context);
  }

  public BaseNeoRelativeLayout(final Context context, final AttributeSet attrs) {
    super(context, attrs);
  }

  public BaseNeoRelativeLayout(
      final Context context, final AttributeSet attrs, final int defStyleRes) {
    super(context, attrs, defStyleRes);
  }

  @NonNull
  protected abstract View getRoot();

  @Override
  public void setOnClickListener(OnClickListener onClickListener) {
    getRoot().setOnClickListener(onClickListener);
  }
}

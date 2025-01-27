package dev.trindadedev.neobrutalism;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BaseNeoRelativeLayout extends RelativeLayout {
  protected static final int INT_NULL = -1;

  public BaseNeoRelativeLayout(final Context context) {
    super(context);
    init(context, null, INT_NULL);
  }

  public BaseNeoRelativeLayout(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, INT_NULL);
  }

  public BaseNeoRelativeLayout(
      final Context context, final AttributeSet attrs, final int defStyleRes) {
    super(context, attrs, defStyleRes);
    init(context, attrs, defStyleRes);
  }

  @NonNull
  protected abstract View getRoot();

  protected abstract void init(
      @NonNull final Context context,
      @Nullable final AttributeSet attrs,
      @Nullable final int defStyleRes);

  @Override
  public void setOnClickListener(OnClickListener onClickListener) {
    getRoot().setOnClickListener(onClickListener);
  }
}

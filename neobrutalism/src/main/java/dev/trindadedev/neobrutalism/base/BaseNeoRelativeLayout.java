package dev.trindadedev.neobrutalism.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class BaseNeoRelativeLayout extends RelativeLayout implements IBaseNeo {
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

  @Override
  public void setOnClickListener(OnClickListener onClickListener) {
    getNeoRoot().setOnClickListener(onClickListener);
  }
}

package dev.trindadedev.neobrutalism.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dev.trindadedev.neobrutalism.exc.NeoNotAcceptChildsExeception;

public abstract class BaseNeoRelativeLayoutNoChild extends BaseNeoRelativeLayout
    implements IBaseNeo {
  protected static final int INT_NULL = -1;

  public BaseNeoRelativeLayoutNoChild(final Context context) {
    super(context);
    init(context, null, INT_NULL);
  }

  public BaseNeoRelativeLayoutNoChild(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, INT_NULL);
  }

  public BaseNeoRelativeLayoutNoChild(
      final Context context, final AttributeSet attrs, final int defStyleRes) {
    super(context, attrs, defStyleRes);
    init(context, attrs, defStyleRes);
  }

  // just add views if its Root View
  @Override
  public void addView(final View child) {
    if (child != getNeoRoot()) {
      throw new NeoNotAcceptChildsExeception(this);
    } else {
      super.addView(child);
    }
  }

  @Override
  public void addView(final View child, int index) {
    if (child != getNeoRoot()) {
      throw new NeoNotAcceptChildsExeception(this);
    } else {
      super.addView(child, index);
    }
  }

  @Override
  public void addView(final View child, int width, int height) {
    if (child != getNeoRoot()) {
      throw new NeoNotAcceptChildsExeception(this);
    } else {
      super.addView(child, width, height);
    }
  }

  @Override
  public void addView(final View child, ViewGroup.LayoutParams params) {
    if (child != getNeoRoot()) {
      throw new NeoNotAcceptChildsExeception(this);
    } else {
      super.addView(child, params);
    }
  }
}

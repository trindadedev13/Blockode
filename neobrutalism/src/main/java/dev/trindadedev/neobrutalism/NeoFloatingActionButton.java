package dev.trindadedev.neobrutalism;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.DrawableRes;
import dev.trindadedev.neobrutalism.databinding.NeoFloatingActionButtonBinding;

public class NeoFloatingActionButton extends BaseNeoRelativeLayout {

  private NeoFloatingActionButtonBinding binding;

  public NeoFloatingActionButton(final Context context) {
    super(context);
    init(null);
  }

  public NeoFloatingActionButton(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public NeoFloatingActionButton(
      final Context context, final AttributeSet attrs, final int defStyleRes) {
    super(context, attrs, defStyleRes);
    init(attrs);
  }

  private void init(final AttributeSet attrs) {
    binding = NeoFloatingActionButtonBinding.inflate(LayoutInflater.from(getContext()), this, true);

    final var attributes =
        getContext().obtainStyledAttributes(attrs, R.styleable.NeoFloatingActionButton, 0, 0);
    final var icon = attributes.getDrawable(R.styleable.NeoFloatingActionButton_fabIcon);
    setIcon(icon);
  }

  public void setIcon(@DrawableRes final int imageResId) {
    binding.fabIcon.setImageResource(imageResId);
  }

  public void setIcon(final Drawable drawable) {
    binding.fabIcon.setImageDrawable(drawable);
  }

  @Override
  protected View getRoot() {
    return binding.fabRoot;
  }
}

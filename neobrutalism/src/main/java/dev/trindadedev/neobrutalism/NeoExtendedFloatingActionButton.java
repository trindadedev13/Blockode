package dev.trindadedev.neobrutalism;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.DrawableRes;
import dev.trindadedev.neobrutalism.databinding.NeoExtendedFloatingActionButtonBinding;

public class NeoExtendedFloatingActionButton extends BaseNeoRelativeLayout {

  private NeoExtendedFloatingActionButtonBinding binding;

  public NeoExtendedFloatingActionButton(final Context context) {
    super(context);
    init(null);
  }

  public NeoExtendedFloatingActionButton(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public NeoExtendedFloatingActionButton(
      final Context context, final AttributeSet attrs, final int defStyleRes) {
    super(context, attrs, defStyleRes);
    init(attrs);
  }

  private void init(final AttributeSet attrs) {
    binding =
        NeoExtendedFloatingActionButtonBinding.inflate(
            LayoutInflater.from(getContext()), this, true);

    final var attributes =
        getContext().obtainStyledAttributes(attrs, R.styleable.NeoFloatingActionButton, 0, 0);
    final var attributesExtended =
        getContext()
            .obtainStyledAttributes(attrs, R.styleable.NeoExtendedFloatingActionButton, 0, 0);
    final var icon = attributes.getDrawable(R.styleable.NeoFloatingActionButton_fabIcon);
    final var text =
        attributesExtended.getString(R.styleable.NeoExtendedFloatingActionButton_fabText);
    setIcon(icon);
    setText(text);
  }

  public void setIcon(@DrawableRes final int imageResId) {
    binding.fabIcon.setImageResource(imageResId);
  }

  public void setIcon(final Drawable drawable) {
    binding.fabIcon.setImageDrawable(drawable);
  }

  public void setText(final String text) {
    binding.fabText.setText(text);
  }

  @Override
  protected View getRoot() {
    return binding.fabRoot;
  }

  @Override
  public void setOnClickListener(OnClickListener onClickListener) {
    binding.fabRoot.setOnClickListener(onClickListener);
  }
}

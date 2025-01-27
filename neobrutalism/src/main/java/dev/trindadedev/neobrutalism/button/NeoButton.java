package dev.trindadedev.neobrutalism.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dev.trindadedev.neobrutalism.R;
import dev.trindadedev.neobrutalism.base.BaseNeoRelativeLayoutNoChild;
import dev.trindadedev.neobrutalism.databinding.NeoButtonBinding;

public class NeoButton extends BaseNeoRelativeLayoutNoChild {

  private NeoButtonBinding binding;

  public NeoButton(final Context context) {
    super(context);
  }

  public NeoButton(final Context context, final AttributeSet attrs) {
    super(context, attrs);
  }

  public NeoButton(final Context context, final AttributeSet attrs, final int defStyleRes) {
    super(context, attrs, defStyleRes);
  }

  @Override
  public void init(
      @NonNull final Context context,
      @Nullable final AttributeSet attrs,
      @Nullable final int defStyleRes) {
    /*
    *  do not use inflate(LayoutInflater, ViewGroup, Boolean) here
       will cause NullPointerExpetion!.
    *  why?: this method will use NeoButton#addView,
       but is not supported because of it not accept childs,
       but accept childs with same value of neoRoot,
       but at this point, neoRoot value is Still null,
       and the super class couldn't verify if its root or not.
    *  btw, this goes for all Components that extends the BaseNeoRelativeLayoutNoChild.
    */
    binding = NeoButtonBinding.inflate(LayoutInflater.from(context));
    // here we can call addView(View) safely
    addView(getNeoRoot()); // at this point, neoRoot not is null
    var attributes = context.obtainStyledAttributes(attrs, R.styleable.NeoButton, 0, 0);
    var text = attributes.getString(R.styleable.NeoButton_android_text);
    setText(text);
  }

  public void setText(final String text) {
    binding.buttonText.setText(text);
  }

  public CharSequence getText() {
    return binding.buttonText.getText();
  }

  @Override
  @NonNull
  public String getNeoName() {
    return "NeoButton";
  }

  @Override
  @NonNull
  public View getNeoRoot() {
    return binding.getRoot();
  }
}

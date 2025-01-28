package dev.trindadedev.blockode.base;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class BaseInputValidator implements TextWatcher, InputFilter {
  protected Context context;
  protected EditText editText;
  protected int errTextRes;
  protected TextInputLayout textInputLayout;
  protected boolean valid;

  public BaseInputValidator(final Context context, final TextInputLayout textInputLayout) {
    this.context = context;
    this.textInputLayout = textInputLayout;
    this.editText = textInputLayout.getEditText();
    this.editText.setFilters(new InputFilter[] {this});
    this.editText.addTextChangedListener(this);
  }

  @Override
  public void afterTextChanged(final Editable editable) {
    if (editable.length() == 0) {
      this.textInputLayout.setErrorEnabled(false);
    }
  }

  @Override
  public void beforeTextChanged(
      final CharSequence charSequence, final int i, final int i2, final int i3) {}

  public boolean isValid() {
    if (!this.valid) {
      this.editText.requestFocus();
    }
    return this.valid;
  }

  public void setErrorTextRes(final int resId) {
    this.errTextRes = resId;
  }

  public void setText(final String str) {
    this.valid = true;
    this.editText.setText(str);
  }
}

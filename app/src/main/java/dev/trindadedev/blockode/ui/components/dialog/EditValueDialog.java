package dev.trindadedev.blockode.ui.components.dialog;

import android.content.Context;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.utils.StringUtil;
import java.util.function.Consumer;

public class EditValueDialog extends PropertyInputDialog {

  protected Consumer<String> onSaveConsumer;

  public EditValueDialog(@NonNull final Context context) {
    super(context);
  }

  @Override
  public void show() {
    switch (type) {
      case PropertyInputDialog.PROPERTY_TYPE_INTEGER ->
          setTitle(StringUtil.getString(R.string.title_popup_input_int_value));
      case PropertyInputDialog.PROPERTY_TYPE_STRING ->
          setTitle(StringUtil.getString(R.string.title_popup_input_str_value));
    }
    ;
    super.show();
  }

  @NonNull
  public EditText getEditText() {
    return binding.edInput;
  }

  @NonNull
  public TextInputLayout getTextInputLayout() {
    return binding.tiInput;
  }

  @Override
  protected void onSaveValue(@NonNull String value) {
    onSaveConsumer.accept(value);
  }

  public void setOnSave(@NonNull Consumer<String> onSaveConsumer) {
    this.onSaveConsumer = onSaveConsumer;
  }
}

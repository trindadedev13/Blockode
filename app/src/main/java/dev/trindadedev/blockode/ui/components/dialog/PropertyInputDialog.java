package dev.trindadedev.blockode.ui.components.dialog;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.base.Inflator;
import dev.trindadedev.blockode.databinding.PropertyPopupInputTextBinding;
import dev.trindadedev.blockode.utils.LayoutUtil;

public abstract class PropertyInputDialog extends Inflator {

  public static final int PROPERTY_TYPE_INTEGER = 0;
  public static final int PROPERTY_TYPE_STRING = 1;

  protected final AlertDialog dialog;
  protected final Context context;
  protected final PropertyPopupInputTextBinding binding;
  protected int type;
  protected String title;

  public PropertyInputDialog(@NonNull Context context) {
    super(context);
    this.context = context;
    this.binding = PropertyPopupInputTextBinding.inflate(getLayoutInflater());
    this.dialog =
        new MaterialAlertDialogBuilder(context)
            .setView(binding.getRoot())
            .setCancelable(true)
            .setPositiveButton(
                context.getString(R.string.common_word_save),
                (d, w) -> onSaveValue(binding.edInput.getText().toString()))
            .setNegativeButton(
                context.getString(R.string.common_word_cancel), (d, w) -> d.dismiss())
            .create();
    this.dialog.setTitle(title);
  }

  /**
   * Enables or disables the "Save" button.
   *
   * @param enabled true to enable, false to disable.
   */
  public void setPositiveButtonEnabled(boolean enabled) {
    if (dialog != null && dialog.isShowing()) {
      dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(enabled);
    }
  }

  /**
   * Sets a new view for the dialog with specific margins.
   *
   * @param view The new view.
   * @param left Left margin in dp.
   * @param top Top margin in dp.
   * @param right Right margin in dp.
   * @param bottom Bottom margin in dp.
   */
  public void setView(@NonNull View view, int left, int top, int right, int bottom) {
    dialog.setView(
        view,
        (int) LayoutUtil.getDip(context, left),
        (int) LayoutUtil.getDip(context, top),
        (int) LayoutUtil.getDip(context, right),
        (int) LayoutUtil.getDip(context, bottom));
  }

  /** Displays the dialog to the user. */
  public void show() {
    if (!dialog.isShowing()) {
      dialog.show();
    }
  }

  /**
   * Sets the dialog's title.
   *
   * @param title New dialog title.
   */
  public void setTitle(@NonNull final String title) {
    this.title = title;
    dialog.setTitle(title);
  }

  /**
   * Gets the current title of the dialog.
   *
   * @return The dialog's title.
   */
  @NonNull
  public String getTitle() {
    return title;
  }

  /**
   * Sets the dialog edittext value
   *
   * @param value New Edittext text
   */
  public void setText(@NonNull final String value) {
    binding.edInput.setText(value);
  }

  /**
   * Sets the property type
   *
   * @param type Constant that represent property type
   */
  public void setPropertyType(@NonNull int type) {
    this.type = type;
  }

  /**
   * Abstract method to be implemented to save the value.
   *
   * @param value The value to be saved.
   */
  protected abstract void onSaveValue(@NonNull String value);
}

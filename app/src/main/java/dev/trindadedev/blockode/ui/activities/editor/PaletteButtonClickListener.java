package dev.trindadedev.blockode.ui.activities.editor;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dev.trindadedev.blockode.base.Inflator;
import dev.trindadedev.blockode.databinding.PropertyPopupInputTextBinding;
import dev.trindadedev.blockode.ui.editor.manager.VariablesManager;

public class PaletteButtonClickListener extends Inflator implements View.OnClickListener {

  private VariablesManager variableManager;
  private View view;
  private String scId;

  public PaletteButtonClickListener(@NonNull final Context context) {
    this(context, null);
  }

  public PaletteButtonClickListener(@NonNull final Context context, @Nullable final String scId) {
    super(context);
    variableManager = new VariablesManager(scId);
    this.scId = scId;
  }

  /**
   * Handle the clicked button in Palette Block.
   *
   * @see PaletteBlockManager
   */
  @Override
  public void onClick(final View view) {
    this.view = view;
    final Object tagObj = view.getTag();
    final String tag = (String) tagObj;

    switch (tag) {
      case ButtonsTag.BUTTON_ADD_VARIABLE -> showCreateVariableDialog();
    }
  }

  /** display a dialog to create new variable in project */
  void showCreateVariableDialog() {
    var binding = PropertyPopupInputTextBinding.inflate(getLayoutInflater());
    new MaterialAlertDialogBuilder(view.getContext())
        .setTitle("Create variable")
        .setView(binding.getRoot())
        .setPositiveButton(
            "OK",
            (d, w) -> {
              d.dismiss();
            })
        .show();
  }

  public String getScId() {
    return this.scId;
  }

  public void setScId(final String scid) {
    this.scId = scId;
  }
}

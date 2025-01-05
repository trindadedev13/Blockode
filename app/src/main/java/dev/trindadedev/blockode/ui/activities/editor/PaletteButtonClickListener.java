package dev.trindadedev.blockode.ui.activities.editor;

import android.view.View;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class PaletteButtonClickListener implements View.OnClickListener {

  private View view;

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
    new MaterialAlertDialogBuilder(view.getContext())
        .setTitle("Create variable")
        .setMessage("Not implemented yet")
        .setPositiveButton(
            "OK",
            (d, w) -> {
              d.dismiss();
            })
        .show();
  }
}

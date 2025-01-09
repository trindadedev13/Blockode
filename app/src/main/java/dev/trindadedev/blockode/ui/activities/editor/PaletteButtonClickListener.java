package dev.trindadedev.blockode.ui.activities.editor;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.base.Inflator;
import dev.trindadedev.blockode.beans.VariableBean;
import dev.trindadedev.blockode.databinding.DialogAddVariableBinding;
import dev.trindadedev.blockode.ui.editor.manager.VariablesManager;
import dev.trindadedev.blockode.utils.BlockUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class PaletteButtonClickListener extends Inflator implements View.OnClickListener {

  private VariablesManager variablesManager;
  private View view;
  private String scId;

  public PaletteButtonClickListener(@NonNull final Context context) {
    this(context, null);
  }

  public PaletteButtonClickListener(@NonNull final Context context, @Nullable final String scId) {
    super(context);
    variablesManager = new VariablesManager(context, scId);
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
    var binding = DialogAddVariableBinding.inflate(getLayoutInflater());
    var selectedType = new AtomicInteger(0);
    binding.varTypeGroup.setOnCheckedChangeListener(
        (rg, checkedId) -> {
          if (checkedId == binding.varTypeString.getId()) {
            selectedType.set(BlockUtil.VAR_TYPE_STRING);
          } else if (checkedId == binding.varTypeInteger.getId()) {
            selectedType.set(BlockUtil.VAR_TYPE_INTEGER);
          } else if (checkedId == binding.varTypeBoolean.getId()) {
            selectedType.set(BlockUtil.VAR_TYPE_BOOLEAN);
          }
        });
    new MaterialAlertDialogBuilder(view.getContext())
        .setTitle("Create variable")
        .setView(binding.getRoot())
        .setPositiveButton(
            view.getContext().getString(R.string.common_word_create),
            (d, w) -> {
              var variable = new VariableBean();
              variable.name = binding.tieName.getText().toString();
              variable.type = selectedType.get();
              variablesManager.addVariable(variable);
              d.dismiss();
            })
        .show();
  }

  public String getScId() {
    return this.scId;
  }

  public void setScId(final String scId) {
    this.scId = scId;
    variablesManager.setScId(scId);
  }

  public VariablesManager getVariablesManager() {
    return this.variablesManager;
  }

  public void setVariablesManager(VariablesManager variablesManager) {
    this.variablesManager = variablesManager;
  }
}

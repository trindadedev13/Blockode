package dev.trindadedev.blockode.ui.activities.editor;

import static dev.trindadedev.blockode.exc.todo.TODO.TODO;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.base.Inflator;
import dev.trindadedev.blockode.beans.VariableBean;
import dev.trindadedev.blockode.databinding.DialogAddVariableBinding;
import dev.trindadedev.blockode.ui.editor.manager.VariableNameValidator;
import dev.trindadedev.blockode.ui.editor.manager.VariablesManager;
import dev.trindadedev.blockode.utils.BlockUtil;
import dev.trindadedev.blockode.utils.variable.Atomic;
import java.util.ArrayList;

public class PaletteButtonClickListener extends Inflator implements View.OnClickListener {

  private VariablesManager variablesManager;
  private View view;
  private String scId;
  private static final String[] RESERVED_WORD =
      new String[] {
        "abstract",
        "boolean",
        "break",
        "byte",
        "case",
        "catch",
        "char",
        "class",
        "const",
        "continue",
        "default",
        "do",
        "double",
        "else",
        "extends",
        "final",
        "finally",
        "float",
        "for",
        "goto",
        "if",
        "implements",
        "import",
        "instanceof",
        "int",
        "interface",
        "long",
        "native",
        "new",
        "null",
        "package",
        "private",
        "protected",
        "public",
        "return",
        "short",
        "static",
        "super",
        "switch",
        "synchronized",
        "this",
        "throw",
        "throws",
        "transient",
        "try",
        "void",
        "volatile",
        "while",
        "ArrayList",
        "String"
      };

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
      case ButtonsTag.BUTTON_REMOVE_VARIABLE -> showRemoveVariableDialog();
      case ButtonsTag.BUTTON_ADD_LIST -> showCreateListDialog();
      case ButtonsTag.BUTTON_REMOVE_LIST -> showRemoveListDialog();
      case ButtonsTag.BUTTON_ADD_BLOCK -> showCreateBlockDialog();
    }
  }

  /** display a dialog to create new variable in project, string, boolean, int */
  void showCreateVariableDialog() {
    var binding = DialogAddVariableBinding.inflate(getLayoutInflater());
    binding.varTypeString.setChecked(true);
    var selectedType = new Atomic<Integer>(BlockUtil.VAR_TYPE_STRING);
    var variablesExisting = new ArrayList<String>();
    variablesManager
        .getVariables()
        .forEach(variableBean -> variablesExisting.add(variableBean.name));
    var variableNameValidator =
        new VariableNameValidator(
            context, binding.tilName, RESERVED_WORD, new String[] {}, variablesExisting);
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
    var builder = new MaterialAlertDialogBuilder(context);
    builder
        .setTitle(context.getString(R.string.title_popup_create_variable))
        .setView(binding.getRoot())
        .setPositiveButton(
            view.getContext().getString(R.string.common_word_create),
            (d, w) -> {
              var variable = new VariableBean();
              variable.name = binding.tieName.getText().toString().replaceAll(" ", "_");
              variable.type = selectedType.get();
              variablesManager.addVariable(variable);
              d.dismiss();
            });

    final AlertDialog dialog = builder.create();
    dialog.setOnShowListener(
        d -> {
          final Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
          positiveButton.setEnabled(variableNameValidator.isValid());
          variableNameValidator.setOnTextChanged(
              () -> {
                positiveButton.setEnabled(variableNameValidator.isValid());
              });
        });

    dialog.show();
  }

  /** displays a dialog to remove existing variables of project */
  void showRemoveVariableDialog() {
    TODO("showRemoveVariableDialog");
  }

  /** displays a dialog to create new list in the project List<String> etc */
  void showCreateList() {
    TODO("showCreateList");
  }

  /** displays a dialog to remove existing lists of project */
  void showRemoveListDialog() {
    TODO("showRemoveListDialog");
  }

  /** displays a dialog to create user own block */
  void showCreateBlockDialog() {
    TODO("showCreateBlockDialog");
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

  public void setVariablesManager(final VariablesManager variablesManager) {
    this.variablesManager = variablesManager;
  }
}

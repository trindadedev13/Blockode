package dev.trindadedev.blockode.ui.components.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.WindowCompat;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.databinding.DialogProgressDialogBinding;
import dev.trindadedev.blockode.utils.StringUtil;

public class ProgressDialog extends Dialog {

  private DialogProgressDialogBinding binding;

  public ProgressDialog(@NonNull final Context context) {
    super(context);
    binding = DialogProgressDialogBinding.inflate(LayoutInflater.from(context));
    setContentView(binding.getRoot());
    setTitle(R.string.common_word_loading);
    super.setCancelable(false);

    var window = getWindow();
    if (window != null) {
      window.setBackgroundDrawableResource(android.R.color.transparent);
      window.setStatusBarColor(0);
      WindowCompat.setDecorFitsSystemWindows(window, false);
    }
  }

  @Override
  public void setTitle(final CharSequence charSeq) {
    binding.text.setText(charSeq);
  }

  @Override
  public void setTitle(@StringRes final int strResId) {
    setTitle(StringUtil.getString(strResId));
  }
}

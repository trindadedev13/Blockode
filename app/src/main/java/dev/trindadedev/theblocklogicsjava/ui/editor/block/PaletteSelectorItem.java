package dev.trindadedev.theblocklogicsjava.ui.editor.block;

/** Decompiled from Sketchware 1.1.13 */

import static dev.trindadedev.theblocklogicsjava.utils.LayoutUtil.getDip;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import dev.trindadedev.theblocklogicsjava.utils.ThemeUtil;
import dev.trindadedev.theblocklogicsjava.databinding.LayoutPaletteSelectorItemBinding;
import dev.trindadedev.theblocklogicsjava.ui.base.Selectable;

public class PaletteSelectorItem extends RelativeLayout implements Selectable {

  private LayoutPaletteSelectorItemBinding binding;

  private int color;
  private int id;
  private boolean selected;
  private String name;

  public PaletteSelectorItem(final Context context, final int id, final String name, final int color) {
    super(context);
    this.color = color;
    this.id = id;
    this.name = name;
    binding = LayoutPaletteSelectorItemBinding.inflate(LayoutInflater.from(getContext()), this, true);
    binding.label.setText(name);
    binding.color.setBackgroundColor(color);
    setSelected(false);
  }

  @Override
  public void setSelected(final boolean selected) {
    this.selected = selected;
    var colorLp = binding.color.getLayoutParams();
    if (selected) {
      binding.label.setTextColor(Color.WHITE);
      colorLp.width = ViewGroup.LayoutParams.MATCH_PARENT;
    } else {
      binding.label.setTextColor(ThemeUtil.getColor(binding.label, com.google.android.material.R.attr.colorOnSurface));
      colorLp.width = (int) getDip(getContext(), 4.0f);
    }
    binding.color.setLayoutParams(colorLp);
  }

  @Override
  public boolean getSelected() {
    return selected;
  }

  public int getColor() {
    return color;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}

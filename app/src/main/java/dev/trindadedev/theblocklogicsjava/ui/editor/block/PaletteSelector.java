package dev.trindadedev.theblocklogicsjava.ui.editor.block;

/** Decompiled from Sketchware 1.1.13 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import dev.trindadedev.theblocklogicsjava.R;
import dev.trindadedev.theblocklogicsjava.utils.LayoutUtil;

public class PaletteSelector extends LinearLayout implements View.OnClickListener {

  private Context context;
  private OnBlockCategorySelectListener onBlockCategorySelectListener;

  public PaletteSelector(final Context context) {
    super(context);
    init(context);
  }

  public PaletteSelector(final Context context, final AttributeSet attributeSet) {
    super(context, attributeSet);
    init(context);
  }

  private void init(final Context context) {
    this.context = context;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    int dip = (int) LayoutUtil.getDip(context, 8.0f);
    int dip2 = (int) LayoutUtil.getDip(context, 4.0f);
    setPadding(dip, dip2, dip, dip2);
    addCategory();
  }

  private void addCategory() {
    addCategoryItem(0, getStr(R.string.block_category_var), 0xffee7d16);
    addCategoryItem(1, getStr(R.string.block_category_list), 0xffcc5b22);
    addCategoryItem(2, getStr(R.string.block_category_control), 0xffe1a92a);
    addCategoryItem(3, getStr(R.string.block_category_operator), 0xff5cb722);
    addCategoryItem(4, getStr(R.string.block_category_math), 0xff23b9a9);
    addCategoryItem(5, getStr(R.string.block_category_file), 0xffa1887f);
    addCategoryItem(6, getStr(R.string.block_category_view_func), 0xff4a6cd4);
  }

  private final String getStr(final int resId) {
    return getResources().getString(resId);
  }

  private void addCategoryItem(final int i, final String str, final int i2) {
    PaletteSelectorItem paletteSelectorItem = new PaletteSelectorItem(context, i, str, i2);
    paletteSelectorItem.setOnClickListener(this);
    addView(paletteSelectorItem);
    if (i == 0) {
      paletteSelectorItem.setSelected(true);
    }
  }

  private void clearSelection() {
    for (int i = 0; i < getChildCount(); i++) {
      View childAt = getChildAt(i);
      if (childAt instanceof PaletteSelectorItem) {
        ((PaletteSelectorItem) childAt).setSelected(false);
      }
    }
  }

  public void onClick(final View view) {
    if (view instanceof PaletteSelectorItem) {
      clearSelection();
      PaletteSelectorItem paletteSelectorItem = (PaletteSelectorItem) view;
      paletteSelectorItem.setSelected(true);
      onBlockCategorySelectListener.onBlockCategorySelect(
          paletteSelectorItem.getId(), paletteSelectorItem.getColor());
    }
  }

  public void setOnBlockCategorySelectListener(
      final OnBlockCategorySelectListener onBlockCategorySelectListener) {
    this.onBlockCategorySelectListener = onBlockCategorySelectListener;
  }
}

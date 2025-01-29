package dev.trindadedev.blockode.ui.editor.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.utils.LayoutUtil;
import java.util.ArrayList;
import java.util.List;

public class PaletteSelector extends LinearLayout implements View.OnClickListener {

  private List<PaletteSelectorItem> items = new ArrayList<>();
  private OnBlockCategorySelectListener onBlockCategorySelectListener;

  public PaletteSelector(final Context context) {
    super(context);
    init();
  }

  public PaletteSelector(final Context context, final AttributeSet attributeSet) {
    super(context, attributeSet);
    init();
  }

  private void init() {
    setOrientation(VERTICAL);
    setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
    final var dip = (int) LayoutUtil.getDip(getContext(), 8.0f);
    final var dip2 = (int) LayoutUtil.getDip(getContext(), 4.0f);
    setPadding(dip, dip2, dip, dip2);

    addCategoryItem(
        0, getContext().getResources().getString(R.string.block_category_var), 0xffee7d16);
    addCategoryItem(
        1, getContext().getResources().getString(R.string.block_category_list), 0xffcc5b22);
    addCategoryItem(
        2, getContext().getResources().getString(R.string.block_category_control), 0xffe1a92a);
    addCategoryItem(
        3, getContext().getResources().getString(R.string.block_category_operator), 0xff5cb722);
    addCategoryItem(
        4, getContext().getResources().getString(R.string.block_category_math), 0xff23b9a9);
    addCategoryItem(
        5, getContext().getResources().getString(R.string.block_category_file), 0xffa1887f);

    removeAllViews();
    render();
  }

  private void render() {
    items.forEach(this::addView);
  }

  public void clearSelection() {
    items.forEach(it -> it.setSelected(false));
  }

  public List<PaletteSelectorItem> getItems() {
    return items;
  }

  @Override
  public void onClick(final View view) {
    if (view instanceof PaletteSelectorItem paletteSelectorItem) {
      clearSelection();
      paletteSelectorItem.setSelected(true);
      onBlockCategorySelectListener.onBlockCategorySelect(
          paletteSelectorItem.getId(), paletteSelectorItem.getColor());
    }
  }

  public void setOnBlockCategorySelectListener(
      final OnBlockCategorySelectListener onBlockCategorySelectListener) {
    this.onBlockCategorySelectListener = onBlockCategorySelectListener;
  }

  private void addCategoryItem(final int id, final String text, final int color) {
    final PaletteSelectorItem paletteSelectorItem =
        new PaletteSelectorItem(getContext(), id, text, color);
    paletteSelectorItem.setOnClickListener(this);
    items.add(paletteSelectorItem);
  }
}

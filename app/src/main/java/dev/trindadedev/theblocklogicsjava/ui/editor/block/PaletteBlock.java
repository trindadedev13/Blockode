package dev.trindadedev.theblocklogicsjava.ui.editor.block;

/** Decompiled from Sketchware 1.1.13 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import dev.trindadedev.theblocklogicsjava.databinding.LayoutPaletteBlockBinding;
import dev.trindadedev.theblocklogicsjava.utils.LayoutUtil;

public class PaletteBlock extends LinearLayout {

  private LayoutPaletteBlockBinding binding;

  private float dip = 0.0f;
  private Context mContext;

  public PaletteBlock(Context context) {
    super(context);
    init(context);
  }

  public PaletteBlock(Context context, AttributeSet attributeSet) {
    super(context, attributeSet);
    init(context);
  }

  private void init(Context context) {
    binding = LayoutPaletteBlockBinding.inflate(LayoutInflater.from(context), this, true);
    this.mContext = context;
    this.dip = LayoutUtil.getDip(this.mContext, 1.0f);
  }

  public BlockBase addBlock(String str, String str2, String str3, int i, Object... objArr) {
    var view = new View(this.mContext);
    view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (8.0f * this.dip)));
    binding.blockBuilder.addView(view);
    var block = new Block(this.mContext, -1, str, str2, str3, Integer.valueOf(i), objArr);
    block.setBlockType(1);
    binding.blockBuilder.addView(block);
    return block;
  }

  public TextView addButton(final String title) {
    var textView = new TextView(getContext());
    textView.setText(title);
    textView.setTextSize(10.0F);
    textView.setGravity(Gravity.CENTER);
    textView.setPadding((int) (dip * 8.0F), 0, (int) (dip * 8.0F), 0);

    var cardView = new MaterialCardView(getContext());
    var params = getLayoutParams(30.0F);
    params.setMargins(0, 0, 3, 3);
    cardView.setLayoutParams(params);

    cardView.setCardElevation(0f);
    cardView.setRadius(12.0f);
    cardView.setStrokeWidth(0);
    cardView.addView(textView);
    binding.actionsContainer.addView(cardView);
    return textView;
  }

  public PaletteSelector getPaletteSelector() {
    return binding.paletteSelector;
  }

  private LinearLayout.LayoutParams getLayoutParams(float heightMultiplier) {
    return new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT, (int) (dip * heightMultiplier));
  }

  public void removeAllBlocks() {
    binding.blockBuilder.removeAllViews();
  }

  public void setDragEnabled(boolean dragEnabled) {
    if (dragEnabled) {
      binding.scroll.setScrollEnabled();
      binding.scrollHorizontal.setScrollEnabled();
      return;
    }
    binding.scroll.setScrollDisabled();
    binding.scrollHorizontal.setScrollDisabled();
  }

  public void setMinWidth(int i) {
    binding.scroll.setMinimumWidth(i - ((int) (this.dip * 5.0f)));
    binding.scrollHorizontal.setMinimumWidth(i - ((int) (this.dip * 5.0f)));
    getLayoutParams().width = i;
  }
}

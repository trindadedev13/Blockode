package dev.trindadedev.theblocklogicsjava.ui.editor.block;

/** Decompiled from Sketchware 1.1.13 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import dev.trindadedev.theblocklogicsjava.utils.LayoutUtil;

public class PaletteSelectorItem extends RelativeLayout {
  private View bg;
  private int mColor;
  private int mId;
  private String mName;
  private TextView tvCategory;
  private int widthNonSelected = 0;

  public PaletteSelectorItem(Context context, int i, String str, int i2) {
    super(context);
    this.mId = i;
    this.mName = str;
    this.mColor = i2;
    init(context);
  }

  private void init(Context context) {
    LayoutUtil.inflate(context, this, 2130968710);
    this.tvCategory = (TextView) findViewById(2131689882);
    this.bg = findViewById(2131689881);
    this.widthNonSelected = (int) LayoutUtil.getDip(context, 4.0f);
    this.tvCategory.setText(this.mName);
    this.bg.setBackgroundColor(this.mColor);
    setSelected(false);
  }

  public int getColor() {
    return this.mColor;
  }

  public int getId() {
    return this.mId;
  }

  public String getName() {
    return this.mName;
  }

  public void setSelected(boolean z) {
    if (z) {
      this.tvCategory.setTextColor(-1);
      ViewGroup.LayoutParams layoutParams = this.bg.getLayoutParams();
      layoutParams.width = -1;
      this.bg.setLayoutParams(layoutParams);
      return;
    }
    this.tvCategory.setTextColor(-11513776);
    ViewGroup.LayoutParams layoutParams2 = this.bg.getLayoutParams();
    layoutParams2.width = this.widthNonSelected;
    this.bg.setLayoutParams(layoutParams2);
  }
}

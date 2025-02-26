package com.base.compat;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

import com.utils.PhoneUtils;
import com.utils.SizeUtils;

/**
 * @describe
 * @author: lixiaopeng
 * @Date: 2019-08-30
 */
public class StatusBarView  extends View {

    private int statusBarHeight;
    private int statusBarWidth;

    private int bgColor = 0xffffff;

    public StatusBarView(@NonNull Context context) {
        this(context,null);
    }

    public StatusBarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        statusBarWidth = PhoneUtils.getWinWide(context);
        statusBarHeight = PhoneUtils.getStatusBarHeight(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        if (mode==MeasureSpec.AT_MOST||mode==MeasureSpec.UNSPECIFIED){
            int height = MeasureSpec.makeMeasureSpec(statusBarHeight, mode);
            setMeasuredDimension(statusBarWidth,height);
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
        setBackgroundColor(bgColor);
    }

    public void setBgColorRes(int colorRes){
        this.bgColor = getContext().getResources().getColor(colorRes);
        setBackgroundColor(bgColor);
    }

    public void setBgColor(String colorStr){
        this.bgColor = Color.parseColor(colorStr);
    }
    public int getBgColor() {
        return bgColor;
    }
}

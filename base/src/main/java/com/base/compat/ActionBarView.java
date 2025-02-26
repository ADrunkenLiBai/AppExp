package com.base.compat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.base.R;
import com.utils.PhoneUtils;
import com.utils.SizeUtils;

/**
 * @describe
 * @author: lixiaopeng
 * @Date: 2019-08-30
 */
public class ActionBarView extends RelativeLayout implements OnClickListener {

    private static final String TAG = "ActionBarView";
    //左侧按钮
    private LinearLayout actionBarLeftLayout;
    private TextView actionBarLeftText;
    private ImageView actionBarLeftImg;
    //标题
    private LinearLayout actionBarTitleLayout;
    private TextView actionBarTitleText;
    private TextView actionBarSubTitleText;
    //右侧按钮
    private LinearLayout actionBarRightLayout;
    private TextView actionBarRightText;
    private ImageView actionBarRightImg;

    private ActionBarClickListener actionBarClickListener;

    public ActionBarView(Context context) {
        this(context, null);
    }

    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        setEvent();
    }

    private void initView() {
        LayoutInflater.from(this.getContext()).inflate(R.layout.base_title, this, true);
        actionBarLeftLayout = findViewById(R.id.actionBarLeftLayout);
        actionBarLeftText = findViewById(R.id.actionBarLeftText);
        actionBarLeftImg = findViewById(R.id.actionBarLeftImg);
        actionBarTitleLayout = findViewById(R.id.actionBarTitleLayout);
        actionBarTitleText = findViewById(R.id.actionBarTitleText);
        actionBarSubTitleText = findViewById(R.id.actionBarSubTitleText);
        actionBarRightLayout = findViewById(R.id.actionBarRightLayout);
        actionBarRightText = findViewById(R.id.actionBarRightText);
        actionBarRightImg = findViewById(R.id.actionBarRightImg);
    }

    private void setEvent() {
        actionBarLeftText.setOnClickListener(this);
        actionBarLeftImg.setOnClickListener(this);
        actionBarTitleText.setOnClickListener(this);
        actionBarSubTitleText.setOnClickListener(this);
        actionBarRightText.setOnClickListener(this);
        actionBarRightImg.setOnClickListener(this);
    }

    public void setActionBarClickListener(ActionBarClickListener actionBarClickListener) {
        this.actionBarClickListener = actionBarClickListener;
    }

    @Override
    public void onClick(View v) {
        if (actionBarClickListener == null) {
            return;
        }
        if (v.getId() == R.id.actionBarLeftText) {
            actionBarClickListener.onClickLeftText(v);
        } else if (v.getId() == R.id.actionBarLeftImg) {
            actionBarClickListener.onClickLeftImg(v);
        } else if (v.getId() == R.id.actionBarTitleText) {
            actionBarClickListener.onClickTitle(v);
        } else if (v.getId() == R.id.actionBarSubTitleText) {
            actionBarClickListener.onClickSubTitle(v);
        } else if (v.getId() == R.id.actionBarRightText) {
            actionBarClickListener.onClickRightText(v);
        } else if (v.getId() == R.id.actionBarRightImg) {
            actionBarClickListener.onClickRightImg(v);
        }
    }

    /*********以下为View的颜色，文字，图片资源设置**********/

    public void setActionBarBg(int color){
        setBackgroundColor(color);
    }

    public void setActionBarBgRes(int colorRes){
        setActionBarBg(getResources().getColor(colorRes));
    }

    public void setLeftTextEnable(boolean enable) {
        setLeftTextEnable(enable,
                getResources().getColor(R.color.color_actionbar_left_text),
                getResources().getColor(R.color.color_actionbar_left_text_not_enable));
    }

    public void setLeftTextEnable(boolean enable, int enableTextColor, int notEnableTextColor) {
        actionBarLeftText.setEnabled(enable);
        actionBarLeftText.setTextColor(enable ? enableTextColor : notEnableTextColor);
    }

    public void setRightTextEnable(boolean enable) {
        setRightTextEnable(enable,
                getResources().getColor(R.color.color_actionbar_right_text),
                getResources().getColor(R.color.color_actionbar_right_text_not_enable));
    }

    public void setRightTextEnable(boolean enable, int enableTextColor, int notEnableTextColor) {
        actionBarRightText.setEnabled(enable);
        actionBarRightText.setTextColor(enable ? enableTextColor : notEnableTextColor);
    }

    public void setLeftTextSize(float size) {
        actionBarLeftText.setTextSize(size);
    }

    public void setLeftTextColor(int color) {
        actionBarLeftText.setTextColor(color);
    }

    public void setLeftTextColorRes(int colorRes) {
        setLeftTextColor(getResources().getColor(colorRes));
    }

    public void setLeftText(String text) {
        actionBarLeftText.setText(text);
    }

    public void setLeftTextRes(int textRes) {
        setLeftText(getResources().getString(textRes));
    }


    public void setLeftImgRes(int res) {
        actionBarLeftImg.setImageResource(res);
    }

    public void setLeftImgBitmap(Bitmap bmp) {
        actionBarLeftImg.setImageBitmap(bmp);
    }

    public void setLeftImgDrawable(Drawable drawable) {
        actionBarLeftImg.setImageDrawable(drawable);
    }

    public void setTitleSize(float size) {
        actionBarTitleText.setTextSize(size);
    }

    public void setTitleTextColor(int color) {
        actionBarTitleText.setTextColor(color);
    }

    public void setTitleTextColorRes(int colorRes) {
        setTitleTextColor(getResources().getColor(colorRes));
    }

    public void setTitleText(String text) {
        actionBarTitleText.setText(text);
    }

    public void setTitleTextRes(int res) {
        setTitleText(getResources().getString(res));
    }

    public void setSubTitleSize(float size) {
        actionBarSubTitleText.setTextSize(size);
    }

    public void setSubTitleTextColor(int color) {
        actionBarSubTitleText.setTextColor(color);
    }

    public void setSubTitleTextColorRes(int colorRes) {
        setSubTitleTextColor(getResources().getColor(colorRes));
    }

    public void setSubTitleText(String text) {
        actionBarSubTitleText.setText(text);
    }

    public void setSubTitleTextRes(int res) {
        setSubTitleText(getResources().getString(res));
    }

    public void setRightTextSize(float size) {
        actionBarRightText.setTextSize(size);
    }

    public void setRightTextColor(int color) {
        actionBarRightText.setTextColor(color);
    }

    public void setRightTextColorRes(int colorRes) {
        setRightTextColor(getResources().getColor(colorRes));
    }

    public void setRightText(String text) {
        actionBarRightText.setText(text);
    }

    public void setRightTextRes(int textRes) {
        setRightText(getResources().getString(textRes));
    }


    public void setRightImgRes(int res) {
        actionBarRightImg.setImageResource(res);
    }

    public void setRightImgBitmap(Bitmap bmp) {
        actionBarRightImg.setImageBitmap(bmp);
    }

    public void setRightImgDrawable(Drawable drawable) {
        actionBarRightImg.setImageDrawable(drawable);
    }

    public void setLeftTextVisible(int show) {
        actionBarLeftText.setVisibility(show);
    }

    public void setLeftImgVisible(int show){
        actionBarLeftImg.setVisibility(show);
    }

    public void setTitleVisible(int show){
        actionBarTitleText.setVisibility(show);
    }

    public void setSubTitleVisible(int show){
        actionBarSubTitleText.setVisibility(show);
    }

    public void setRightTextVisible(int show){
        actionBarRightText.setVisibility(show);
    }

    public void setRightImgVisible(int show){
        actionBarLeftImg.setVisibility(show);
    }

    /************以下为点击事件相关**************/

    /**
     * 点击事件的回调
     */
    public interface ActionBarClickListener {
        void onClickTitle(View v);

        void onClickSubTitle(View v);

        void onClickLeftText(View v);

        void onClickLeftImg(View v);

        void onClickRightText(View v);

        void onClickRightImg(View v);
    }

    /**
     * 点击事件的适配器，防止每次都要全部实现一遍，可以选择要实现的事件
     * 左侧图标和文字默认是关闭当前页面，其他默认无操作
     */
    public abstract static class ActionBarClickAdapter implements ActionBarClickListener {

        @Override
        public void onClickTitle(View v) {
            Log.d(TAG, "onClickTitle: ");
        }

        @Override
        public void onClickSubTitle(View v) {
            Log.d(TAG, "onClickSubTitle: ");
        }

        @Override
        public void onClickLeftText(View v) {
            Log.d(TAG, "onClickLeftText: ");
            if (v.getContext() instanceof Activity) {
                ((Activity) v.getContext()).finish();
            }
        }

        @Override
        public void onClickLeftImg(View v) {
            Log.d(TAG, "onClickLeftImg: ");
            if (v.getContext() instanceof Activity) {
                ((Activity) v.getContext()).onBackPressed();
            }
        }

        @Override
        public void onClickRightText(View v) {
            Log.d(TAG, "onClickRightText: ");
        }

        @Override
        public void onClickRightImg(View v) {
            Log.d(TAG, "onClickRightImg: ");
        }
    }

    /*******以下为获取相关控件*******/
    public LinearLayout getActionBarLeftLayout() {
        return actionBarLeftLayout;
    }

    public TextView getActionBarLeftText() {
        return actionBarLeftText;
    }

    public ImageView getActionBarLeftImg() {
        return actionBarLeftImg;
    }

    public LinearLayout getActionBarTitleLayout() {
        return actionBarTitleLayout;
    }

    public TextView getActionBarTitleText() {
        return actionBarTitleText;
    }

    public TextView getActionBarSubTitleText() {
        return actionBarSubTitleText;
    }

    public LinearLayout getActionBarRightLayout() {
        return actionBarRightLayout;
    }

    public TextView getActionBarRightText() {
        return actionBarRightText;
    }

    public ImageView getActionBarRightImg() {
        return actionBarRightImg;
    }

}

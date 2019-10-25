package com.lzp.appexp.car.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lzp.appexp.R;

/**
 * @describe
 * @author: lixiaopeng
 * @Date: 2019-10-24
 */
public class CarCardView extends FrameLayout {

    private ImageView ivCar;
    private RectF rectF;

    public CarCardView(@NonNull Context context) {
        this(context, null);
    }

    public CarCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ivCar = findViewById(R.id.ivCar);
    }

    public void setCarImgVisible(int visible) {
        ivCar.setVisibility(visible);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipRect(rectF);
        super.onDraw(canvas);
    }
}

package com.lzp.appexp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.base.compat.BaseActivity;

import java.util.ArrayList;

import com.view.kline.KLineView;
import com.view.kline.Point;

/**
 * @describe
 * @author: lixiaopeng
 * @Date: 2019-09-25
 */
public class KLineActivity extends BaseActivity {


    private KLineView kLinView;

    ArrayList<Point> point = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_line);
        initView();

    }

    public void initView() {
        kLinView = findViewById(R.id.kLinView);

        kLinView.refreshPoint(point);
    }

    public void getData() {
        for (int i = 0; i < 1000; i++) {
            if (i==200){
                Point point = new Point(System.currentTimeMillis(), 3.3f, true);
                point.setShowDate(true);
                this.point.add(point);
            }else
            if (i % 2 == 0) {
                point.add(new Point(System.currentTimeMillis(),1.3f,false));
            } else if (i % 3 == 0) {
                Point point = new Point(System.currentTimeMillis(), 3.3f, false);
                this.point.add(point);
            }else {
                point.add(new Point(System.currentTimeMillis(),2.3f,false));
            }
        }
    }
}

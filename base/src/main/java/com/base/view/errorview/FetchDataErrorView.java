package com.base.view.errorview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.base.R;

/**
 * @author Li Xiaopeng
 * @date 2019/1/3
 */
public class FetchDataErrorView extends BaseErrView {

    private FetchRefreshListener fetchRefreshListener;
    public FetchDataErrorView(Context context) {
        super(context);
    }

    public FetchDataErrorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSelfView();
        setView();
        setListener();
    }

    private void setListener() {

        setOnBtnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fetchRefreshListener != null) {
                    fetchRefreshListener.fetchRefresh();
                }
            }
        });
    }

    private void initSelfView() {
        defaultImageRes = defaultImageRes==0? R.drawable.wifi_icon:defaultImageRes;
        defaultTitleStr = TextUtils.isEmpty(defaultTitleStr)?resources.getString(R.string.net_timeout):defaultTitleStr;
        defaultContentStr =TextUtils.isEmpty(defaultContentStr)? resources.getString(R.string.refresh_later):defaultContentStr;
        defaultBtnTextStr =TextUtils.isEmpty(defaultBtnTextStr)? resources.getString(R.string.refresh):defaultBtnTextStr;
    }

    public void setFetchRefreshListener(FetchRefreshListener fetchRefreshListener) {
        this.fetchRefreshListener = fetchRefreshListener;
    }

    public interface FetchRefreshListener {
        void fetchRefresh();
    }
}
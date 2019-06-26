package com.imageloader.ext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.imageloader.Gif;
import com.imageloader.IImageLoader;
import com.imageloader.ILoader;
import com.imageloader.IMGLoadListener;
import com.imageloader.ImageLoaderConfig;

import java.io.File;

/**
 * @describe
 * @author: lixiaopeng
 * @Date: 2019-06-13
 */
public class GlideLoader implements ILoader, IImageLoader {


    private Params params;

    public static GlideLoader get(Context context) {
        return new GlideLoader(context);
    }

    private GlideLoader(Context context) {
        params = new Params();
        params.context = context;
    }


    @Override
    public IImageLoader into(View view) {
        params.view = view;
        return this;
    }

    @Override
    public IImageLoader placeHolder(int res) {
        params.placeHolder = res;
        return this;
    }

    @Override
    public IImageLoader errHolder(int res) {
        params.errHolder = res;
        return this;
    }

    @Override
    public IImageLoader width(int width) {
        params.width = width;
        return this;
    }

    @Override
    public IImageLoader height(int height) {
        params.height = height;
        return this;
    }

    @Override
    public IImageLoader skipMemory(boolean needMemory) {
        params.skipMemory = needMemory;
        return this;
    }

    @Override
    public IImageLoader listener(IMGLoadListener listener) {
        params.loadListener = listener;
        return this;
    }

    @SuppressLint("CheckResult")
    @Override
    public void display() {
        RequestOptions opt = new RequestOptions()
                .diskCacheStrategy(params.skipMemory ? DiskCacheStrategy.NONE : DiskCacheStrategy.RESOURCE)
                .skipMemoryCache(params.skipMemory);

        RequestManager manager = Glide.with(params.context);
        if (params.imgType==Params.ImgType.Bitmap){
            RequestBuilder<Bitmap> bitmapRequestBuilder = manager
                    .asBitmap()
                    .load(params.url)
                    .apply(opt);

            if (params.view instanceof ImageView){
                bitmapRequestBuilder.into((ImageView) params.view);
            }else{
                bitmapRequestBuilder.into(new ViewTarget<View,Bitmap>(params.view) {
                    @Override
                    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        params.view.setBackground(new BitmapDrawable(params.view.getResources(),bitmap));
                    }
                });
            }
        }
        // .apply(opt);
    }

    @Override
    public void load() {

    }

    @Override
    public IImageLoader<Bitmap> load(String url) {
        params.url = url;
        return this;
    }

    @Override
    public IImageLoader<Bitmap> asBitmap() {
        params.imgType = Params.ImgType.Bitmap;
        return this;
    }

    @Override
    public IImageLoader<Drawable> asDrawable() {
        params.imgType = Params.ImgType.Drawable;
        return this;
    }

    @Override
    public IImageLoader<Gif> asGif() {
        params.imgType = Params.ImgType.Gif;
        return this;
    }

    @Override
    public IImageLoader<File> asFile() {
        params.imgType = Params.ImgType.File;
        return this;
    }

    @Override
    public void clearCache() {
        Glide.get(params.context).clearDiskCache();
        Glide.get(params.context).clearMemory();
    }

    @Override
    public void init(ImageLoaderConfig config) {
        //TODO 初始化
    }


    @Override
    public String getDiskCachePath() {
        return "";
    }


}

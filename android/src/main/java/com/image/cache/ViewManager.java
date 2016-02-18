package com.image.cache;

import android.graphics.Bitmap;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import javax.annotation.Nullable;

/**
 * Created by azou on 15/02/16.
 */
public class ViewManager extends SimpleViewManager<ImageView> {
    ImageView imageView;
    ImageLoader imageLoader;

    public ViewManager(ImageLoader instance) {
        this.imageLoader = instance;
    }

    @Override
    public String getName() {
        return "ImageViewCache";
    }


    @Override
    public ImageView createViewInstance(ThemedReactContext reactContext) {
        imageView = new ImageView(reactContext);
        return imageView;
    }

    // In JS this is Image.props.source.uri
    @ReactProp(name = "src")
    public void setSource(ImageView view, @Nullable String source) {
        imageLoader.displayImage(source, view, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }

}

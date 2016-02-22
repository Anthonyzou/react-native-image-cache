package com.image.cache;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.makeramen.roundedimageview.RoundedImageView;

import javax.annotation.Nullable;

/**
 * Created by azou on 15/02/16.
 */
public class ViewManager extends SimpleViewManager<ImageView> {
    RoundedImageView imageView;

    public ViewManager() {
    }

    @Override
    public String getName() {
        return "ImageViewCache";
    }


    @Override
    public ImageView createViewInstance(ThemedReactContext reactContext) {
        imageView = new RoundedImageView(reactContext);
        return imageView;
    }

    // In JS this is Image.props.source.uri
    @ReactProp(name = "src")
    public void setSource(RoundedImageView view, @Nullable String source) {
        Glide
            .with(view.getContext())
            .load(source)
            .listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    return false;
                }
            })
            .into(imageView)
        ;
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(RoundedImageView view, float borderRadius) {
        borderRadius *= 10;
        view.setCornerRadius(borderRadius);
    }

    @ReactProp(name = "tintColor", customType = "Color")
    public void setTintColor(RoundedImageView view, @Nullable Integer tintColor) {
        if (tintColor == null) {
            view.clearColorFilter();
        } else {
            view.setColorFilter(tintColor);
        }

    }

    @ReactProp(name = "resizeMode")
    public void setScaleType(ImageView view, @Nullable String mode) {
        view.setScaleType(ImageView.ScaleType.valueOf(mode));
    }
}

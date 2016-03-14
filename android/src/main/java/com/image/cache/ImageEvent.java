package com.image.cache;

import android.support.annotation.IntDef;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by anthonyou on 2016-03-14.
 */
class ImageEvent extends Event<ImageEvent> {


    /**
     * Copyright (c) 2015-present, Facebook, Inc.
     * All rights reserved.
     *
     * This source code is licensed under the BSD-style license found in the
     * LICENSE file in the root directory of this source tree. An additional grant
     * of patent rights can be found in the PATENTS file in the same directory.
     */


    @IntDef({ON_LOAD})
    @Retention(RetentionPolicy.SOURCE)
    @interface ImageEventType {}

    public static final int ON_LOAD = 1;

    private final int mEventType;

    public ImageEvent(int viewId, long timestampMs, @ImageEventType int eventType) {
        super(viewId, timestampMs);
        mEventType = eventType;
    }

    public static String eventNameForType(@ImageEventType int eventType) {
        switch(eventType) {
            case ON_LOAD:
                return "topLoad";
            default:
                throw new IllegalStateException("Invalid image event: " + Integer.toString(eventType));
        }
    }

    @Override
    public String getEventName() {
        return ImageEvent.eventNameForType(mEventType);
    }

    @Override
    public short getCoalescingKey() {
        // Intentionally casting mEventType because it is guaranteed to be small
        // enough to fit into short.
        return (short) mEventType;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
    }
}

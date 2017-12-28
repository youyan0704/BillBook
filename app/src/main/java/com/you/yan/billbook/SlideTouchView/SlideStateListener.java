package com.you.yan.billbook.SlideTouchView;

import android.view.View;

public interface SlideStateListener<T extends ISlide> {
    void onOpened(T v);
    void onClosed(T v);
    void beforeOpen(T v);
    void clamping(T v);
    void onForegroundViewClick(T slideView, View v);
}

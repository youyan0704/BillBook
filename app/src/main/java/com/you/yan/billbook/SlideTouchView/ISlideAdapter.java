package com.you.yan.billbook.SlideTouchView;

import android.view.View;


public interface ISlideAdapter {
    void bindSlideState(View slideTouchView);
    void bindSlidePosition(View slideTouchView, int pos);
    void setOnClickSlideItemListener(OnClickSlideItemListener listener);
    int[] getBindOnClickViewsIds();
    void closeAll();
}

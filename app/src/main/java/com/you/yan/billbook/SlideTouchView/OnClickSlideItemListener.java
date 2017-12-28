package com.you.yan.billbook.SlideTouchView;

import android.view.View;

public interface OnClickSlideItemListener {
    void onItemClick(ISlide iSlideView, View v, int position);
    void onClick(ISlide iSlideView, View v, int position);
}

package com.titlebargradient.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * TODO<自定义监听滑动的ScrollView>
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:37
 */

public class ObservableScrollView extends ScrollView {

    private ScrollViewListener scrollViewListener = null;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {

            if (oldy < y ) {// 控件向上滑动，屏幕内容下滑
                scrollViewListener.onScroll(oldy,y,false);

            } else if (oldy > y ) {// 向下滑动，屏幕内容上滑
                scrollViewListener.onScroll(oldy,y,true);
            }

        }
    }

    public  interface ScrollViewListener{//dy Y轴滑动距离，isUp 是否返回顶部
         void onScroll(int oldy,int dy,boolean isUp);
    }
}
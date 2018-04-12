package com.wangtianya.yaa.core.wiget;

import com.wangtianya.yaa.core.context.YaaContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by i on 2016/8/19.
 */
public class YaaContainerLayout extends FrameLayout {
    private Context context;

    public YaaContainerLayout(Context context, int resId) {
        super(context);
        this.context = context;
        init(resId);
    }

    public YaaContainerLayout(int resId) {
        super(YaaContext.getContext());
        init(resId);
    }

    public void init(int resId) {
        LayoutInflater.from(context).inflate(resId, this);
    }
}

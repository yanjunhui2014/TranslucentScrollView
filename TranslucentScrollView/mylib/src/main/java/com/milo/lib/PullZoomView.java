package com.milo.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.milo.lib.impl.IZoomControl;
import com.milo.lib.utils.SizeUtils;

/**
 * 标题：伸缩视图
 * 功能：
 * 备注：简化封装
 * <p>
 * Created by Milo  2020/3/3
 * E-Mail : 303767416@qq.com
 */
public class PullZoomView extends LinearLayout implements IZoomControl {
    static final String TAG = PullZoomView.class.getSimpleName();

    public TranslucentScrollView mLayoutTransSV;
    public ViewGroup             mLayoutContent;

    private View mHeaderView;

    public PullZoomView(Context context) {
        super(context);
    }

    public PullZoomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PullZoomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void setHeaderView(int layoutId) {
        if (mLayoutContent == null) {
            throw new NullPointerException("mLayoutContent为空");
        }

        View headerView = LayoutInflater.from(getContext()).inflate(layoutId, mLayoutContent, false);
        if (mHeaderView == null) {
            mLayoutContent.addView(headerView, 0);
        } else {
            mLayoutContent.removeViewAt(0);
            mLayoutContent.addView(headerView, 0);
        }

        mHeaderView = headerView;
        mLayoutTransSV.setPullZoomView(headerView);
    }

    @Override
    public void setHeaderView(View headerView, int viewHeight) {
        if (mLayoutContent == null) {
            throw new NullPointerException("mLayoutContent为空");
        } else if (headerView == null) {
            throw new NullPointerException("headerView为空");
        } else if (viewHeight <= 0) {
            throw new IllegalArgumentException("viewHeight不可以小于0");
        }

        if (mHeaderView == null) {
            mLayoutContent.addView(headerView, 0);
        } else {
            mLayoutContent.removeViewAt(0);
            mLayoutContent.addView(headerView, 0);
        }

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) headerView.getLayoutParams();
        params.height = SizeUtils.dip2px(getContext(), viewHeight);
        headerView.setLayoutParams(params);

        mHeaderView = headerView;
        mLayoutTransSV.setPullZoomView(headerView);
    }

    @Override
    public void addNormalView(int... layoutIds) {
        if (mLayoutContent == null) {
            throw new NullPointerException("mLayoutContent为空");
        } else if (layoutIds == null) {
            throw new NullPointerException("layoutIds为空");
        }

        for (int layoutId : layoutIds) {
            View normalView = LayoutInflater.from(getContext()).inflate(layoutId, mLayoutContent, false);
            mLayoutContent.addView(normalView);
        }
    }

    @Override
    public void setDamping(float damping, int dampDistance) {
        mLayoutTransSV.setDamping(damping, dampDistance);
    }

    @Override
    public void attachTransView(View transView, int transColor, int transStartY, int transEndY) {
        mLayoutTransSV.setTransView(transView, transColor, transStartY, transEndY);
    }

    @Override
    public void setTranslucentChangedListener(TranslucentScrollView.TranslucentChangedListener translucentChangedListener) {
        mLayoutTransSV.setTranslucentChangedListener(translucentChangedListener);
    }

    private void init(Context context) {
        addView(LayoutInflater.from(context).inflate(R.layout.milo_zoomview, this, false));
        initView();
    }

    private void initView() {
        mLayoutTransSV = findViewById(R.id.mLayoutTransSV);
        mLayoutContent = findViewById(R.id.mLayoutContent);
    }
}

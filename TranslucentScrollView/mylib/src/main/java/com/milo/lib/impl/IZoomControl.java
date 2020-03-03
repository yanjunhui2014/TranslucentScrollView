package com.milo.lib.impl;

import android.view.View;

import com.milo.lib.TranslucentScrollView;

/**
 * 标题：
 * 功能：
 * 备注：
 * <p>
 * Created by Milo  2020/3/3
 * E-Mail : 303767416@qq.com
 */
public interface IZoomControl {

    void setHeaderView(int layoutId);

    void setHeaderView(View headerView, int viewHeight);

    void addNormalView(int... layoutId);

    /**
     * 关联渐变视图
     *
     * @param transView   - 需要渐变的视图
     * @param transColor  - 指定渐变色
     * @param transStartY - Y轴移动超过该值，渐变开始。-1代表默认值 {@link TranslucentScrollView#DFT_TRANSSTARTY}
     * @param transEndY   - Y轴移动达到该值，渐变结束。-1代表默认值 {@link TranslucentScrollView#DFT_TRANSENDY}
     */
    void attachTransView(View transView, int transColor, int transStartY, int transEndY);

    /**
     * 设置渐变变化的监听器
     *
     * @param translucentChangedListener
     */
    void setTranslucentChangedListener(TranslucentScrollView.TranslucentChangedListener translucentChangedListener);
}

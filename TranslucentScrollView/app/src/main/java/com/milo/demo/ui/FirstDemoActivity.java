package com.milo.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.milo.demo.R;
import com.milo.demo.base.BaseActivity;
import com.milo.demo.impl.ActionBarClickListener;
import com.milo.demo.utils.SystemBarUtils;
import com.milo.demo.widget.TranslucentActionBar;
import com.milo.lib.TranslucentScrollView;

public class FirstDemoActivity extends BaseActivity implements ActionBarClickListener, TranslucentScrollView.TranslucentChangedListener {

    private TranslucentScrollView translucentScrollView;
    private TranslucentActionBar  actionBar;
    private View                  zoomView;

    public static Intent createIntent(Context context) {
        return new Intent(context, FirstDemoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_first);

        init();
        SystemBarUtils.immersiveStatusBar(this);
    }

    private void init() {
        actionBar = (TranslucentActionBar) findViewById(R.id.actionbar);
        //初始actionBar
        actionBar.setData("测试", 0, null, 0, null, null);
        //开启渐变
        actionBar.setNeedTranslucent();
        //设置状态栏高度
        actionBar.setStatusBarHeight(getStatusBarHeight());

        translucentScrollView = (TranslucentScrollView) findViewById(R.id.pullzoom_scrollview);
        //设置透明度变化监听
        translucentScrollView.setTranslucentChangedListener(this);
        //关联需要渐变的视图
        translucentScrollView.setTransView(actionBar);
        //设置ActionBar键渐变颜色
        translucentScrollView.setTransColor(getResources().getColor(R.color.orange_dft));

        zoomView = findViewById(R.id.lay_header);
        //关联伸缩的视图
        translucentScrollView.setPullZoomView(zoomView);
    }

    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightClick() {

    }

    @Override
    public void onTranslucentChanged(int transAlpha) {
        actionBar.tvTitle.setVisibility(transAlpha > 48 ? View.VISIBLE : View.GONE);
    }

}

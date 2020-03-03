package com.milo.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.milo.demo.R;
import com.milo.demo.base.BaseActivity;
import com.milo.demo.utils.SystemBarUtils;
import com.milo.lib.PullZoomView;
import com.milo.lib.TranslucentScrollView;

/**
 * 标题：Demo-二
 * 功能：
 * 备注：更简洁易用（推荐）
 * <p>
 * Created by Milo  2020/3/3
 * E-Mail : 303767416@qq.com
 */
public class SecondDemoActivity extends BaseActivity {

    private PullZoomView mPullZoomView;
    private ViewGroup    mActionBar;
    private View         mStatusBarHolder;
    private TextView     mTvTitle;

    public static Intent createIntent(Context context) {
        return new Intent(context, SecondDemoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_second);
        initView();
        SystemBarUtils.immersiveStatusBar(this);
    }

    private void initView() {
        mPullZoomView = (PullZoomView) findViewById(R.id.mPullZoomView);
        mActionBar = findViewById(R.id.mActionBar);
        mStatusBarHolder = findViewById(R.id.mStatusBarHolder);
        mTvTitle = findViewById(R.id.mTvTitle);

        mPullZoomView.setHeaderView(R.layout.view_header);
        mPullZoomView.addNormalView(R.layout.view_normal, R.layout.view_normal);//可以连续添加多个
        mPullZoomView.setDamping(0.2f, 0);

        ViewGroup.LayoutParams params = mStatusBarHolder.getLayoutParams();
        params.height += SystemBarUtils.getStatusBarHeight(this);
        mStatusBarHolder.setLayoutParams(params);

        mTvTitle.setVisibility(View.GONE);
        mPullZoomView.attachTransView(mActionBar, getResources().getColor(R.color.colorPrimary), -1, -1);
        mPullZoomView.setTranslucentChangedListener(new TranslucentScrollView.TranslucentChangedListener() {
            @Override
            public void onTranslucentChanged(int transAlpha) {
                mTvTitle.setVisibility(transAlpha > 48 ? View.VISIBLE : View.GONE);
            }
        });
        mPullZoomView.mLayoutTransSV.setVerticalScrollBarEnabled(false);
    }
}

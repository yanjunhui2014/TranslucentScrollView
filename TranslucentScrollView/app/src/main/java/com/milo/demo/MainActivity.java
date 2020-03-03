package com.milo.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.milo.demo.base.BaseActivity;
import com.milo.demo.ui.FirstDemoActivity;
import com.milo.demo.ui.SecondDemoActivity;

/**
 * Created by Administrator on 2016/12/16.
 * email:303767416@qq.com
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnFirst;
    private Button mBtnSecond;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnFirst) {
            startActivity(FirstDemoActivity.createIntent(this));
        } else if (v == mBtnSecond) {
            startActivity(SecondDemoActivity.createIntent(this));
        }
    }

    private void initView() {
        mBtnFirst = (Button) findViewById(R.id.mBtnFirst);
        mBtnFirst.setOnClickListener(this);
        mBtnSecond = (Button) findViewById(R.id.mBtnSecond);
        mBtnSecond.setOnClickListener(this);
    }
}

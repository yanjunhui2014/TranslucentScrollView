package test.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import test.com.utils.SizeUtils;
import test.com.widget.TranslucentScrollView;

/**
 * Created by Administrator on 2016/12/16.
 * email:303767416@qq.com
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TranslucentScrollView scrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_test);
        scrollView = (TranslucentScrollView) findViewById(R.id.trans_scrollview);
        scrollView.setTransView(toolbar, getResources().getColor(R.color.colorPrimary), SizeUtils.dip2px(this, 50), SizeUtils.dip2px(this, 300));

        getSupportActionBar().hide();
    }
}

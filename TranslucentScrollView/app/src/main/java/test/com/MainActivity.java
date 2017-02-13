package test.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import test.com.base.BaseActivity;
import test.com.impl.ActionBarClickListener;
import test.com.widget.TranslucentActionBar;
import test.com.widget.TranslucentScrollView;

/**
 * Created by Administrator on 2016/12/16.
 * email:303767416@qq.com
 */

public class MainActivity extends BaseActivity implements ActionBarClickListener, TranslucentScrollView.TranslucentChangedListener {

    private TranslucentScrollView translucentScrollView;
    private TranslucentActionBar actionBar;
    private View zoomView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        actionBar = (TranslucentActionBar) findViewById(R.id.actionbar);
        //初始actionBar
        actionBar.setData("个人中心", 0, null, 0, null, null);
        //开启渐变
        actionBar.setNeedTranslucent();
        //设置状态栏高度
        actionBar.setStatusBarHeight(getStatusBarHeight());

        translucentScrollView = (TranslucentScrollView) findViewById(R.id.pullzoom_scrollview);
        //设置透明度变化监听
        translucentScrollView.setTranslucentChangedListener(this);
        //关联需要渐变的视图
        translucentScrollView.setTransView(actionBar);

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

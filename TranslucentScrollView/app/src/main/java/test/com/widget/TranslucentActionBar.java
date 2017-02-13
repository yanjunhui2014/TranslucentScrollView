package test.com.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.com.R;
import test.com.impl.ActionBarClickListener;

/**
 * 支持渐变的 actionBar
 * Created by 晖仔(Milo) on 2016/12/28.
 * email:303767416@qq.com
 */

public final class TranslucentActionBar extends LinearLayout {

    private View layRoot;
    private View vStatusBar;
    private View layLeft;
    private View layRight;
    public TextView tvTitle;
    private TextView tvLeft;
    private TextView tvRight;
    private View iconLeft;
    private View iconRight;

    public TranslucentActionBar(Context context) {
        this(context, null);
    }

    public TranslucentActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TranslucentActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        setOrientation(HORIZONTAL);
        View contentView = inflate(getContext(), R.layout.actionbar_trans, this);
        layRoot = contentView.findViewById(R.id.lay_transroot);
        vStatusBar = contentView.findViewById(R.id.v_statusbar);
        tvTitle = (TextView) contentView.findViewById(R.id.tv_actionbar_title);
        tvLeft = (TextView) contentView.findViewById(R.id.tv_actionbar_left);
        tvRight = (TextView) contentView.findViewById(R.id.tv_actionbar_right);
        iconLeft = contentView.findViewById(R.id.iv_actionbar_left);
        iconRight = contentView.findViewById(R.id.v_actionbar_right);
    }

    /**
     * 设置状态栏高度
     *
     * @param statusBarHeight
     */
    public void setStatusBarHeight(int statusBarHeight) {
        ViewGroup.LayoutParams params = vStatusBar.getLayoutParams();
        params.height = statusBarHeight;
        vStatusBar.setLayoutParams(params);
    }

    /**
     * 设置是否需要渐变
     */
    public void setNeedTranslucent() {
        setNeedTranslucent(true, false);
    }

    /**
     * 设置是否需要渐变,并且隐藏标题
     *
     * @param translucent
     */
    public void setNeedTranslucent(boolean translucent, boolean titleInitVisibile) {
        if (translucent) {
            layRoot.setBackgroundDrawable(null);
        }
        if (!titleInitVisibile) {
            tvTitle.setVisibility(View.GONE);
        }
    }

    /**
     * 设置标题
     *
     * @param strTitle
     */
    public void setTitle(String strTitle) {
        if (!TextUtils.isEmpty(strTitle)) {
            tvTitle.setText(strTitle);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
    }

    /**
     * 设置数据
     *
     * @param strTitle
     * @param resIdLeft
     * @param strLeft
     * @param resIdRight
     * @param strRight
     * @param listener
     */
    public void setData(String strTitle, int resIdLeft, String strLeft, int resIdRight, String strRight, final ActionBarClickListener listener) {
        if (!TextUtils.isEmpty(strTitle)) {
            tvTitle.setText(strTitle);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(strLeft)) {
            tvLeft.setText(strLeft);
            tvLeft.setVisibility(View.VISIBLE);
        } else {
            tvLeft.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(strRight)) {
            tvRight.setText(strRight);
            tvRight.setVisibility(View.VISIBLE);
        } else {
            tvRight.setVisibility(View.GONE);
        }

        if (resIdLeft == 0) {
            iconLeft.setVisibility(View.GONE);
        } else {
            iconLeft.setBackgroundResource(resIdLeft);
            iconLeft.setVisibility(View.VISIBLE);
        }

        if (resIdRight == 0) {
            iconRight.setVisibility(View.GONE);
        } else {
            iconRight.setBackgroundResource(resIdRight);
            iconRight.setVisibility(View.VISIBLE);
        }

        if (listener != null) {
            layLeft = findViewById(R.id.lay_actionbar_left);
            layRight = findViewById(R.id.lay_actionbar_right);
            layLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onLeftClick();
                }
            });
            layRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onRightClick();
                }
            });
        }
    }

}

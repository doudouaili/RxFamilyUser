package www.rxfamilyuser.com.util;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.View;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.databinding.TitlebarBinding;

/**
 * Created by ali on 2017/2/20.
 */

public class TitleBuilderUtils {
    private View viewTitle;//标题栏布局
    private TitlebarBinding titlebar;

    public TitleBuilderUtils(Activity activity) {
        viewTitle = activity.findViewById(R.id.rl_titlebar);
        titlebar = DataBindingUtil.bind(viewTitle);
    }

    /**
     * 设置标题栏背景色
     *
     * @param resid 颜色
     * @return 标题栏对象
     */
    public TitleBuilderUtils setTitleBgRes(int resid) {
        viewTitle.setBackgroundResource(resid);
        return this;
    }

    /**
     * 设置标题栏中间文字
     *
     * @param text 文字
     * @return 标题栏对象
     */
    public TitleBuilderUtils setTitleText(String text) {
        titlebar.titlebarTv.setVisibility(TextUtils.isEmpty(text) ? View.GONE
                : View.VISIBLE);
        titlebar.titlebarTv.setText(text);
        return this;
    }

    // left

    public TitleBuilderUtils setLeftImage(int resId) {
        titlebar.titlebarIvLeft.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        titlebar.titlebarIvLeft.setImageResource(resId);
        return this;
    }

    public TitleBuilderUtils setLeftText(String text) {
        titlebar.titlebarTvLeft.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        titlebar.titlebarTvLeft.setText(text);
        return this;
    }

    public TitleBuilderUtils setLeftOnClickListener(View.OnClickListener listener) {
        if (titlebar.titlebarIvLeft.getVisibility() == View.VISIBLE) {
            titlebar.titlebarIvLeft.setOnClickListener(listener);
        } else if (titlebar.titlebarTvLeft.getVisibility() == View.VISIBLE) {
            titlebar.titlebarTvLeft.setOnClickListener(listener);
        }
        return this;
    }
    // right

    public TitleBuilderUtils setRightImage(int resId) {
        titlebar.titlebarIvRight.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        titlebar.titlebarIvRight.setImageResource(resId);
        return this;
    }

    public TitleBuilderUtils setRightText(String text) {
        titlebar.titlebarTvRight.setVisibility(TextUtils.isEmpty(text) ? View.GONE
                : View.VISIBLE);
        titlebar.titlebarTvRight.setText(text);
        return this;
    }

    public TitleBuilderUtils setRightOnClickListener(View.OnClickListener listener) {
        if (titlebar.titlebarIvRight.getVisibility() == View.VISIBLE) {
            titlebar.titlebarIvRight.setOnClickListener(listener);
        } else if (titlebar.titlebarTvRight.getVisibility() == View.VISIBLE) {
            titlebar.titlebarTvRight.setOnClickListener(listener);
        }
        return this;
    }


}

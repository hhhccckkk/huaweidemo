package com.hck.huawei.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hck.huaweidemo.R;

/**
 * 公用title.
 */
public class TitleBar extends LinearLayout {
    private ImageView mLeftBackBtn, rightBtn;// 左边返回按钮
    private TextView mCenterTextV; // 中间文本.
    private Context mContext;

    public TitleBar(Context context) {
        super(context);
        mContext = context;
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(context);
    }

    /**
     * 初始化view.
     * 
     * @param context
     */
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        mLeftBackBtn = (ImageView) findViewById(R.id.titleBackBtn);
        mCenterTextV = (TextView) findViewById(R.id.titleCenterTV);
        rightBtn = (ImageView) findViewById(R.id.right_btn);
    }

    public ImageView getLeftImageView() {
        return mLeftBackBtn;
    }

    public ImageView getRightImageView() {
        return rightBtn;
    }

    public void showOrHidenRightBtn(int value) {
        rightBtn.setVisibility(value);
    }

    public void showOrHidenLeftBtn(int value) {
        mLeftBackBtn.setVisibility(value);
    }

    public void setLeftBtn(int value) {
        mLeftBackBtn.setImageResource(value);
    }

    public void setTitleContent(String content) {
        mCenterTextV.setText(content);
    }

}

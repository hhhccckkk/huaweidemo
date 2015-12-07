package com.hck.huawei.ui;

import com.hck.huaweidemo.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class TongZhiActivity extends BaseActivity {
    private SafeFragment safeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tongzhi_activity);
        initView();
        initHome();
    }

    private void initHome() {
        safeFragment = new SafeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.tongzhi_content, safeFragment).commit();
    }

    private void initView() {
        mTitleBar.showOrHidenRightBtn(View.GONE);
        mTitleBar.setLeftBtn(R.drawable.icon_back);
        mTitleBar.setTitleContent("安全通知");
        mTitleBar.getLeftImageView().setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

package com.hck.huawei.ui;

import com.hck.huaweidemo.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class OtherActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        mTitleBar.showOrHidenRightBtn(View.GONE);
        mTitleBar.setLeftBtn(R.drawable.icon_back);
        String data = getIntent().getStringExtra("data");
        if (data == null) {
            mTitleBar.setTitleContent("订单:" + "MDH22727272");
        } else {
            mTitleBar.setTitleContent("订单:" + data);
        }

        mTitleBar.getLeftImageView().setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showToast(View view) {
        showToast("开发中");
    }

}

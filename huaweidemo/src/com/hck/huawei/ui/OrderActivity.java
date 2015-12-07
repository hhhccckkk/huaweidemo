package com.hck.huawei.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.hck.huaweidemo.R;

public class OrderActivity extends BaseActivity {
    private OrderFragment orderFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);
        initView();
        initHome();
    }
    private void initHome() {
        orderFragment=new OrderFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.order_content, orderFragment).commit();
        orderFragment.getData();
    }
    private void initView() {
        mTitleBar.showOrHidenRightBtn(View.GONE);
        mTitleBar.setLeftBtn(R.drawable.icon_back);
        mTitleBar.setTitleContent("订单列表");
        mTitleBar.getLeftImageView().setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

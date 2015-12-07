package com.hck.huawei.ui;

import com.hck.huawei.bean.OrderBean;
import com.hck.huaweidemo.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class OrderXiangXiActivity extends BaseActivity {
    private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    private OrderBean orderBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_xiangxi);
        orderBean = (OrderBean) getIntent().getSerializableExtra("data");
        initView();
        initTextView();
        initData();

    }

    public void share(View view) {
        Intent intent=new Intent();
        intent.setClass(this, OtherActivity.class);
             startActivity(intent);
    }

    private void initTextView() {
        textView1 = (TextView) findViewById(R.id.orderId);
        textView2 = (TextView) findViewById(R.id.orderId2);
        textView3 = (TextView) findViewById(R.id.orderId3);
        textView4 = (TextView) findViewById(R.id.orderId4);
        textView5 = (TextView) findViewById(R.id.orderId5);
        textView6 = (TextView) findViewById(R.id.orderId6);
        textView7 = (TextView) findViewById(R.id.orderId7);
    }

    private void initData() {
        if (orderBean != null) {
//            textView1.setText(orderBean.getOrderString());
//            textView2.setText(orderBean.getString1() + "");
//            textView3.setText(orderBean.getString2() + "");
//            textView4.setText(orderBean.getString3() + "");
//            textView5.setText(orderBean.getString4() + "");
//            textView6.setText(orderBean.getString5() + "");
//            textView7.setText(orderBean.getString6() + "");
        }

    }

    private void initView() {
        mTitleBar.showOrHidenRightBtn(View.GONE);
        mTitleBar.setLeftBtn(R.drawable.icon_back);
        mTitleBar.setTitleContent("订单");
        mTitleBar.getLeftImageView().setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

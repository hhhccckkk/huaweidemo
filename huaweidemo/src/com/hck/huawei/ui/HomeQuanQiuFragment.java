package com.hck.huawei.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hck.httpserver.HCKHttpResponseHandler;
import com.hck.huawei.bean.HomeBane;
import com.hck.huawei.net.Request;
import com.hck.huawei.net.Urls;
import com.hck.huawei.util.JsonUtils;
import com.hck.huawei.view.Pdialog;
import com.hck.huaweidemo.R;

public class HomeQuanQiuFragment extends BaseFragment {
    private HomeBane homeBane = new HomeBane();
    private TextView chinaTextView, tatolTextView, baojingTextView;
    private TextView yujingTextView, zhengchangTextView, yichangTextView;
    private TextView jidanTextView, weixianpTextView, gaojiazhiTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.home_quanqiu_fragment, null);
            initView(rootView);
            getData();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View view) {
        chinaTextView = (TextView) view.findViewById(R.id.yuanquan3);
        tatolTextView = (TextView) view.findViewById(R.id.quanqiu_all_size);
        baojingTextView = (TextView) view.findViewById(R.id.quanqiu_baojing_size);
        yujingTextView = (TextView) view.findViewById(R.id.quanqiu_yujing_size);
        zhengchangTextView = (TextView) view.findViewById(R.id.home_tex1);
        yichangTextView = (TextView) view.findViewById(R.id.home_tex2);
        jidanTextView = (TextView) view.findViewById(R.id.home_tex3);
        weixianpTextView = (TextView) view.findViewById(R.id.home_tex4);
        gaojiazhiTextView = (TextView) view.findViewById(R.id.home_tex5);
        view.findViewById(R.id.showOrder).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeQuanQiuFragment.this.getActivity(), OrderActivity.class));
            }
        });

        view.findViewById(R.id.showTZ).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeQuanQiuFragment.this.getActivity(), TongZhiActivity.class));
            }
        });
    }

    public void getData() {
        Pdialog.showDialog(this.getActivity(), "正在获取数据..", true);
        Request.getHomeData(Urls.GET_HOME_DATA, new HCKHttpResponseHandler() {
            @Override
            public void onFinish(String url) {
                super.onFinish(url);
                Pdialog.hiddenDialog();
            }

            @Override
            public void onSuccess(String content, String requestUrl) {
                super.onSuccess(content, requestUrl);
                Log.d("hck", "onSuccess: "+content);
                JsonUtils.getHomeData(content, homeBane);
                updateUI();
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Toast.makeText(HomeQuanQiuFragment.this.getActivity(), "网络异常获取数据失败", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateUI() {
        chinaTextView.setText(homeBane.getTotal());
        tatolTextView.setText(homeBane.getTotal());
        baojingTextView.setText(homeBane.getAlarm());
        yujingTextView.setText(homeBane.getWarning());
        zhengchangTextView.setText(homeBane.getNormal());
        yichangTextView.setText(homeBane.getUnNormal());
        jidanTextView.setText(homeBane.getUrgent());
        weixianpTextView.setText(homeBane.getDangerous());
        gaojiazhiTextView.setText(homeBane.getHighValue());
    }
    
    private void setLayWidth(){
    }

}

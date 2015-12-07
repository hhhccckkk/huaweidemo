package com.hck.huawei.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hck.httpserver.HCKHttpResponseHandler;
import com.hck.huawei.adpter.OrderAdpter;
import com.hck.huawei.bean.OrderBean;
import com.hck.huawei.bean.OrderData;
import com.hck.huawei.net.Request;
import com.hck.huawei.net.Urls;
import com.hck.huawei.util.JsonUtils;
import com.hck.huawei.view.Pdialog;
import com.hck.huaweidemo.R;

public class OrderFragment extends Fragment {
    private ListView listView;
    private TextView quxiaoTextView;
    private EditText editText;
    private OrderData orderData = new OrderData();
    private static boolean isGetDataOK = false;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.order, null);
            initView(rootView);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        editText.setText("");
        return rootView;

    }

    private void updateUI(List<OrderBean> orderBeans) {
        if (orderBeans == null) {
            return;
        }
        listView.setAdapter(new OrderAdpter(orderBeans, this.getActivity()));
    }

    public void getData() {
        Pdialog.showDialog(this.getActivity(), "正在获取订单", true);
        Request.getOrderData(Urls.GET_ORDER_DATA, new HCKHttpResponseHandler() {
            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Toast.makeText(OrderFragment.this.getActivity(), "网络异常 获取数据失败", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(String content, String requestUrl) {
                super.onSuccess(content, requestUrl);
                try {
                    JSONObject object = new JSONObject(content);
                    String data = object.getString("data");
                    Log.d("hck", "onSuccess: " + content);
                    orderData = JsonUtils.parse(data, OrderData.class);
                    isGetDataOK = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                updateUI(orderData.getOrderBeans());
            }

            @Override
            public void onFinish(String url) {
                super.onFinish(url);
                Pdialog.hiddenDialog();
            }
        });
    }

    private void initView(View view) {
        quxiaoTextView = (TextView) view.findViewById(R.id.cancle);
        editText = (EditText) view.findViewById(R.id.seach);
        listView = (ListView) view.findViewById(R.id.order_list);
        quxiaoTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                editText.setText("");
                updateUI(orderData.getOrderBeans());
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                OrderBean bean = (OrderBean) listView.getItemAtPosition(position);
                intent.putExtra("data", bean);
                intent.setClass(OrderFragment.this.getActivity(), OrderXiangXiActivity.class);
                startActivity(intent);
            }
        });
        editText.addTextChangedListener(new EditChangedListener());
    }

    class EditChangedListener implements TextWatcher {
        private CharSequence temp;// 监听前的文本
        private int editStart;// 光标开始位置
        private int editEnd;// 光标结束位置
        private final int charMaxNum = 10;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            temp = s;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            String keyString = editText.getText().toString();
            if (!TextUtils.isEmpty(keyString)) {
                seach(keyString);
            }

        }
    };

    private void seach(String data) {
        if (data == null) {
            return;
        }
        List<OrderBean> orderBeans = new ArrayList<>();
        orderBeans.clear();
        data = data.toUpperCase();
        for (int i = 0; i < orderData.getOrderBeans().size(); i++) {
            String orderIdString = orderData.getOrderBeans().get(i).getOrderId();
            if (orderIdString != null && orderIdString.contains(data)) {
                orderBeans.add(orderData.getOrderBeans().get(i));
            } else {
            }
        }
        updateUI(orderBeans);
    }

}

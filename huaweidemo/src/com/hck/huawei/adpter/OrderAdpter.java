package com.hck.huawei.adpter;

import java.util.List;

import com.hck.huawei.bean.OrderBean;
import com.hck.huaweidemo.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OrderAdpter extends BaseAdapter {
    private List<OrderBean> beans;
    private Context context;

    public OrderAdpter(List<OrderBean> beans, Context context) {
        this.beans = beans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView contentTextView1, contentTextView2, contentTextView3, contentTextView4;
        convertView = LayoutInflater.from(context).inflate(R.layout.order_item, null);
        contentTextView1 = (TextView) convertView.findViewById(R.id.content1);
        contentTextView2 = (TextView) convertView.findViewById(R.id.content2);
        contentTextView3 = (TextView) convertView.findViewById(R.id.content3);
        contentTextView4 = (TextView) convertView.findViewById(R.id.content4);
        OrderBean bean = beans.get(position);
        contentTextView1.setText(bean.getOrderId());
        String isAnQuan = bean.getTransafe();
        // 1安全、2安全预警、3安全报警
        Log.d("hck", "isAnQuan: " + bean.getTransafe());
       
        String time = bean.getEventstatus();
        Log.d("hck", "isAnQuan222: " + time);
        contentTextView2.setText(isAnQuan);
        contentTextView3.setText(time);
        try {
//            if (isAnQuan != null && isAnQuan.equals("2")) {
//                contentTextView2.setText("安全预警");
//                contentTextView2.setTextColor(context.getResources().getColor(R.color.red));
//            } else if (isAnQuan != null && isAnQuan.equals("3")) {
//                contentTextView2.setText("安全报警");
//                contentTextView2.setTextColor(context.getResources().getColor(R.color.red));
//            } else {
//                contentTextView2.setText("安全");
//                contentTextView2.setTextColor(context.getResources().getColor(R.color.order_color));
//            }
//            // 1预计准时、2预计晚点、3已经晚点
//            String time = bean.getEventstatus();
//            if (time != null && "2".equals(time)) {
//                contentTextView3.setText("预计晚点");
//                contentTextView3.setTextColor(context.getResources().getColor(R.color.red));
//            } else if (time != null && "3".equals(time)) {
//                contentTextView3.setText("已经晚点");
//                contentTextView3.setTextColor(context.getResources().getColor(R.color.red));
//            } else {
//                contentTextView3.setText("预计准时");
//                contentTextView3.setTextColor(context.getResources().getColor(R.color.order_color));
//            }
            contentTextView4.setText(bean.getCompanyname());
        } catch (Exception e) {
            Log.d("hck", "e:"+e.toString());
        }

        return convertView;
    }

}

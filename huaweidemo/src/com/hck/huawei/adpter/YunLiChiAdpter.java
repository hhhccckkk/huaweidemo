package com.hck.huawei.adpter;

import java.util.List;

import com.hck.huawei.bean.CarBean;
import com.hck.huaweidemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class YunLiChiAdpter extends BaseAdapter {
    private List<CarBean> beans;
    private Context context;

    public YunLiChiAdpter(List<CarBean> beans, Context context) {
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
         convertView=LayoutInflater.from(context).inflate(R.layout.yunli_item, null);
         TextView carNumTextView,carChangTextView,carLiangJiTextView,carUserTextView;
         carNumTextView=(TextView) convertView.findViewById(R.id.carNUM);
         carChangTextView=(TextView) convertView.findViewById(R.id.carChang);
         carLiangJiTextView=(TextView) convertView.findViewById(R.id.carLing);
         carUserTextView=(TextView) convertView.findViewById(R.id.carUser);
         CarBean carBean=beans.get(position);
         carNumTextView.setText(carBean.getCarNum());
         carChangTextView.setText(carBean.getCarChang());
         carLiangJiTextView.setText(carBean.getCarNianJI());
         carUserTextView.setText(carBean.getCarUser());
        return convertView;
    }

}

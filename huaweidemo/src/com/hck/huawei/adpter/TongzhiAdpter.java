package com.hck.huawei.adpter;

import java.util.List;

import com.hck.huawei.bean.TongZhiBean;
import com.hck.huaweidemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TongzhiAdpter extends BaseAdapter {
    private List<TongZhiBean> zhiBeans;
    private Context context;
    private boolean isBaoJing;

    public TongzhiAdpter(List<TongZhiBean> zhiBeans, Context context, boolean isBaoJing) {
        this.zhiBeans = zhiBeans;
        this.context = context;
        this.isBaoJing = isBaoJing;
    }

    @Override
    public int getCount() {
        return zhiBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return zhiBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView orderTextView, timeTextView, titleTextView, contentTextView;
        convertView = LayoutInflater.from(context).inflate(R.layout.tongzhi_item, null);
        orderTextView = (TextView) convertView.findViewById(R.id.order);
        timeTextView = (TextView) convertView.findViewById(R.id.time);
        titleTextView = (TextView) convertView.findViewById(R.id.title);

        if (isBaoJing) {
            titleTextView.setTextColor(context.getResources().getColor(R.color.qian_re));
        } else {
            titleTextView.setTextColor(context.getResources().getColor(R.color.red));
        }
        contentTextView = (TextView) convertView.findViewById(R.id.content);
        TongZhiBean bean = zhiBeans.get(position);
        orderTextView.setText(bean.getOrdercode());
        String typeString = bean.getType();
        String titleString = null;
        if ("3".equals(typeString)) {
            titleTextView.setText("离线报警");
            titleString = "离线报警";
        } else if ("4".equals(typeString)) {
            titleTextView.setText("线路偏移");
            titleString = "线路偏移";
        } else if ("1".equals(typeString)) {
            titleTextView.setText("被拆报警");
            titleString = "被拆报警";
        } else if ("2".equals(typeString)) {
            titleTextView.setText("非指定地点开锁");
            titleString = "非指定地点开锁";
        }
        timeTextView.setText(bean.getAlarmtime());
        String contentString = "订单在" + bean.getAddress() + "附近发生" + titleString + " 请及时处理";
        contentTextView.setText(contentString);
        return convertView;
    }
}

package com.hck.huawei.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.hck.huawei.adpter.TongzhiAdpter;
import com.hck.huawei.bean.TongZhiBean;
import com.hck.huaweidemo.R;

public class BaoJingTongZhiFragment extends Fragment {
    private View rootView;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.baojing_fragment, null);
            initView(rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;

    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.baojing_list);
    }

    public void updateUI(List<TongZhiBean> beans) {
        if (beans == null) {
            return;
        }
        listView.setAdapter(new TongzhiAdpter(beans, this.getActivity(), false));
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(BaoJingTongZhiFragment.this.getActivity(), OtherActivity.class);
                     startActivity(intent);                
            }
        });
    }

}

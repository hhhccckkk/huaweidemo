package com.hck.huawei.ui;

import java.util.ArrayList;
import java.util.List;

import com.hck.huawei.adpter.YunLiChiAdpter;
import com.hck.huawei.bean.CarBean;
import com.hck.huaweidemo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

public class YunLiChiFragment extends Fragment implements OnClickListener {
    private ListView listView;
    private View rootView;
    private List<CarBean> carBeans1, carBeans2, carBeans3;
    private ImageView imageView,imageView2,imageView3;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.yun_li_chi, null);
            initView(rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.carList);
        imageView=(ImageView) view.findViewById(R.id.cursor1);
        imageView2=(ImageView) view.findViewById(R.id.cursor2);
        imageView3=(ImageView) view.findViewById(R.id.cursor3);
        view.findViewById(R.id.yunli_1).setOnClickListener(this);
        view.findViewById(R.id.yunli_2).setOnClickListener(this);
        view.findViewById(R.id.yunli_3).setOnClickListener(this);
        initData();
        initCar1();
        updateUI();
    }
   private void updateUI(){
      listView.setAdapter(new YunLiChiAdpter(carBeans1, this.getActivity())); 
   }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.yunli_1:
            showView(1);
            break;
        case R.id.yunli_2:
            showView(2);
            break;
        case R.id.yunli_3:
            showView(3);
            break;
        default:
            break;
        }
    }

    private void showView(int type) {
        switch (type) {
        case 1:
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            break;
        case 2:
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            break;

        case 3:
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.VISIBLE);
            break;

        default:
            break;
        }
    }

    private void initData() {
        carBeans1 = new ArrayList<>();
        carBeans2 = new ArrayList<>();
        carBeans3 = new ArrayList<>();

    }

    private void initCar1() {
        CarBean carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);

        carBean = new CarBean();
        carBean.setCarChang("17米");
        carBean.setCarNianJI("3年");
        carBean.setCarNum("川A765555");
        carBean.setCarUser("德国邮政");
        carBeans1.add(carBean);
    }
}

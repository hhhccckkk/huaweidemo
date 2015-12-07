package com.hck.huawei.ui;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hck.httpserver.HCKHttpResponseHandler;
import com.hck.huawei.bean.TongZhiBean;
import com.hck.huawei.bean.TongZhiData;
import com.hck.huawei.net.Request;
import com.hck.huawei.net.Urls;
import com.hck.huawei.util.JsonUtils;
import com.hck.huawei.view.Pdialog;
import com.hck.huaweidemo.R;

public class SafeFragment extends BaseFragment {
    private ViewPager viewPager; // ViewPager控件
    private YuJingTongZhiFragment yuJingTongZhiFragment;
    private BaoJingTongZhiFragment baoJingTongZhiFragment;
    private List<Fragment> fragments;
    private int offset = 0; // 偏移量
    private ImageView cursor; // 横线图片
    private int bmpW; // 横线图片长度
    private LinearLayout tongzhi1, tongzhi2;
    private TongZhiData tongZhiBeans = new TongZhiData();
    private List<TongZhiBean> baoJIngBeans = new ArrayList<>();
    private List<TongZhiBean> yuJingBeans = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.safe_fragment, null);
            InitImageView(rootView);
            initView(rootView);
            initPagerView(rootView);
            getData();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;

    }

    private void initView(View view) {
        tongzhi1 = (LinearLayout) view.findViewById(R.id.tongzhi1);
        tongzhi1.setOnClickListener(new MyOnClickListener(0));
        tongzhi2 = (LinearLayout) view.findViewById(R.id.tongzhi3);
        tongzhi2.setOnClickListener(new MyOnClickListener(1));
    }

    /**
     * 切换标题下面的绿色横线条
     */
    private void InitImageView(View view) {
        cursor = (ImageView) view.findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.home_selector).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / 2 - bmpW) / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        cursor.setImageMatrix(matrix);
    }

    /**
     * 初始化viewpage
     */
    private void initPagerView(View view) {
        baoJingTongZhiFragment = new BaoJingTongZhiFragment();
        yuJingTongZhiFragment = new YuJingTongZhiFragment();
        fragments = new ArrayList<Fragment>();
        fragments.add(baoJingTongZhiFragment);
        fragments.add(yuJingTongZhiFragment);
        viewPager = (ViewPager) view.findViewById(R.id.viewpage);
        viewPager.setOffscreenPageLimit(0);
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(this.getActivity().getSupportFragmentManager(), viewPager, fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());

    }

    public class MyOnPageChangeListener implements OnPageChangeListener { // 滑动屏幕执行

        int one = offset * 2 + bmpW;

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
            case 0:
                animation = new TranslateAnimation(one, 0, 0, 0);
                changePage(0);

                break;
            case 1: // 滑动到第2个页面,进行相应的处理，比如从网路加载数据
                animation = new TranslateAnimation(offset, one, 0, 0);
                changePage(1);
                break;

            }
            // 横线图片动画
            animation.setFillAfter(true);
            animation.setDuration(300);
            cursor.startAnimation(animation);
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }

    public class MyOnClickListener implements View.OnClickListener { // 点击标题时候的操作
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            changePage(index);
        }
    };

    private void changePage(int page) {
        viewPager.setCurrentItem(page);
    }

    private void getData() {
        Pdialog.showDialog(this.getActivity(), "正在获取数据", true);
        Request.getTongZhi(Urls.GET_TZ_DATA, new HCKHttpResponseHandler() {
            @Override
            public void onSuccess(String content, String requestUrl) {
                super.onSuccess(content, requestUrl);
                Log.d("hck", "onSuccess: " + content);
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    String dataString = jsonObject.getString("data");
                    tongZhiBeans = JsonUtils.parse(dataString, TongZhiData.class);
                    initData();
                    baoJingTongZhiFragment.updateUI(baoJIngBeans);
                    yuJingTongZhiFragment.updateUI(yuJingBeans);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);

            }

            @Override
            public void onFinish(String url) {
                super.onFinish(url);
                Pdialog.hiddenDialog();
            }
        });
    }

    private void initData() {
        TongZhiBean tongZhiBean = null;
        if (tongZhiBeans == null || tongZhiBeans.getTongZhiBeans() == null) {
            return;
        }
        for (int i = 0; i < tongZhiBeans.getTongZhiBeans().size(); i++) {
            tongZhiBean = tongZhiBeans.getTongZhiBeans().get(i);
            String typeString = tongZhiBean.getType();
            if (typeString.equals("1") || typeString.equals("2")) {
                yuJingBeans.add(tongZhiBean);
            } else {
                baoJIngBeans.add(tongZhiBean);
            }

        }
    }

}

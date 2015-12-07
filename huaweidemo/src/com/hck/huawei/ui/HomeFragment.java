package com.hck.huawei.ui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hck.huawei.ui.SafeFragment.MyOnClickListener;
import com.hck.huawei.ui.SafeFragment.MyOnPageChangeListener;
import com.hck.huaweidemo.R;

public class HomeFragment extends Fragment {
    private ViewPager viewPager; // ViewPager控件
    private View rootView;
    private Fragment homeQuanQiuFragment, homeMeiZhouFragment;
    private Fragment homeOuFeiFragment, homeYaTaiFragment;
    private List<Fragment> fragments;
    private int offset = 0; // 偏移量
    private ImageView cursor; // 横线图片
    private int bmpW; // 横线图片长度
    private int mPostion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.home_fragment, null);
            initData();
            InitImageView(rootView);
            initView(rootView);
            initPagerView(rootView);
           
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View view) {
        // tongzhi1 = (LinearLayout) view.findViewById(R.id.tongzhi1);
        // tongzhi1.setOnClickListener(new MyOnClickListener(0));
        // tongzhi2 = (LinearLayout) view.findViewById(R.id.tongzhi3);
        // tongzhi2.setOnClickListener(new MyOnClickListener(1));
    }

    private void initData() {
        homeQuanQiuFragment = new HomeQuanQiuFragment();
        homeMeiZhouFragment = new HomeMeiZhouFragment();
        homeOuFeiFragment = new HomeOuFeiFragment();
        homeYaTaiFragment = new HomeYaTaiFragment();
       
    }

    /**
     * 切换标题下面的绿色横线条
     */
    private void InitImageView(View view) {
        mPostion = 0;
        cursor = (ImageView) view.findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.line_red).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / 4 - bmpW) / 4;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        cursor.setImageMatrix(matrix);
    }

    /**
     * 初始化viewpage
     */
    private void initPagerView(View view) {
        fragments = new ArrayList<Fragment>();
        fragments.add(homeQuanQiuFragment);
        fragments.add(homeMeiZhouFragment);
        fragments.add(homeOuFeiFragment);
        fragments.add(homeYaTaiFragment);
        viewPager = (ViewPager) view.findViewById(R.id.viewpage);
        viewPager.setOffscreenPageLimit(0);
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(this.getActivity().getSupportFragmentManager(), viewPager, fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());

    }

    public class MyOnPageChangeListener implements OnPageChangeListener { // 滑动屏幕执行

        int one = offset * 2 + bmpW;
        int two = offset * 3 + bmpW;
        int three = offset * 4 + bmpW;

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
            case 0:
                mPostion = 0;
                animation = new TranslateAnimation(one, 0, 0, 0);
                changePage(0);
                break;
            case 1: // 滑动到第2个页面,进行相应的处理，比如从网路加载数据
                if (mPostion == 0) {
                    animation = new TranslateAnimation(offset, one, 0, 0);
                } else {
                    animation = new TranslateAnimation(two, one, 0, 0);
                }
                mPostion = 1;
                changePage(1);
                break;
            case 2: // 滑动到第2个页面,进行相应的处理，比如从网路加载数据
                
                if (mPostion == 2) {
                    animation = new TranslateAnimation(offset, two, 0, 0);
                } else {
                    animation = new TranslateAnimation(two, two, 0, 0);
                }
                mPostion = 2;
                changePage(2);
                break;
            case 3: // 滑动到第2个页面,进行相应的处理，比如从网路加载数据
                animation = new TranslateAnimation(two, three, 0, 0);
                changePage(3);
                mPostion = 3;
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

}

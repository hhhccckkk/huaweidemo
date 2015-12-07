package com.hck.huawei.ui;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.hck.huaweidemo.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements OnClickListener {
    private SlidingMenu mSlidingMenu;
    private MainMenuFragment mMenuFrag;
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private SafeFragment safeFragment;
    private YunLiChiFragment yunLiChiFragment;
    private XiaoJiFragment xiaoJiFragment;
    private Fragment mContent;
    private TextView titleTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initHome();
        initSlidingMenu(savedInstanceState);
        setListener();

    }

    public void showToast(View view) {
        Toast.makeText(this, "开发中", Toast.LENGTH_LONG).show();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        safeFragment = new SafeFragment();
        yunLiChiFragment = new YunLiChiFragment();
        xiaoJiFragment = new XiaoJiFragment();
    }

    private void initHome() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, homeFragment).commit();
        titleTextView = (TextView) findViewById(R.id.titleCenterTV);
    }

    private void setListener() {
        findViewById(R.id.titleBackBtn).setOnClickListener(this);
    }

    private void initSlidingMenu(Bundle savedInstanceState) {
        setBehindContentView(R.layout.menu_frame);
        mContent = homeFragment;
        if (savedInstanceState == null) {
            FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
            mMenuFrag = MainMenuFragment.newInstance(this);
            t.replace(R.id.menu_frame, mMenuFrag);
            t.commit();
        } else {
            mMenuFrag = (MainMenuFragment) this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
            mMenuFrag.setMainAct(this);
        }

        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.LEFT); // 左边滑动
        mSlidingMenu.setShadowDrawable(R.drawable.shadow); // 阴影效果
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN); // 边线才有效果
        mSlidingMenu.setShadowWidthRes(R.dimen.slidingmenu_shadow_width);
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
    }

    public void switchContent(Fragment fragment) {
        if (mContent != null && mContent.equals(fragment)) {
            mSlidingMenu.toggle();
            return;
        }
        mContent = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();
        getSlidingMenu().showContent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.titleBackBtn:
            mSlidingMenu.toggle();
            updateTitle("首页");
            break;
        case R.id.order:
            updateTitle("订单列表");
            switchContent(orderFragment);
            orderFragment.getData();
            break;
        case R.id.home:
            updateTitle("首页");
            switchContent(homeFragment);
            break;
        case R.id.safe:
            updateTitle("安全中心");
            switchContent(safeFragment);
            break;
        case R.id.yunli:
            updateTitle("运力池");
            switchContent(yunLiChiFragment);
            break;
        case R.id.xiaoji:
            updateTitle("效绩");
            switchContent(xiaoJiFragment);
            break;
        case R.id.exit:
            finish();
            System.exit(0);
            break;
        default:
            break;
        }

    }

    private void updateTitle(String title) {
        titleTextView.setText(title);
    }

    private long mExitTime;
    private static final int CLICK_TIME_INTERVAL = 2000;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 按返回键时候，提示用户是否退出
        if ((System.currentTimeMillis() - mExitTime) > CLICK_TIME_INTERVAL) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_LONG).show();
            mExitTime = System.currentTimeMillis();
        } else {

            finish();
            System.gc();
            super.onBackPressed();
        }
        return false;
    }

}

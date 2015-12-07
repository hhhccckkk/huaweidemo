package com.hck.huawei.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hck.huawei.view.TitleBar;

/**
 * 基础界面.
 */
public class BaseActivity extends FragmentActivity {
    protected TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean getAirplaneMode() {
        int isAirplaneMode = Settings.System.getInt(this.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0);
        return (isAirplaneMode == 1) ? true : false;
       
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void setContentView(int layout) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initTitleBar();
        ViewGroup root = getRootView();
        View paramView = getLayoutInflater().inflate(layout, null);
        root.addView(mTitleBar, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        root.addView(paramView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        super.setContentView(root);
    }

    private ViewGroup getRootView() {
        LinearLayout localLinearLayout = new LinearLayout(this);
        localLinearLayout.setOrientation(LinearLayout.VERTICAL);
        return localLinearLayout;
    }

    private void initTitleBar() {
        mTitleBar = new TitleBar(this);
    }

    public TitleBar getTitleBar() {
        return mTitleBar;
    }

    public String getStringData(int id) {
        return getResources().getString(id);
    }

    public void initTitle(String content) {
        mTitleBar.setTitleContent(content);
        

    }

    public void startActivity(Class<?> class1) {
        startActivity(new Intent(this, class1));
    }
    
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}

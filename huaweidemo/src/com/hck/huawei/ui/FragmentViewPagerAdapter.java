package com.hck.huawei.ui;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
/**
 * ViewPager 数据适配器，为viewpager增加页卡
 * @author Administrator
 *
 */
public class FragmentViewPagerAdapter extends PagerAdapter {
	private List<Fragment> fragments; // 每个Fragment对应�?��Page
	private FragmentManager fragmentManager;
	private ViewPager viewPager; // viewPager对象
	private int currentPageIndex = 0; // 当前page索引（切换之前）
	public FragmentViewPagerAdapter(FragmentManager fragmentManager,
			ViewPager viewPager, List<Fragment> fragments) {
		this.fragments = fragments;
		this.fragmentManager = fragmentManager;
		this.viewPager = viewPager;
		this.viewPager.setAdapter(this);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object o) {
		return view == o;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(fragments.get(position).getView()); // 移出viewpager两边之外的page布局
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Fragment fragment = fragments.get(position);
		if (!fragment.isAdded()) { // 如果fragment还没有added
			FragmentTransaction ft = fragmentManager.beginTransaction();
			ft.add(fragment, fragment.getClass().getSimpleName());
			ft.commit();
			fragmentManager.executePendingTransactions();
		}
         if (fragment.getView()!=null) {
        	 if (fragment.getView().getParent() == null) {
     			container.addView(fragment.getView()); // 为viewpager增加布局
     		}
		}

		return fragment.getView();
	}

	/**
	 * 当前page索引（切换之前）
	 * 
	 * @return
	 */
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

}

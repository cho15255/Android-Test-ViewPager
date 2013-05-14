package com.example.applicationactivity;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.CalendarContract.Instances;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;

public class ApplicationActivity extends Activity implements ViewPager.OnPageChangeListener {

	private ApplicationActivityAdapter mAdapter;
	private ViewPager mPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_activity);
        mAdapter = new ApplicationActivityAdapter(this);
        
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(5);
        mPager.setOnPageChangeListener(this);
        mPager.setAdapter(mAdapter);
    }

    
    private static final class ApplicationActivityAdapter extends PagerAdapter {
    	private static final int[] LAYOUT_IDS = {R.layout.page_1, R.layout.page_2, R.layout.page_3};
    	private final WeakReference<ApplicationActivity> mActivity;
    	
		public ApplicationActivityAdapter(
				ApplicationActivity applicationActivity) {
			mActivity = new WeakReference<ApplicationActivity>(applicationActivity);
		}
		
		public void destroy() {
			mActivity.clear();
		}

		@Override
		public int getCount() {
			return LAYOUT_IDS.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == obj;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = null;
			if (mActivity.get() != null) {
				final ApplicationActivity activity = mActivity.get();
				view = activity.getLayoutInflater().inflate(LAYOUT_IDS[position], null);
				
				container.addView(view);
			}
			
			return view;
		}
    	
    }
    
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}
    
}

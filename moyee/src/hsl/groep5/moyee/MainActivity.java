package hsl.groep5.moyee;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity  extends SherlockFragmentActivity {
	PagerAdapter mPagerAdapter;
	ViewPager mViewPager;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ArrayList<String> titles = new ArrayList<String>();
	MapsFragment gmaps = new MapsFragment();
	WebshopFragment webshop = new WebshopFragment();
	FragmentWelcome fragmentWelcome = new FragmentWelcome();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("CHECK", "MainActivity onCreate()");
		setContentView(R.layout.activity_main);
		
		mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles);
		
		titles.add(getResources().getString(R.string.welcome_option1));
		titles.add(getResources().getString(R.string.welcome_option));
		titles.add(getResources().getString(R.string.welcome_option2));
		titles.add(getResources().getString(R.string.welcome_option3));
		fragments.add(gmaps);
		fragments.add(fragmentWelcome);
		fragments.add(webshop);
		
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter); 
		mViewPager.setCurrentItem(2);
	}
}
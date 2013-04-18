package hsl.groep5.moyee;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.WindowManager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

public class MainActivity  extends SherlockFragmentActivity {
	PagerAdapter mPagerAdapter;
	ViewPager mViewPager;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ArrayList<String> titles = new ArrayList<String>();
	MapsFragment gmaps = new MapsFragment();
	WebshopFragment webshop = new WebshopFragment();
	FragmentWelcome fragmentWelcome = new FragmentWelcome();
	CoffeeFragment coffeeFragment = new CoffeeFragment();
	ActionBar actionbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("CHECK", "MainActivity onCreate()");
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		
		mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles);
		
		titles.add(getResources().getString(R.string.welcome_option1));
		titles.add(getResources().getString(R.string.welcome_option));
		titles.add(getResources().getString(R.string.welcome_option2));
		titles.add(getResources().getString(R.string.welcome_option3));
		
		fragments.add(gmaps);
		fragments.add(fragmentWelcome);
		fragments.add(webshop);
		fragments.add(coffeeFragment);
		
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter); 
		mViewPager.setCurrentItem(2);
		
		actionbar = getSupportActionBar();
		
	    PagerTabStrip strip = (PagerTabStrip)findViewById(R.id.tabStrip);
	    strip.setTabIndicatorColor(getResources().getColor(R.color.green));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getSupportMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
}
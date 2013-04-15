package hsl.groep5.moyee;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
	ActionBar actionbar;
	ArrayList<Drawable> icons = new ArrayList<Drawable>(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("CHECK", "MainActivity onCreate()");
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		
		mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles, icons);
		
		titles.add(getResources().getString(R.string.welcome_option1));
		titles.add(getResources().getString(R.string.welcome_option));
		titles.add(getResources().getString(R.string.welcome_option2));
		titles.add(getResources().getString(R.string.welcome_option3));
		
		icons.add(getResources().getDrawable(R.drawable.map));
		icons.add(getResources().getDrawable(R.drawable.about));
		icons.add(getResources().getDrawable(R.drawable.marker));
		
		fragments.add(gmaps);
		fragments.add(fragmentWelcome);
		fragments.add(webshop);
		
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter); 
		mViewPager.setCurrentItem(2);
		
		actionbar = getSupportActionBar();			
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getSupportMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
}
package hsl.groep5.moyee;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{
	TabPagerAdapter mTabPagerAdapter;
	ViewPager mViewPager;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ArrayList<String> titles = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Locale l = Locale.getDefault();
		
		mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), fragments,titles);
		fragments.add(new FragmentOption1());
		titles.add(getString(R.string.welcome_option1).toUpperCase(l));
		fragments.add(new FragmentOption2());
		titles.add(getString(R.string.welcome_option2).toUpperCase(l));
		fragments.add(new FragmentOption3());
		titles.add(getString(R.string.welcome_option3).toUpperCase(l));
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mTabPagerAdapter);
		
		TextView welcome = (TextView) findViewById(R.id.welcome_message);
	    Typeface font = Typeface.createFromAsset(getAssets(), "fonts/delicious-roman-webfont.ttf");  
	    welcome.setTypeface(font);    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

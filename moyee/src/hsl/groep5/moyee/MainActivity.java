package hsl.groep5.moyee;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity{
	PagerAdapter mPagerAdapter;
	ViewPager mViewPager;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ArrayList<String> titles = new ArrayList<String>();
	FragmentOption1 fragment1 = new FragmentOption1();
	FragmentOption2 fragment2 = new FragmentOption2();
	FragmentOption3 fragment3 = new FragmentOption3();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles);
		
		titles.add(getResources().getString(R.string.welcome_option1));
		titles.add(getResources().getString(R.string.welcome_option2));
		titles.add(getResources().getString(R.string.welcome_option3));
		fragments.add(fragment1);
		fragments.add(fragment2);
		fragments.add(fragment3);

		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

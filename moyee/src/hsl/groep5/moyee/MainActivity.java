package hsl.groep5.moyee;

import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity implements OnClickListener{
	TabPagerAdapter mTabPagerAdapter;
	ViewPager mViewPager;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ArrayList<String> titles = new ArrayList<String>();
	FragmentOption1 fragment1 = new FragmentOption1();
	FragmentOption2 fragment2 = new FragmentOption2();
	FragmentOption3 fragment3 = new FragmentOption3();
	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Locale l = Locale.getDefault();
		
		mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), fragments,titles);
		fragments.add(fragment1);
		titles.add(getString(R.string.welcome_option1).toUpperCase(l));
		fragments.add(fragment2);
		titles.add(getString(R.string.welcome_option2).toUpperCase(l));
		fragments.add(fragment3);
		titles.add(getString(R.string.welcome_option3).toUpperCase(l));
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mTabPagerAdapter); 
		/*
	    fragmentManager = getSupportFragmentManager();
	    fragmentTransaction = fragmentManager.beginTransaction();

		fragmentManager.beginTransaction()
			.add(R.id.fragment1, fragment1)
			.add(R.id.fragment2, fragment2)
			.add(R.id.fragment3, fragment3)
			.commit(); 
		
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		/*switch(arg0.getId()){
			case R.id.welcome_button2:
			    fragmentTransaction.remove(fragment1);
			    fragmentTransaction.replace(R.id.fragment1, fragment2);
			    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			    fragmentTransaction.addToBackStack(null);
			    fragmentTransaction.commit();   
		}
		*/
	}
}

package hsl.groep5.moyee;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener{
	PagerAdapter mTabPagerAdapter;
	ViewPager mViewPager;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ArrayList<String> titles = new ArrayList<String>();
	FragmentOption1 fragment1 = new FragmentOption1();
	FragmentOption2 fragment2 = new FragmentOption2();
	FragmentOption3 fragment3 = new FragmentOption3();
	Button button1;
	Button button2;
	Button button3;
	FragmentManager fragmentManager = getSupportFragmentManager();
	FragmentTransaction fragmentTransaction;
	int current_fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTabPagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
		
		fragments.add(fragment1);
		fragments.add(fragment2);
		fragments.add(fragment3);

		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mTabPagerAdapter); 
		
		button1 = (Button) findViewById(R.id.welcome_button1);
		button1.setOnClickListener(this);
		button2 = (Button) findViewById(R.id.welcome_button2);
		button2.setOnClickListener(this);
		button3 = (Button) findViewById(R.id.welcome_button3);
		button3.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onAttachFragment(Fragment fragment) {
		current_fragment = fragment.getId();
	}

	@Override
	public void onClick(View arg0) {
		fragmentTransaction = fragmentManager.beginTransaction();
		switch(arg0.getId()){
			case R.id.welcome_button1:
			    fragmentTransaction.replace(current_fragment,fragment1);
			case R.id.welcome_button2:
			    fragmentTransaction.replace(current_fragment,fragment2);		
			case R.id.welcome_button3:
			    fragmentTransaction.replace(current_fragment,fragment3);
		}
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
}

package hsl.groep5.moyee;

import java.util.ArrayList;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ArrayList<Fragment> fragments = new ArrayList<Fragment>(); 
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    
		TextView welcome = (TextView) findViewById(R.id.welcome_message);
	    Typeface font = Typeface.createFromAsset(getAssets(), "fonts/delicious-roman-webfont.ttf");  
	    welcome.setTypeface(font);
		
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragments);
		fragments.add(new FragmentOption1());
		fragments.add(new FragmentOption2());
		fragments.add(new FragmentOption3());
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

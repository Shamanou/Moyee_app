package hsl.groep5.moyee;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
	ArrayList<Fragment> fragments;
	
	public SectionsPagerAdapter(FragmentManager fm,ArrayList<Fragment> f) {
		super(fm);
		this.fragments = f;
	}

	@Override
	public Fragment getItem(int position) {
		Bundle args;
		switch (position){
			case 0:
				Fragment option_one = new FragmentOption1();
				args = new Bundle();
				//args.putInt(FragmentOption1.ARG_SECTION_NUMBER, position + 1);
				option_one.setArguments(args);
				return option_one;
			case 1:
				Fragment option_two = new FragmentOption2();
				args = new Bundle();
				//args.putInt(FragmentOption2.ARG_SECTION_NUMBER, position + 2);
				option_two.setArguments(args);
				return option_two;
			case 2:
				Fragment option_three = new FragmentOption3();
				args = new Bundle();
				//args.putInt(FragmentOption3.ARG_SECTION_NUMBER, position + 3);
				option_three.setArguments(args);
				return option_three;
		}
		return null;
	}

	@Override
	public int getCount() {
		// Show 3 total pages.
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		/*Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return getString(R.string.welcome_option1).toUpperCase(l);
		case 1:
			return getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return getString(R.string.title_section3).toUpperCase(l);
		}
		*/
		return null;
	}
}

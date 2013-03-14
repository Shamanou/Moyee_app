package hsl.groep5.moyee;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter{
	private List <Fragment> fragmentlist;
	private List <String> titles;
	
	public TabPagerAdapter(FragmentManager fm,ArrayList<Fragment> f, ArrayList<String> t) {
		super(fm);
		this.fragmentlist = f;
		this.titles = t;
	}

	@Override
	public Fragment getItem(int index) {
		return fragmentlist.get(index);
	}

	@Override
	public int getCount() {
		return fragmentlist.size();
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return titles.get(position);
	}
}

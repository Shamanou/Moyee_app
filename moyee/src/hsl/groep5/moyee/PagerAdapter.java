package hsl.groep5.moyee;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter{
	private List <Fragment> fragmentlist;
	
	public PagerAdapter(FragmentManager fm,ArrayList<Fragment> f) {
		super(fm);
		this.fragmentlist = f;
	}

	@Override
	public Fragment getItem(int index) {
		return fragmentlist.get(index);
	}

	@Override
	public int getCount() {
		return fragmentlist.size();
	}
}

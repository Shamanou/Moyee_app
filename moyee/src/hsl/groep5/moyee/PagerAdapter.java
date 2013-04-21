package hsl.groep5.moyee;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

/**
* @title Pager Adapter Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

public class PagerAdapter extends FragmentStatePagerAdapter{
	private List <Fragment> fragmentlist;
	private List <String> titles;
	public PagerAdapter(FragmentManager fm,ArrayList<Fragment> f, ArrayList<String> t) {
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
	public CharSequence getPageTitle(int position){
		return titles.get(position);
	}
}

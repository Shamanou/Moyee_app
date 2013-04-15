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

public class PagerAdapter extends FragmentStatePagerAdapter{
	private List <Fragment> fragmentlist;
	private List <String> titles;
	private ArrayList<Drawable> icons;
	public PagerAdapter(FragmentManager fm,ArrayList<Fragment> f, ArrayList<String> t,ArrayList<Drawable> d) {
		super(fm);
		this.fragmentlist = f;
		this.titles = t;
		this.icons = d;
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
		Drawable drawable = icons.get(position);
		SpannableStringBuilder sb = new SpannableStringBuilder(String.valueOf(position));
		drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
		sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return sb;
	}
}

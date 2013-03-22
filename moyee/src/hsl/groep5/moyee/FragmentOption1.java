package hsl.groep5.moyee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

public class FragmentOption1 extends Fragment{
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState); 
		View rootView = inflater.inflate(R.layout.fragmentoption2, null);
	    //Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/delicious-roman-webfont.ttf");  
	    //((TextView) rootView).setTypeface(font);
		return rootView;
	}
}
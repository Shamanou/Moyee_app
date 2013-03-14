package hsl.groep5.moyee;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOption3 extends Fragment implements OnClickListener{
	public static final String ARG_SECTION_NUMBER = "section_number";	
	public FragmentOption3(){	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		View rootView = inflater.inflate(R.layout.fragmentoption3,container, false);		
	    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/delicious-roman-webfont.ttf");  
	    ((TextView) rootView).setTypeface(font);
	    rootView.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
}
package hsl.groep5.moyee;

import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOption1 extends Fragment{
	public static final String ARG_SECTION_NUMBER = "section_number";
	private MapController mc;
	private MapView mapView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		View rootView = inflater.inflate(R.layout.fragmentoption1, null);
	    mapView = (MapView)getActivity().findViewById(R.id.map);
		mc = mapView.getController();
		//Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/delicious-roman-webfont.ttf");  
	    //((TextView) rootView).setTypeface(font);
		return mapView;
	}
}
package hsl.groep5.moyee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class FragmentOption1 extends SupportMapFragment{
	public static final String ARG_SECTION_NUMBER = "section_number";
	private GoogleMap mMap;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		View rootView = inflater.inflate(R.layout.fragmentoption1, null);
		mMap = getMap();
		return rootView;
	}
}
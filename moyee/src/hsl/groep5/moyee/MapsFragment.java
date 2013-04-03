package hsl.groep5.moyee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

public class MapsFragment extends Fragment{
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption1 onCreateView()");
		View rootView = inflater.inflate(R.layout.fragmentoption1, null);
		return rootView;
	}
}
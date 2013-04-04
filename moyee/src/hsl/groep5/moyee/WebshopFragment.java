package hsl.groep5.moyee;

import com.google.android.gms.maps.SupportMapFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WebshopFragment extends SupportMapFragment implements HttpAPIResult {
	public static final String ARG_SECTION_NUMBER = "section_number";	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption2 onCreateView()");
		View rootView = inflater.inflate(R.layout.fragmentoption2, null);
		new HttpAPI(this).execute("http://mike.k0k.nl/test.php?id=123");
		return rootView;
	}

	@Override
	public void onHttpResult(String result, int id) {
		// TODO Auto-generated method stub
	}
}

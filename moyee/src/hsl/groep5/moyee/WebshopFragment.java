package hsl.groep5.moyee;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

public class WebshopFragment extends SupportMapFragment implements HttpAPIResult {
	public static final String ARG_SECTION_NUMBER = "section_number";	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption2 onCreateView()");
		new HttpAPI(this).execute("http://mike.k0k.nl/test.php?id=123");
		
		View rootView = inflater.inflate(R.layout.shopview, null);
		return rootView;
	}

	@Override
	public void onHttpResult(String result, int id) {
		// TODO Auto-generated method stub
	}
}

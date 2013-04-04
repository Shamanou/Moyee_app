package hsl.groep5.moyee;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment implements LocationListener {
	public static final String ARG_SECTION_NUMBER = "section_number";
	private SupportMapFragment mMap;
	private LocationManager locationManager;
	private String provider;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption1 onCreateView()");
		
	    // Get the location manager
	    locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
	    // Define the criteria how to select the locatioin provider -> use
	    // default
	    Criteria criteria = new Criteria();
	    provider = locationManager.getBestProvider(criteria, false);
	    Location location = locationManager.getLastKnownLocation(provider);
		mMap = this;
		if (mMap != null){
			onLocationChanged(location);
		}
		View rootView = inflater.inflate(R.layout.maps_fragmentoption, null);
		return rootView;
	}

	@Override
	public void onLocationChanged(Location location) {
		
		location = locationManager.getLastKnownLocation("gps"); 
		if (location != null)
		{
		getMap().addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Hello world"));
		//	Log.d("location", String.valueOf(location.getLatitude()) + " " + String.valueOf(location.getAltitude()));
		}	
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}	
}
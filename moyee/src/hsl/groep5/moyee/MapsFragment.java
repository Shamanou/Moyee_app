package hsl.groep5.moyee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
* @title Google Maps Fragment Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @param S1043619
* @since 04-04-2013
* @version 1.0
*/

public class MapsFragment extends SherlockFragment implements HttpAPIResult,  LocationListener{
	public static final String ARG_SECTION_NUMBER = "section_number";
	static final LatLng HOGESCHOOL = new LatLng(52.167009,4.467101 );
	private GoogleMap map;
	JSONObject jsonObject;
	private LocationManager locationManager;
	private String provider;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption1 onCreateView()");

		View rootView = inflater.inflate(R.layout.mapview, null);
		
		 map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 map.moveCamera(CameraUpdateFactory.newLatLngZoom(HOGESCHOOL, 15));
		 map.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null); 
		 locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
		 Criteria criteria = new Criteria();
		 provider = locationManager.getBestProvider(criteria, true);
		 map.setMyLocationEnabled(true);
		 Location location = locationManager.getLastKnownLocation(provider);

		 if (location != null) {
		      System.out.println("Provider " + provider + " has been selected.");
		      onLocationChanged(location);
		 }

	
		new HttpAPI(this).execute(getResources().getString(R.string.moyee_api_url) + "?get=locations");
		 		
		return rootView;
	}


	@Override
	public void onHttpResult(String result, int id) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(result);
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		//haal de array 'data' uit het object
		JSONArray data = null;
		try {
			data = jsonObject.getJSONArray("data");
		} catch (JSONException e) {
			
			e.printStackTrace();
		}

		//loop door de array heen
		  for (int i = 0; i < data.length(); i++) {
		         //pak een item uit de array
		        JSONObject item = null;
				try {
					item = data.getJSONObject(i);
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
		        try {
		        	//marker locatie maken van lat/long uit database
		        	LatLng markerLoc = new LatLng( item.getDouble("lat") , item.getDouble("lng") );
		        	//Marker toevoegen op deze locatie met title, description en het standaard icoon
		        	Marker marker = map.addMarker(new MarkerOptions().position(markerLoc)
		        			.title(item.getString("title"))
		        			.snippet(item.getString("description"))
		  		      	  	.icon(BitmapDescriptorFactory
				                  .fromResource(R.drawable.marker)
				                  )
				          );
					
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
	}}


	@Override
	public void onLocationChanged(Location location) {
		 double lat = (double) (location.getLatitude());
		 double lng = (double) (location.getLongitude());
		 LatLng personLoc = new LatLng(lat,lng);
		 map.moveCamera(CameraUpdateFactory.newLatLngZoom(personLoc, 15));

		
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
	
	public void onDestroyView() {
        super.onDestroyView(); 
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));  
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
}
}
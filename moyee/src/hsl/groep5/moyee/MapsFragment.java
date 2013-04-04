package hsl.groep5.moyee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFragment extends Fragment implements HttpAPIResult{
	public static final String ARG_SECTION_NUMBER = "section_number";
	static final LatLng HOGESCHOOL = new LatLng(52.167009,4.467101 );
	private GoogleMap map;
	JSONObject jsonObject;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption1 onCreateView()");
		View rootView = inflater.inflate(R.layout.fragmentoption1, null);
		
		 map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 map.moveCamera(CameraUpdateFactory.newLatLngZoom(HOGESCHOOL, 15));
		 map.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null); 
		 
	
		new HttpAPI(this).execute("http://mike.k0k.nl/moyeeapi.php?get=locations");
		 
		
		return rootView;
	}


	@Override
	public void onHttpResult(String result, int id) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//haal de array 'data' uit het object
		JSONArray data = null;
		try {
			data = jsonObject.getJSONArray("data");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//loop door de array heen
		  for (int i = 0; i < data.length(); i++) {
		         //pak een item uit de array
		        JSONObject item = null;
				try {
					item = data.getJSONObject(i);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
		        	LatLng markerLoc = new LatLng( item.getDouble("lat") , item.getDouble("long") );
		        	Marker marker = map.addMarker(new MarkerOptions().position(markerLoc)
		        			.title(item.getString("title"))
		        			.snippet(item.getString("description"))
		  		      	  	.icon(BitmapDescriptorFactory
				                  .fromResource(R.drawable.marker)
				                  )
				          );
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}}
}
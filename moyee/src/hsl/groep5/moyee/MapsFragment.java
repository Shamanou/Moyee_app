package hsl.groep5.moyee;

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


public class MapsFragment extends Fragment{
	public static final String ARG_SECTION_NUMBER = "section_number";
	static final LatLng HOGESCHOOL = new LatLng(52.167009,4.467101 );
	static final LatLng STATION = new LatLng(52.165956,4.481478);
	private GoogleMap map;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption1 onCreateView()");
		View rootView = inflater.inflate(R.layout.fragmentoption1, null);
		
		 map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 map.moveCamera(CameraUpdateFactory.newLatLngZoom(HOGESCHOOL, 15));
		 map.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null); 
		 
		 if (map!= null){
		      Marker station = map.addMarker(new MarkerOptions().position(STATION)
		          .title("Moyee Station Leiden")
		      	  .snippet("Hier verkopen we Moyee Koffie")
		      	  .icon(BitmapDescriptorFactory
		                  .fromResource(R.drawable.fairchain_coffee)
		                  )
		          );
		      
		 }
		
		return rootView;
	}
}
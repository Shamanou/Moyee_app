package hsl.groep5.moyee;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

public class WebshopFragment extends SupportMapFragment implements
		HttpAPIResult {
	public static final String ARG_SECTION_NUMBER = "section_number";
	GridView grid_main;
	ImageAdapter imageAdapter = null;
	Button button;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption2 onCreateView()");
		View rootView = inflater.inflate(R.layout.shopview, null);
		grid_main = (GridView) rootView
				.findViewById(R.id.welcome_option2_items);
		this.imageAdapter = new ImageAdapter(this.getActivity());
		grid_main.setAdapter(this.imageAdapter);
		grid_main.setOnItemClickListener(this.imageAdapter);
		new HttpAPI(this)
				.execute("http://mike.k0k.nl/moyeeapi.php?get=products");

		button = (Button) rootView.findViewById(R.id.welcome_option2_button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("test", "test");

			}

		});
		

		return rootView;
	}

	@Override
	public void onHttpResult(String result, int id) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(result);

			// haal de array 'data' uit het object
			JSONArray data = jsonObject.getJSONArray("data");
			ArrayList<Product> products = new ArrayList<Product>();
			for (int i = 0; i < data.length(); i++) {
				// pak een item uit de array
				JSONObject item = data.getJSONObject(i);
				Product p = new Product(item);
				products.add(p);
			}
			this.imageAdapter.setProducts(products);
			grid_main.invalidateViews();
		} catch (JSONException e) {

			e.printStackTrace();
		}
	}
}

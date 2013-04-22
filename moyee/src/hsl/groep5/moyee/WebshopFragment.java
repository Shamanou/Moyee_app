package hsl.groep5.moyee;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

/**
* @title Webshop Fragment Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

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
		new HttpAPI(this)
				.execute(getResources().getString(R.string.moyee_api_url) + "?get=products");

		button = (Button) rootView.findViewById(R.id.welcome_option2_button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog dialog = new AlertDialog.Builder(v.getContext()).create();
			    dialog.setTitle("Confirmation");
			    dialog.setMessage("Are you sure?");
			    dialog.setCancelable(false);
			    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int buttonId) {
			        	try {
			        		JSONObject json = new JSONObject();
							json.put("action", "order");

							SharedPreferences settings = WebshopFragment.this.getActivity().getSharedPreferences("settings", 0);
							String userName = settings.getString("name", "" );
							String userMail = settings.getString("email", "" );
							
							JSONObject user = new JSONObject();
							user.put("name", userName);
							user.put("email", userMail);
							
							json.put("user", user);
							
							JSONArray order = new JSONArray();
			        	
				        	for(int i = 0; i < WebshopFragment.this.imageAdapter.products.size(); i++)
							{
								Product p = WebshopFragment.this.imageAdapter.products.get(i);
								Log.d(p.getTitle()+ "  "+ p.getCount(), " test");
								
								if(p.getCount() > 0) {
									JSONObject product = new JSONObject();
									product.put("id", p.getId());
									product.put("count", p.getCount());
									
									order.put(product);
								}
							}
				        	
				        	json.put("products", order);
				        	Log.d("JSON", json.toString());
				        	
				        	
				        	new HttpAPI(WebshopFragment.this, 1).setParams(new BasicNameValuePair("order", json.toString())).execute(getResources().getString(R.string.moyee_api_url) + "?get=order");
			        	} catch (JSONException e) {
							e.printStackTrace();
						}
			        }
			    });
			    dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int buttonId) {}
			    });
			    dialog.setIcon(android.R.drawable.ic_dialog_alert);
			    dialog.show();
			}

		});
		

		return rootView;
	}

	@Override
	public void onHttpResult(String result, int id) {
		
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(result);
			if(id == 0) {
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
			} else if(id == 1) {
				
			}
		} catch (JSONException e) {

			e.printStackTrace();
		}

	}

}
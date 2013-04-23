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
 * @author Aart van Amersfoort, Maikel de Jong
 * @since 04-04-2013
 * @version 1.0
 */

public class WebshopFragment extends SupportMapFragment implements HttpAPIResult {
	public static final String ARG_SECTION_NUMBER = "section_number";
	GridView grid_main;
	ImageAdapter imageAdapter = null;
	Button button;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		// Inflate shopview layout
		View rootView = inflater.inflate(R.layout.shopview, null);
		
		// Get gridview from view
		grid_main = (GridView) rootView.findViewById(R.id.welcome_option2_items);
		// Create and set ImageAdapter
		imageAdapter = new ImageAdapter(this.getActivity());
		grid_main.setAdapter(this.imageAdapter);
		
		// Create and execute new
		new HttpAPI(this).execute(getResources().getString(R.string.moyee_api_url) + "?get=products");

		// Get order button from view
		button = (Button) rootView.findViewById(R.id.welcome_option2_button);
		// Create new OnClickListener for order button
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Create new dialog
				AlertDialog dialog = new AlertDialog.Builder(v.getContext()).create();
				dialog.setTitle("Confirmation");
				dialog.setMessage("Are you sure?");
				// Set cancelable false; user has to use the buttons
				dialog.setCancelable(false);
				// Set confirm button
				dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,	int buttonId) {
						// Load name and email form SharedPreferences
						SharedPreferences settings = WebshopFragment.this.getActivity().getSharedPreferences("settings", 0);
						String userName = settings.getString("name", "");
						String userMail = settings.getString("email", "");
						
						// Check is both name and email are available
						if (!userName.equals("") && !userMail.equals("")) {
							try {
								// Create new JSONObject for containing data to send to server
								JSONObject json = new JSONObject();
								json.put("action", "order");
								
								// Create new JSONObject for user info
								JSONObject user = new JSONObject();
								user.put("name", userName);
								user.put("email", userMail);

								// Add user info to main object
								json.put("user", user);

								// Create new JSONArray for order info
								JSONArray order = new JSONArray();

								// Loop through all products
								for (int i = 0; i < WebshopFragment.this.imageAdapter.products.size(); i++) {
									// Store product[i] in object p
									Product p = WebshopFragment.this.imageAdapter.products.get(i);
									
									// Check if product is ordered
									if (p.getCount() > 0) {
										// Create JSONObject for storing product order info
										JSONObject product = new JSONObject();
										// Add product id
										product.put("id", p.getId());
										// Add order count
										product.put("count", p.getCount());
										// Add product order info to order object
										order.put(product);
									}
								}
								
								// Add order info to main object
								json.put("products", order);

								// Create a new async http request
								new HttpAPI(WebshopFragment.this, 1)
									// Set order parameter for posting
									.setParams(new BasicNameValuePair("order", json.toString()))
									// Execute request
									.execute(getResources().getString(R.string.moyee_api_url) + "?get=order");
							} catch (JSONException e) {
								e.printStackTrace();
							}
						} else {

						}
					}

				});
				
				// Set cancel button
				dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
					// Do nothing
					public void onClick(DialogInterface dialog, int buttonId) {}
				});
				dialog.setIcon(android.R.drawable.ic_dialog_alert);
				// Show dialog
				dialog.show();
			}
		});

		return rootView;
	}

	@Override
	public void onHttpResult(String result, int id) {
		JSONObject jsonObject = null;
		try {
			// Parse http result string to JSONObject
			jsonObject = new JSONObject(result);
			
			// Check request id
			switch(id) {
				case 0:
					// Get 'data' array form jsonObject
					JSONArray data = jsonObject.getJSONArray("data");
					
					ArrayList<Product> products = new ArrayList<Product>();
					
					// Loop through 'data'
					for (int i = 0; i < data.length(); i++) {
						// Get JSONObject data[i]
						JSONObject item = data.getJSONObject(i);
						// Create new Product object from JSONObject item
						Product p = new Product(item);
						// Add product to list
						products.add(p);
					}
					
					// Set product list in adapter
					imageAdapter.setProducts(products);
					// Invalidate views for refresh
					grid_main.invalidateViews();
					break;
				case 1:
					// Show server confirmation
					// @todo
					break;			
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}

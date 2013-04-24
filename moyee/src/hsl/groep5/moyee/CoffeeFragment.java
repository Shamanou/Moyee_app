package hsl.groep5.moyee;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

/**
* @title Informatie fragment Moyee applicatie
* @author Shamanou van Leeuwen
* @param S1043619
* @since 04-04-2013
* @version 1.0
*/

public class CoffeeFragment extends SherlockFragment implements HttpAPIResult {
	private InfoAdapter listadapter;
	private ListView listview;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption3 onCreateView()");
		View rootView = inflater.inflate(R.layout.koffieview, null);
		Log.d("","view created..");
		listview = (ListView) rootView.findViewById(R.id.coffee_list);
		this.listadapter = new InfoAdapter(this.getActivity());
		listview.setAdapter(listadapter);
		listview.setOnItemClickListener(listadapter);
		new HttpAPI(this).execute(getResources().getString(R.string.moyee_api_url) + "?get=products");
		return rootView;
	}
	
	@Override
	public void onHttpResult(String result, int id) {
		JSONObject jsonObject = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			jsonObject = new JSONObject(result);
	
			// haal de array 'data' uit het object	
			JSONArray data = jsonObject.getJSONArray("data");
			for (int i = 0; i < data.length(); i++) {
		         //pak een item uit de array
		        JSONObject item = data.getJSONObject(i);
		        Product p = new Product(item);
		        products.add(p);
			}
			this.listadapter.setProducts(products);
			this.listview.invalidateViews();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
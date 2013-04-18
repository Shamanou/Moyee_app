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

public class CoffeeFragment extends SherlockFragment implements HttpAPIResult {
	private ListAdapter listadapter;
	private ListView listview;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption3 onCreateView()");
		View rootView = inflater.inflate(R.layout.koffieview, null);
		listview = (ListView) rootView.findViewById(R.id.coffee_list);
		this.listadapter = new ListAdapter(this.getActivity());
		listview.setAdapter(this.listadapter);
		new HttpAPI(this).execute("http://mike.k0k.nl/moyeeapi.php?get=products");
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
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.listadapter.setProducts(products);
		this.listview.invalidateViews();
	}
}
package hsl.groep5.moyee;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

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
			this.listadapter.setProducts(products);
			this.listview.invalidateViews();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void showInformation() {
		//set up dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.informationview);
        dialog.setTitle("Login");
        dialog.setCancelable(false);
        
        
        
        SharedPreferences settings = getSharedPreferences("settings", 0);
		String name = settings.getString("name", "" );
		String email = settings.getString("email", "" );
		
		EditText txtName = (EditText) dialog.findViewById(R.id.username);
		txtName.setText(name);
		
		TextView txtEmail = (TextView) dialog.findViewById(R.id.email);
		txtEmail.setText(email);
        
        //set up button
        Button btnSave = (Button) dialog.findViewById(R.id.save);
        btnSave.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
	        	SharedPreferences settings = getSharedPreferences("settings", 0);
	        	Editor edit = settings.edit();
	        	EditText txtName = (EditText) dialog.findViewById(R.id.username);
	        	edit.putString("name", txtName.getText().toString());
	        	EditText txtEmail = (EditText) dialog.findViewById(R.id.email);
	        	edit.putString("email", txtEmail.getText().toString());
	        	edit.commit();
	        	dialog.dismiss();
            }
        });
        
        Button btnSkip = (Button) dialog.findViewById(R.id.skip);
        btnSkip.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
	        	dialog.dismiss();
            }
        });
        //now that the dialog is set up, it's time to show it    
        dialog.show();
	}
}
package hsl.groep5.moyee;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.util.Xml.Encoding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
* @title infoAdapter
* @author Shamanou van Leeuwen
* @param S1043619
* @since 04-04-2013
* @version 1.0
*/

public class InfoAdapter extends BaseAdapter implements OnItemClickListener{
	private final Context context;
	private ArrayList<Product> products;
	
	public InfoAdapter(Context context) {
		super();
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
        if(convertView==null){
        	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        	Log.d("listadapter","list adapter used..");
        	View rowView = inflater.inflate(R.layout.koffierow, null);
        	TextView textView = (TextView) rowView.findViewById(R.id.row);
        	textView.setText(products.get(position).getTitle());
        	v = textView;
        } else{
        	v = convertView;
        }
		return v;
	}

	

	@Override
	public int getCount() {
		if(this.products != null) {
			return this.products.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
		Log.d("","view created2..");
	}
	
	public void showInformation(Product product) {
		//set up dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.informationview);
        dialog.setTitle(product.getTitle());
        dialog.setCancelable(true);

		WebView code = (WebView) dialog.findViewById(R.id.webView);
		code.loadData(product.getDescription(), "text/html", Encoding.UTF_8.toString());
		
        //now that the dialog is set up, it's time to show it    
        dialog.show();
	}

	@Override
	public void onItemClick(AdapterView<?> a, View v, int i, long l) {
		showInformation(products.get(i));
	}
}
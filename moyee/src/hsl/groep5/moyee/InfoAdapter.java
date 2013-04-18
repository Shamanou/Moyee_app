package hsl.groep5.moyee;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InfoAdapter extends BaseAdapter implements OnClickListener{
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
	public void onClick(View v) {
		
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
}
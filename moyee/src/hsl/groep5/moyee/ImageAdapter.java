package hsl.groep5.moyee;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
* @title Image Adapter Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

public class ImageAdapter extends BaseAdapter {
    Context mContext;
    public ArrayList<Product> products;
    public static final int ACTIVITY_CREATE = 10;
    
    public ImageAdapter(Context c){ mContext = c; }

	@Override
	public int getCount() {
		if(this.products != null) {
			return this.products.size();
		}
		return 0;
	}
	
	@Override
	public Object getItem(int arg0) { return null; }

	@Override
	public long getItemId(int arg0) { return 0;	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
			final Product p = this.products.get(position);
			LayoutInflater li = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.shopview_item, null);
			TextView tv = (TextView) v.findViewById(R.id.icon_text);

			tv.setText(p.getTitle());
			Log.d(p.getImageUrl(), " test");
			ImageView iv = (ImageView) v.findViewById(R.id.icon_image);
			if (p.getImageUrl().equals("a")) {
				iv.setImageResource(R.drawable.bonen);
			} else if (p.getImageUrl().equals("b")) {
				iv.setImageResource(R.drawable.standaard);
			} else if (p.getImageUrl().equals("c")) {
				iv.setImageResource(R.drawable.special);
			} else if (p.getImageUrl().equals("d")) {
				iv.setImageResource(R.drawable.espresso);
			}
			
			final TextView txtCount = (TextView) v.findViewById(R.id.textCount);
			txtCount.setText(""+p.getCount());
			
			Button btnSub = (Button) v.findViewById(R.id.button_sub);
			btnSub.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					p.subtractCount();
					txtCount.setText(""+p.getCount());
				}
			});
			
			Button btnAdd = (Button) v.findViewById(R.id.button_add);
			btnAdd.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					p.addCount();
					txtCount.setText(""+p.getCount());
				}
			});

		return v;
	}
}
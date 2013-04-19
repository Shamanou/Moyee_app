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
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter implements OnItemClickListener{
    Context mContext;
    ArrayList<Product> products;
    public static final int ACTIVITY_CREATE = 10;
    
    public ImageAdapter(Context c){
        mContext = c;
    }


	@Override
	public int getCount() {
		if(this.products != null) {
			return this.products.size();
		}
		return 0;
	}

	
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
		
	}

	@Override
	 public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView==null){
         LayoutInflater li = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
         v = li.inflate(R.layout.koffieshopview, null);
         TextView tv = (TextView)v.findViewById(R.id.icon_text);

         tv.setText(this.products.get(position).getTitle());
         Log.d(this.products.get(position).getImageUrl(), " test");
         ImageView iv = (ImageView)v.findViewById(R.id.icon_image);
         if(this.products.get(position).getImageUrl().equals("a")){
	         iv.setImageResource(R.drawable.bonen);
	         }
	         else if(this.products.get(position).getImageUrl().equals("b")){
	             iv.setImageResource(R.drawable.standaard);
	             }
	         else if(this.products.get(position).getImageUrl().equals("c")){
	             iv.setImageResource(R.drawable.special);
	             }
	         else if(this.products.get(position).getImageUrl().equals("d")){
	             iv.setImageResource(R.drawable.espresso);
	          }
         
        }
        else
        {
        	v = convertView;
        }
		return v;
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		
	}




	

}
package hsl.groep5.moyee;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter implements OnClickListener{
    Context mContext;
    JSONArray dataArray;
    public static final int ACTIVITY_CREATE = 10;
    
    public ImageAdapter(Context c){
        mContext = c;
    }


	@Override
	public int getCount() {
		if(this.dataArray != null) {
			return this.dataArray.length();
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
	
	public void setJSONArray(JSONArray array) {
		this.dataArray = array;
		
	}

	@Override
	 public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView==null){
         LayoutInflater li = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
         v = li.inflate(R.layout.koffieshopview, null);
         TextView tv = (TextView)v.findViewById(R.id.icon_text);
         try {
			tv.setText(this.dataArray.getJSONObject(position).getString("title"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         ImageView iv = (ImageView)v.findViewById(R.id.icon_image);
         iv.setImageResource(R.drawable.bonen);
         v.setOnClickListener(this);
        }
        else
        {
        	v = convertView;
        }
		return v;
	}


	@Override
	public void onClick(View v) {
		v.setBackgroundColor(Color.GRAY);
		
	}
	

}

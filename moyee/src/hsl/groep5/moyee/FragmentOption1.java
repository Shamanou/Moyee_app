package hsl.groep5.moyee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class FragmentOption1 extends Fragment implements OnClickListener{
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		View rootView = inflater.inflate(R.layout.fragmentoption1,container, false);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this.getActivity().getApplicationContext(), MapsActivity.class);
        startActivity(intent);
	}
}
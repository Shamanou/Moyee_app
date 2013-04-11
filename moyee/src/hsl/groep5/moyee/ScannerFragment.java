package hsl.groep5.moyee;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD:moyee/src/hsl/groep5/moyee/FragmentOption3.java
public class FragmentOption3 extends SherlockFragment{
=======
public class ScannerFragment extends Fragment{
>>>>>>> origin/main:moyee/src/hsl/groep5/moyee/ScannerFragment.java
	public static final String ARG_SECTION_NUMBER = "section_number";	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption3 onCreateView()");
		View rootView = inflater.inflate(R.layout.scanner_fragmentoption, null);		
		return rootView;
	}
}
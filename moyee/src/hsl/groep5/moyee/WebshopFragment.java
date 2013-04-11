package hsl.groep5.moyee;

<<<<<<< HEAD
import com.google.android.gms.maps.SupportMapFragment;

=======
>>>>>>> origin/main
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
public class WebshopFragment extends SupportMapFragment implements HttpAPIResult {
=======
public class WebshopFragment extends Fragment{
>>>>>>> origin/main
	public static final String ARG_SECTION_NUMBER = "section_number";	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption2 onCreateView()");
<<<<<<< HEAD
		View rootView = inflater.inflate(R.layout.fragmentoption2, null);
		new HttpAPI(this).execute("http://mike.k0k.nl/test.php?id=123");
=======
		View rootView = inflater.inflate(R.layout.webshop_fragmentoption, null);
>>>>>>> origin/main
		return rootView;
	}

	@Override
	public void onHttpResult(String result, int id) {
		// TODO Auto-generated method stub
	}
}

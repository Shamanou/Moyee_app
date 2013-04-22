package hsl.groep5.moyee;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

/**
* @title Welkom Fragment Scherm Moyee Applicatie
* @author Robbert van der Hulst
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

public class FragmentWelcome extends SherlockFragment{
	public static final String ARG_SECTION_NUMBER = "section_number";	

	/**
	* Hier wordt er een scherm aangemaakt met de layout met het informatie scherm. 
	* Ook de font van Moyee wordt ingeladen.
	*/

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentWelcome onCreateView()");
		View rootView = inflater.inflate(R.layout.welcome_screen, null);		
	    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/delicious-roman-webfont.ttf");  
		return rootView;
	
	}
}

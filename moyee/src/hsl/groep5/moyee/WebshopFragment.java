package hsl.groep5.moyee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.android.gms.maps.SupportMapFragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WebshopFragment extends SupportMapFragment {
	public static final String ARG_SECTION_NUMBER = "section_number";	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("CHECK", "FragmentOption2 onCreateView()");
		View rootView = inflater.inflate(R.layout.fragmentoption2, null);
		MoyeeHttpAPI.getShopItems("http://mike.k0k.nl/test.php?id=123");
		return rootView;
	}
	
	public static void onResultShopItems(String result) {
		
		Log.d("HTTP", result);
	}
}
package hsl.groep5.moyee;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

/**
* @title Hoofdscherm Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

public class MainActivity extends SherlockFragmentActivity {
	PagerAdapter mPagerAdapter;
	ViewPager mViewPager;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ArrayList<String> titles = new ArrayList<String>();
	MapsFragment gmaps = new MapsFragment();
	WebshopFragment webshop = new WebshopFragment();
	FragmentWelcome fragmentWelcome = new FragmentWelcome();
	CoffeeFragment coffeeFragment = new CoffeeFragment();
	ActionBar actionbar;
	ArrayList<Drawable> icons = new ArrayList<Drawable>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SharedPreferences settings = this.getSharedPreferences("settings", 0);
		String loc = settings.getString("locale", "en");
		this.setLocale(loc);
		
		Log.d("CHECK", "MainActivity onCreate()");
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		
		mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles);
		
		titles.add(getResources().getString(R.string.tab_maps));
		titles.add(getResources().getString(R.string.tab_home));
		titles.add(getResources().getString(R.string.tab_shop));
		titles.add(getResources().getString(R.string.tab_scanner));
		
		icons.add(getResources().getDrawable(R.drawable.map));
		icons.add(getResources().getDrawable(R.drawable.about));
		icons.add(getResources().getDrawable(R.drawable.marker));
		
		fragments.add(gmaps);
		fragments.add(fragmentWelcome);
		fragments.add(webshop);
		fragments.add(coffeeFragment);
		
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter); 
		mViewPager.setCurrentItem(2);
		
		actionbar = getSupportActionBar();
		
		String name = settings.getString("name", "" );
		String email = settings.getString("email", "" );
		if(name.equals("") || email.equals("")) {
			showLogin();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getSupportMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.translate:
	        	this.showLanguage();
	            return true;
	        case R.id.userdata:
	            this.showLogin();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	/**
	* Er wordt een dialog boven de huidige weergave aangemaakt met de layout van de login.xml. RvdH
	*/
	
	public void showLogin () {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle(getResources().getString(R.string.user_dialog_title));
        dialog.setCancelable(false);
        
        /**
    	* De gegevens van de gebruiker worden opgeslagen in het bestandje settings. De gegevens worden opgeslagen in 
    	* een string. RvdH
    	*/
        
        SharedPreferences settings = getSharedPreferences("settings", 0);
		String name = settings.getString("name", "" );
		String email = settings.getString("email", "" );
		
		EditText txtName = (EditText) dialog.findViewById(R.id.username);
		txtName.setText(name);
		
		TextView txtEmail = (TextView) dialog.findViewById(R.id.email);
		txtEmail.setText(email);
        
		 /**
    	* Er wordt een knop aangemaakt waarmee de gebruiker zijn gegevens op kan slaan. RvdH
    	*/
		
        Button btnSave = (Button) dialog.findViewById(R.id.save);
        btnSave.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
	        	SharedPreferences settings = getSharedPreferences("settings", 0);
	        	Editor edit = settings.edit();
	        	EditText txtName = (EditText) dialog.findViewById(R.id.username);
	        	edit.putString("name", txtName.getText().toString());
	        	EditText txtEmail = (EditText) dialog.findViewById(R.id.email);
	        	edit.putString("email", txtEmail.getText().toString());
	        	edit.commit();
	        	dialog.dismiss();
            }
        });
        /**
    	* Er wordt een knop aangemaakt waarmee de gebruiker het login scherm kan overslaan. RvdH
    	*/
		
        
        Button btnSkip = (Button) dialog.findViewById(R.id.skip);
        btnSkip.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
	        	dialog.dismiss();
            }
        });
        
        /**
    	* Het dialoog wordt getoont. RvdH
    	*/
        
        dialog.show();
	}
	
	public void showLanguage() {
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.language);
        dialog.setTitle(getResources().getString(R.string.translate));

        OnClickListener clickListener = new OnClickListener() {
        	@Override
            public void onClick(View v) {
        		SharedPreferences settings = getSharedPreferences("settings", 0);
        		
        		String loc = settings.getString("locale", "en");
        		
        		switch(v.getId()) {
        			case R.id.lang_button_en:
        				loc = "en";
        				break;
        			case R.id.lang_button_nl:
        				loc = "nl";
        				break;
        		}
        		
	        	Editor edit = settings.edit();
	        	edit.putString("locale", loc);
	        	edit.commit();
	        	
	        	MainActivity.this.setLocale(loc);
	        	
	        	dialog.dismiss();
            }
        };
        
        Button btn = (Button) dialog.findViewById(R.id.lang_button_en);
        btn.setOnClickListener(clickListener);
        
        btn = (Button) dialog.findViewById(R.id.lang_button_nl);
        btn.setOnClickListener(clickListener);
        
        dialog.show();
	}
	
	public void setLocale(String loc) {
		Locale locale = new Locale(loc);
		Locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;
		getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
	}
}

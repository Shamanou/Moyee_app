package hsl.groep5.moyee;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
		Log.d("CHECK", "MainActivity onCreate()");
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		
		mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles);
		
		titles.add(getResources().getString(R.string.welcome_option1));
		titles.add(getResources().getString(R.string.welcome_option));
		titles.add(getResources().getString(R.string.welcome_option2));
		titles.add(getResources().getString(R.string.welcome_option3));
		
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
		
		SharedPreferences settings = this.getSharedPreferences("settings", 0);
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
	            return true;
	        case R.id.userdata:
	            this.showLogin();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void showLogin () {
		//set up dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Inloggen");
        dialog.setCancelable(false);
        
        
        SharedPreferences settings = getSharedPreferences("settings", 0);
		String name = settings.getString("name", "" );
		String email = settings.getString("email", "" );
		
		EditText txtName = (EditText) dialog.findViewById(R.id.username);
		txtName.setText(name);
		
		TextView txtEmail = (TextView) dialog.findViewById(R.id.email);
		txtEmail.setText(email);
        
        //set up button
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
        
        Button btnSkip = (Button) dialog.findViewById(R.id.skip);
        btnSkip.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
	        	dialog.dismiss();
            }
        });
        //now that the dialog is set up, it's time to show it    
        dialog.show();
	}
}

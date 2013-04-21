package hsl.groep5.moyee;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/**
* @title Login Scherm Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

public class Login {
	
	public class MainActivity extends Activity
	{
	
	 private String gebruikersnaam;
	 private String emailadres;
	 private CheckBox checkBox1;
	 
	 //deze methode wordt elke keer aangeroepen als de applicatie opstart
	 @Override
	 protected void onCreate(Bundle savedInstanceState)
	 {
	  super.onCreate(savedInstanceState);
	  
	  setContentView(R.layout.login);

	  //stel alle UI interfaces in met opgeslagen preferences (mochten die er zijn)
	  
	  //laad de preferences binnen
	  SharedPreferences settings = this.getSharedPreferences("settings", 0);
	  this.gebruikersnaam = settings.getString("naam", " " );
	  this.emailadres = settings.getString("naam", " " );
	  


	  //stel de userinterface op met waarden uit de preferences
	  setupUserinterface();
	 }
	 
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu)
	 {
	  // Inflate the menu; this adds items to the action bar if it is present.
	  getMenuInflater().inflate(R.menu.main, menu);
	  return true;
	 }
	 
	 public void sluitApp( View view )
	 {
	  this.finish();
	 }
	 
	 public void naarHoofdscherm( View view )
	 {
	  //haal gegevens naam en kleur op uit het optiescherm
	  
		
		 
	  EditText naamEditTekst = (EditText) this.findViewById(R.id.username);
	  this.gebruikersnaam = naamEditTekst.getText().toString();
	  
	  EditText naamEditTekst2 = (EditText) this.findViewById(R.id.email);
	  this.emailadres = naamEditTekst.getText().toString();
	  
	
	  
	  
	  //sla gegevens op in de preferences
	  if (checkBox1.isChecked()) 
	  {
	  SharedPreferences settings = this.getSharedPreferences("settings", 0);
	  Editor editor = settings.edit();
	  editor.putString("username", gebruikersnaam);
	  editor.putString("email", emailadres);
	  editor.apply();
	  }
	  
	  else {
		
		 }


	  //stel userinterface opnieuw in met nieuwe waarden
	  setContentView( R.layout.activity_main );
	  setupUserinterface();
	 }






	private void setupUserinterface() {
		// TODO Auto-generated method stub
		
	}
	 
	 
	}


}

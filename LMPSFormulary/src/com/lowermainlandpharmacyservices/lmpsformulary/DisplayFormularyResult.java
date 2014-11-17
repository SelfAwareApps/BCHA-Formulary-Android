package com.lowermainlandpharmacyservices.lmpsformulary;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayFormularyResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_formulary_result);
		
		
		
		 // Get the message from the intent
	    Intent intent = getIntent();
	    ArrayList<String> input = intent.getStringArrayListExtra(MainActivity.EXTRA_STRENGTHS);
	    String test = "Strengths:";
	    for(String s: input) {
	    	 test += "\n" + "\t" + s;
	    }

	    // Create the text view
	    TextView textView = (TextView) findViewById(R.id.formulary_result_view);
	    textView.setText(test);
	    textView.setTextSize(20);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_formulary_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

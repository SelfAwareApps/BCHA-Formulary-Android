package com.lowermainlandpharmacyservices.lmpsformulary;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayOtherResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_other_result);
		getActionBar().hide();
		
		Intent intent = getIntent();
		String searchInput = intent.getStringExtra(MainActivity.EXTRA_INFO);
		
		TextView topTextView = (TextView) findViewById(R.id.notfound);
	    topTextView.setTypeface(null, Typeface.BOLD);
	    
	    TextView inputView = (TextView) findViewById(R.id.drugnotfound);
	    inputView.setText(searchInput + " was not found.");
	    inputView.setTypeface(null, Typeface.BOLD);
		
	    TextView descriptionView = (TextView) findViewById(R.id.description);
	    descriptionView.setText("If you think this drug should be on the formulary, please check your spelling and try again." +  "\n" + "\n"+ "This drug may also be a non-formulary drug.");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_other_result, menu);
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
package com.lowermainlandpharmacyservices.lmpsformulary;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayFormularyResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_formulary_result);
		getActionBar().hide();
		Intent intent = getIntent();
		String type = intent.getStringExtra(Utilities.EXTRA_TYPE);
		String name = "";
		ArrayList<String> otherNames;
		String otherNamesAsString = "";
		String genericbrandtitle = "";

		if (type.equals("Generic")) {
			genericbrandtitle = "Brand Names:";
			name = intent.getStringExtra(Utilities.EXTRA_GENERICNAME);
			otherNames = intent
					.getStringArrayListExtra(Utilities.EXTRA_BRANDNAME);
			System.out.println("brand names total = " + otherNames.size());
			System.out.println("gothere");

			for (String s : otherNames) {
				otherNamesAsString += "\t" + "\t" + "- " + s + "\n";
			}

		} else if (type.equals("Brand")) {
			genericbrandtitle = "Generic Names:";
			name = intent.getStringExtra(Utilities.EXTRA_BRANDNAME);
			otherNames = intent
					.getStringArrayListExtra(Utilities.EXTRA_GENERICNAME);

			for (String s : otherNames) {
				otherNamesAsString += "\t" + "\t" + "- " + s + "\n";
			}

		}
		// Search Name
		TextView genericNameTextView = (TextView) findViewById(R.id.formulary_drug_genericname);
		genericNameTextView.setText(name);
		genericNameTextView.setTypeface(null, Typeface.BOLD);

		// Other Names
		TextView nameHeaderTextView = (TextView) findViewById(R.id.generic_or_brand);
		nameHeaderTextView.setText(genericbrandtitle);

		TextView brandNameTextView = (TextView) findViewById(R.id.formulary_brandnames);
		brandNameTextView.setText(otherNamesAsString);
		brandNameTextView.setTextSize(20);

		// Create strength text view
		ArrayList<String> input = intent
				.getStringArrayListExtra(Utilities.EXTRA_STRENGTHS);
		String strengths = "";
		for (String s : input) {
			strengths += "\t" + "\t" + "- " + s + "\n";
		}

		TextView strengthTextView = (TextView) findViewById(R.id.formulary_strength);
		strengthTextView.setText(strengths);
		strengthTextView.setTextSize(20);
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

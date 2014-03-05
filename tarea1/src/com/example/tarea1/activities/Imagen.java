package com.example.tarea1.activities;

import com.example.tarea1.R;
import com.example.tarea1.R.drawable;
import com.example.tarea1.R.id;
import com.example.tarea1.R.layout;
import com.example.tarea1.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class Imagen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.imagen, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case R.id.action_share:
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.setType("image/png");
					intent.putExtra(Intent.EXTRA_STREAM, R.drawable.games2);
					startActivity(Intent.createChooser(intent, "Share Image"));
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		
	}

}

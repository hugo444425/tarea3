package com.example.tarea1.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.tarea1.R;
import com.example.tarea1.R.id;
import com.example.tarea1.R.layout;
import com.example.tarea1.R.menu;
import com.example.tarea1.fragments.ListFragment;
import com.example.tarea1.fragments.MapFragment;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity implements  TabListener {
	
	Fragment[] fragments = new Fragment[] {new ListFragment(),
									       new MapFragment()};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fragments[0].setHasOptionsMenu(true);
		
		/*Button btnimagen = (Button)findViewById(R.id.imagenbtn);
        
      
        btnimagen.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(getApplicationContext(),Imagen.class);
                        startActivity(i);
                    }
                });*/
        
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        actionBar.addTab(
                actionBar.newTab()
                        .setText(getString(R.string.title_fragment_list))
                        .setTabListener(this));
        
        actionBar.addTab(
                actionBar.newTab()
                        .setText(getString(R.string.title_fragment_map))
                        .setTabListener(this));
        
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
        	.add(R.id.mainContent, fragments[0])
        	.add(R.id.mainContent, fragments[1])
        	.commit();
        
	}
	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		setContent(tab.getPosition());
		
	}
	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setContent(int tab) {		
		Fragment toHide = null;
		Fragment toShow = null;
		switch (tab) {
			case 0:
				toHide = fragments[1];
				toShow = fragments[0];
				break;
			case 1:
				toHide = fragments[0];
				toShow = fragments[1];
				break;
		}

		FragmentManager manager = getSupportFragmentManager();

		manager.beginTransaction()
				.hide(toHide)
				.show(toShow)
				.commit();
	}
}

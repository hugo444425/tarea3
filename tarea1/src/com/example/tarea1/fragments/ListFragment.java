package com.example.tarea1.fragments;

import java.util.ArrayList;
import java.util.List;

import com.example.tarea1.R;
import com.example.tarea1.activities.Imagen;
import com.example.tarea1.activities.ShowDescription;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListFragment extends Fragment implements OnItemClickListener {

	
	List<String> tiendas = new ArrayList<String>();
	public final static String TIENDA = "tienda";
	ListView list;
	Button btnimagen;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		tiendas.add("Tienda de Lego");
		tiendas.add("Tienda de Libros");
		tiendas.add("Tienda de Zapatos");
		tiendas.add("Tienda de Ropa");
		tiendas.add("Tienda de Vinos");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tiendas);        
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        
        registerForContextMenu(list);
      
       /* btnimagen.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(getActivity(),Imagen.class);
                        startActivity(i);
                    }
                });
 */
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_list, container, false);
		list = (ListView)view.findViewById(R.id.listView);
		//btnimagen = (Button)view.findViewById(R.id.imagenbtn);
		return list;
	}


	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
    }
	
/*	public void enviarmensaje(View view) 
	{
	    Intent intent = new Intent(getApplicationContext(), Imagen.class);
	    startActivity(intent);
	}*/

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
        try {
            Intent intent = new Intent(getActivity().getApplicationContext(), ShowDescription.class);
            intent.putExtra(ShowDescription.QUERY, Integer.toString(arg2));
            startActivity(intent);
        } catch (ClassCastException e) {
            Log.e("TAG","Clase incorrecta " + Log.getStackTraceString(e));        
        }  
	}


}

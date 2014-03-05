package com.example.tarea1.activities;

import com.example.tarea1.R;
import com.example.tarea1.R.id;
import com.example.tarea1.R.layout;
import com.example.tarea1.R.menu;
import com.example.tarea1.R.string;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowDescription extends Activity {
	public final static String QUERY = "query";
	private  String queryText = "query";
	String numerito = "0";
	//@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_description);
		
		Intent intent = getIntent();
	    queryText = intent.getStringExtra(QUERY);
	    if (queryText != null) {
            TextView txtMsg = (TextView)findViewById(R.id.txtMsg);
            if(queryText.equals("0")){
            	txtMsg.setText("Tienda de legos \n14 calle 6-24 zona 4 \n55505055 \n" +
            			"Lunes a domingo 7:00am - 2:00pm \n" +
            			"www.tiendadelegos.com \n" +
            			"tiendalegos@lego.com ");
            	numerito = "55505055";
            	 Button llamar = (Button) findViewById(R.id.button1);     

            	 
            	 
            	 
                 llamar.setOnClickListener(new View.OnClickListener() {
                     public void onClick(View v) {
                         // TODO Auto-generated method stub
                    	Intent callIntent = new Intent(Intent.ACTION_CALL);
                 		callIntent.setData(Uri.parse("tel:" + numerito));
                 		startActivity(callIntent);
                     }
                 });
            	
            } else  if(queryText.equals("1")){
            	txtMsg.setText("Tienda de Libros \nZona10 Oakland Mall local 37 \n22688997 \n" +
            			"Lunes a domingo 8:00am - 9:00pm \n" +
            			"www.tiendadelibros.com \n" +
            			"tiendalibros@libros.com ");
            	numerito = "22688997";
            	 Button llamar = (Button) findViewById(R.id.button1);     


                 llamar.setOnClickListener(new View.OnClickListener() {
                     public void onClick(View v) {
                         // TODO Auto-generated method stub
                    	Intent callIntent = new Intent(Intent.ACTION_CALL);
                 		callIntent.setData(Uri.parse("tel:" + numerito));
                 		startActivity(callIntent);
                     }
                 });
            	
            } else  if(queryText.equals("2")){
            	txtMsg.setText("Tienda de Zapatos \nCalzada Roosevelt Galerias Miraflores local 121 \n22449887 \n" +
            			"Lunes a domingo 8:00am - 9:00pm \n" +
            			"www.tiendadezapatos.com \n" +
            			"tiendazapatos@zapatos.com ");
            	numerito = "22449887";
            	 Button llamar = (Button) findViewById(R.id.button1);     


                 llamar.setOnClickListener(new View.OnClickListener() {
                     public void onClick(View v) {
                         // TODO Auto-generated method stub
                    	Intent callIntent = new Intent(Intent.ACTION_CALL);
                 		callIntent.setData(Uri.parse("tel:" + numerito));
                 		startActivity(callIntent);
                     }
                 });
            	
            } else  if(queryText.equals("3")){
            	txtMsg.setText("Tienda de Ropa \n13 Calle 8-33 Zona 12 \n24763396 \n" +
            			"Lunes a domingo 7:00am - 5:00pm \n" +
            			"www.tiendaderopa.com \n" +
            			"tiendaropa@ropa.com ");
            	numerito = "24763396";
            	 Button llamar = (Button) findViewById(R.id.button1);     


                 llamar.setOnClickListener(new View.OnClickListener() {
                     public void onClick(View v) {
                         // TODO Auto-generated method stub
                    	Intent callIntent = new Intent(Intent.ACTION_CALL);
                 		callIntent.setData(Uri.parse("tel:" + numerito));
                 		startActivity(callIntent);
                     }
                 });
            	
            }else  if(queryText.equals("4")){
            	txtMsg.setText("Tienda de Vinos \nCentro Comercial El Faro Carretera el Salvador Local 101 \n66983343 \n" +
            			"Lunes a domingo 8:00am - 8:00pm \n" +
            			"www.tiendadevinos.com \n" +
            			"tiendavinos@vinos.com ");
            	numerito = "66983343";
            	 Button llamar = (Button) findViewById(R.id.button1);     


                 llamar.setOnClickListener(new View.OnClickListener() {
                     public void onClick(View v) {
                         // TODO Auto-generated method stub
                    	Intent callIntent = new Intent(Intent.ACTION_CALL);
                 		callIntent.setData(Uri.parse("tel:" + numerito));
                 		startActivity(callIntent);
                     }
                 });
            	
            }else  if(queryText.equals("5")){
            	txtMsg.setText("Tienda de Vinos \nCentro Comercial El Faro Carretera el Salvador Local 101 \n66983343 \n" +
            			"Lunes a domingo 8:00am - 8:00pm \n" +
            			"www.tiendadevinos.com \n" +
            			"tiendavinos@vinos.com ");
            	numerito = "66983343";
            	 Button llamar = (Button) findViewById(R.id.button1);     


                 llamar.setOnClickListener(new View.OnClickListener() {
                     public void onClick(View v) {
                         // TODO Auto-generated method stub
                    	Intent callIntent = new Intent(Intent.ACTION_CALL);
                 		callIntent.setData(Uri.parse("tel:" + numerito));
                 		startActivity(callIntent);
                     }
                 });
            	
            } else{
            	txtMsg.setText(queryText + queryText.toString());
            }
            
            Linkify.addLinks(txtMsg, Linkify.ALL);	
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_description, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case R.id.action_share:
				if(!queryText.equals("")){
					String msg = getString(R.string.msg_share, queryText);
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.putExtra(Intent.EXTRA_TEXT, msg);
					intent.setType("text/plain");
					startActivity(Intent.createChooser(intent, getString(R.string.action_share)));
					
				}
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		
	}

}

package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends Activity {
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener( ) ;
	int counter = 0;
		
	final private int[ ] ButtonIds = {
				R.id.north,
				R.id.west,
				R.id.east,
				R.id.south,
				R.id.secondary
		};
	
	protected class ButtonClickListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v) {
			if ( v instanceof Button )
			{
				if ( v.getId() == R.id.north )
				{
					  EditText input = ( EditText )findViewById( R.id.input );
					  String input_text = input.getText().toString();
					  if ( input_text.length() == 0 )
					  {
						  	input_text = input_text + "North";
					  }
					  else
					  {
						  input_text = input_text + ", North";
					  }
					  input.setText( input_text );
				}
				if ( v.getId() == R.id.west )
				{
					  EditText input = ( EditText )findViewById( R.id.input );
					  String input_text = input.getText().toString();
					  if ( input_text.length() == 0 )
					  {
						  	input_text = input_text + "West";
					  }
					  else
					  {
						  input_text = input_text + ", West";
					  }
					  input.setText( input_text );
				}
				if ( v.getId() == R.id.east )
				{
					  EditText input = ( EditText )findViewById( R.id.input );
					  String input_text = input.getText().toString();
					  if ( input_text.length() == 0 )
					  {
						  	input_text = input_text + "East";
					  }
					  else
					  {
						  input_text = input_text + ", East";
					  }
					  input.setText( input_text );
				}
				if ( v.getId() == R.id.south )
				{
					  EditText input = ( EditText )findViewById( R.id.input );
					  String input_text = input.getText().toString();
					  if ( input_text.length() == 0 )
					  {
						  	input_text = input_text + "South";
					  }
					  else
					  {
						  input_text = input_text + ", South";
					  }
					  input.setText( input_text );
				}
				if ( v.getId() == R.id.secondary )
				{
					  EditText input = ( EditText )findViewById( R.id.input );
					  Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicaltest01var05.intent.action.PracticalTest01Var05MainActivity");
					  intent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01var05.COUNTER", "" + counter);
					  intent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01var05.INPUT",input.getText().toString());
					  startActivityForResult(intent, 1);
				}
			}
		}
	}

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_practical_test01_va05_main);
		 for ( int i = 0 ; i < ButtonIds.length ; i++ ) {
	        	Button button = ( Button ) findViewById ( ButtonIds[ i ] ) ;
	        	button.setOnClickListener( buttonClickListener ) ;
	        }
	   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
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
	
	   @Override
	    protected void onSaveInstanceState(Bundle savedInstanceState) {
	    	// apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
	    	super.onSaveInstanceState(savedInstanceState);
	    	EditText input = ( EditText )findViewById( R.id.input );
	    	savedInstanceState.putString("input", input.getText().toString());
	    	savedInstanceState.putString("counter", "" + counter);
	    	
	    }
	    
	    @Override
	    protected void onRestoreInstanceState(Bundle savedInstanceState) {
	    	// apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
	    	super.onRestoreInstanceState(savedInstanceState);
	    	EditText input = ( EditText )findViewById( R.id.input );
	    	if ( savedInstanceState.containsKey( "input" ) )
	    	{
	    		input.setText(savedInstanceState.getString("input"));
	    	}
	    	if ( savedInstanceState.containsKey( "counter" ) )
	    	{
	    		counter = Integer.parseInt(savedInstanceState.getString( "counter" ));
	    	}
	    }
	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    	if (requestCode == 1) {
	    		if ( resultCode == RESULT_OK )
	    		{
	    			counter++;
	    			EditText input = ( EditText )findViewById( R.id.input );
	    			input.setText("");
	    			
	    		}
	    	}
	    }
}

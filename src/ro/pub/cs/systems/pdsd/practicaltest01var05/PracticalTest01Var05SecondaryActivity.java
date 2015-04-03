package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var05SecondaryActivity extends Activity {

private ButtonClickListener buttonClickListener = new ButtonClickListener( ) ;
	
	final private int[ ] ButtonIds = {
			R.id.register,
			R.id.cancel,
	} ;
	
	protected class ButtonClickListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v) {
			if ( v instanceof Button )
			{
				if ( v.getId() == R.id.register )
				{
					  Intent intentToParent = new Intent();
					  intentToParent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01var05.ANSWER", "Register");
					  setResult(RESULT_OK, intentToParent);
					  finish();
				}
				if ( v.getId() == R.id.cancel )
				{
					  Intent intentToParent = new Intent();
					  intentToParent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01var05.ANSWER", "Cancel");
					  setResult(RESULT_CANCELED, intentToParent);
					  finish();
				}
			}
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
		Intent intentFromParent = getIntent();
		Bundle data = intentFromParent.getExtras();
		if ( data.containsKey( "ro.pub.cs.systems.pdsd.practicaltest01var05.COUNTER" ) )
		{
			EditText counter = ( EditText )findViewById( R.id.counter );
			counter.setText(data.getString("ro.pub.cs.systems.pdsd.practicaltest01var05.COUNTER"));
		}
		else
		{
			EditText counter = ( EditText )findViewById( R.id.counter );
			counter.setText("0");
		}
		if ( data.containsKey( "ro.pub.cs.systems.pdsd.practicaltest01var05.INPUT" ) )
		{
			EditText counter = ( EditText )findViewById( R.id.secondary_input );
			counter.setText(data.getString("ro.pub.cs.systems.pdsd.practicaltest01var05.INPUT"));
		}
        for ( int i = 0 ; i < ButtonIds.length ; i++ )
        {
        	Button button = ( Button ) findViewById ( ButtonIds[ i ] ) ;
        	button.setOnClickListener( buttonClickListener ) ;
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var05_secondary, menu);
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

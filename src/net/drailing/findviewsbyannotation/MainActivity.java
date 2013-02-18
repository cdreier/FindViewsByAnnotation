package net.drailing.findviewsbyannotation;

import net.drailing.findviewsbyannotation.support.FindViewsByAnnotations;
import net.drailing.findviewsbyannotation.support.InitWithId;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@InitWithId(R.id.testTextView)
	private TextView testTextView;
	@InitWithId(R.id.testEditText)
	private EditText testEditText;
	@InitWithId(R.id.testButton)
	private Button testButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//initialize all annotated views
		FindViewsByAnnotations.init(this);
		
		this.testTextView.setText("INIT WITH ANNOTATION");
		
		this.testButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MainActivity.this.testTextView.setText(MainActivity.this.testEditText.getText());
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

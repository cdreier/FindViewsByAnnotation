FindViewsByAnnotation
=====================

This is my first try with custom annotations, very simple to understand and does one helpful thing effectively: 
reducing the boilerplate initialization code in the onCreate method.

If you are looking for a more complex android framework, take a look at [roboguice](https://github.com/roboguice/roboguice/) or [AndroidAnnotations](http://androidannotations.org/)

Example
===

```java
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
}
```

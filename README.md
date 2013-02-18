FindViewsByAnnotation
=====================

This is my first try with custom annotations, very simple to understand and does one helpful thing effectively: 
reducing the boilerplate initialization code in the onCreate method.

I know the [roboguice](https://github.com/roboguice/roboguice/) injection framework, which has a lot more features.

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

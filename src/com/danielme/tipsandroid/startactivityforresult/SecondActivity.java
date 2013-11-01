package com.danielme.tipsandroid.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.danielme.tipsandroid.startactivityforresult.R;

/**
 * 
 * @author danielme.com
 * 
 */
public class SecondActivity extends Activity
{

	private EditText editText = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.child);
		editText = (EditText) findViewById(R.id.editText1);		
	}

	public void save(View button)
	{
		String text = editText.getText().toString();
		
		if (text.trim().length() == 0)
		{
			editText.setError(getText(R.string.error));
		}
		else
		{
			Intent intent = getIntent();
			intent.putExtra("text", text);
			setResult(RESULT_OK, intent);
			finish();
		}
	}

	public void cancel(View button)
	{
		setResult(RESULT_CANCELED, new Intent());
		finish();
	}

}
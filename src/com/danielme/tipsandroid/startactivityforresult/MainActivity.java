package com.danielme.tipsandroid.startactivityforresult;

import java.util.LinkedList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * 
 * @author danielme.com
 *
 */
public class MainActivity extends ListActivity
{
	
	private List<String> results = new LinkedList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setListAdapter(new ArrayAdapter<String>(this,R.layout.textview, results));

	}
	
	public void editText(View button)
	{
		Intent intent = new Intent(this, SecondActivity.class);
		startActivityForResult(intent, 2);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (RESULT_OK == resultCode)
		{
			results.add(data.getStringExtra("text"));
			((ArrayAdapter<String>) getListAdapter()).notifyDataSetChanged();
		}
		else
		{
			Toast.makeText(this, R.string.cancel, Toast.LENGTH_LONG).show();
		}
	}
}
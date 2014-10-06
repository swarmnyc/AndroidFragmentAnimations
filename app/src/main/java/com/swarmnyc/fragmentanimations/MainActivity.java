package com.swarmnyc.fragmentanimations;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
{

	private Button         m_showTopButton;
	private Button         m_showBothButton;
	private Button         m_hideAllButton;
	private TopFragment    m_topFragment;
	private BottomFragment m_bottomFragment;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );


		m_showTopButton = (Button) findViewById( R.id.btn_show_top );
		m_showBothButton = (Button) findViewById( R.id.btn_show_both );
		m_hideAllButton = (Button) findViewById( R.id.btn_hide_all );

		m_topFragment = (TopFragment) getSupportFragmentManager().findFragmentById( R.id.fragment_top );
		m_bottomFragment = (BottomFragment) getSupportFragmentManager().findFragmentById( R.id.fragment_bottom );

		getSupportFragmentManager().beginTransaction().hide( m_topFragment ).hide( m_bottomFragment ).commit();


		m_showTopButton.setOnClickListener(
			new View.OnClickListener()
			{
				@Override public void onClick( final View v )
				{


					getSupportFragmentManager().beginTransaction().setCustomAnimations(
						R.anim.abc_slide_in_top, R.anim.abc_slide_out_top
					).show( m_topFragment ).commit();
				}
			}
		);

		m_showBothButton.setOnClickListener(
			new View.OnClickListener()
			{
				@Override public void onClick( final View v )
				{

					getSupportFragmentManager().beginTransaction().setCustomAnimations(
						R.anim.abc_slide_in_top, R.anim.abc_slide_out_top
					).show( m_topFragment ).setCustomAnimations(
						R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom
					).show( m_bottomFragment ).commit();
				}
			}
		);

		m_hideAllButton.setOnClickListener(
			new View.OnClickListener()
			{
				@Override public void onClick( final View v )
				{

					getSupportFragmentManager().beginTransaction().setCustomAnimations(
						R.anim.abc_slide_in_top, R.anim.abc_slide_out_top
					).hide( m_topFragment ).setCustomAnimations(
						R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom
					).hide( m_bottomFragment ).commit();

				}
			}
		);


	}


	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate( R.menu.main, menu );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if ( id == R.id.action_settings )
		{
			return true;
		}
		return super.onOptionsItemSelected( item );
	}

}

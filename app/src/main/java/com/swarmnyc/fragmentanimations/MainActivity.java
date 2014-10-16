package com.swarmnyc.fragmentanimations;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
{

	private Button         m_showAnimtaionButton;
	private Button         m_showMultiAnimationsButton;
//	private Button         m_resetButtom;
	private TopFragment    m_topFragment;
	private BottomFragment m_bottomFragment;
	private Button         m_showTransitionButton;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );


		m_showTransitionButton = (Button) findViewById( R.id.btn_show_transition );
		m_showAnimtaionButton = (Button) findViewById( R.id.btn_show_animation );
		m_showMultiAnimationsButton = (Button) findViewById( R.id.btn_start_multiple_animations );
//		m_resetButtom = (Button) findViewById( R.id.btn_reset );

		m_topFragment = (TopFragment) getSupportFragmentManager().findFragmentById( R.id.fragment_top );
		m_bottomFragment = (BottomFragment) getSupportFragmentManager().findFragmentById( R.id.fragment_bottom );

		getSupportFragmentManager().beginTransaction().hide( m_topFragment ).hide( m_bottomFragment ).commit();

//		m_resetButtom.setSelected( true );

		m_showTransitionButton.setOnClickListener(
			new View.OnClickListener()
			{
				@Override public void onClick( final View v )
				{
					getSupportFragmentManager().beginTransaction().setTransition(
						FragmentTransaction.TRANSIT_FRAGMENT_OPEN
					).add( R.id.container, new FullScreenFragment() ).addToBackStack( "transition" ).commit();
				}
			}
		);


		m_showAnimtaionButton.setOnClickListener(
			new View.OnClickListener()
			{
				@Override public void onClick( final View v )
				{


					getSupportFragmentManager().beginTransaction().setCustomAnimations(
						R.anim.slide_in_left, 0, 0, R.anim.slide_out_left
					).add( R.id.container, new FullScreenFragment() ).addToBackStack( "animation" ).commit();
				}
			}
		);

		m_showMultiAnimationsButton.setOnClickListener(
			new View.OnClickListener()
			{
				@Override public void onClick( final View v )
				{
					if (m_topFragment.isHidden())
					{
						m_showMultiAnimationsButton.setSelected( true );
						getSupportFragmentManager().beginTransaction().setCustomAnimations(
							R.anim.abc_slide_in_top, R.anim.abc_slide_out_top
						).show( m_topFragment ).setCustomAnimations(
							R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom
						).show( m_bottomFragment ).commit();
					}
					else
					{
						m_showMultiAnimationsButton.setSelected( false );
						getSupportFragmentManager().beginTransaction().setCustomAnimations(
							R.anim.abc_slide_in_top, R.anim.abc_slide_out_top
						).hide( m_topFragment ).setCustomAnimations(
							R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom
						).hide( m_bottomFragment ).commit();
					}
				}
			}
		);

//		m_resetButtom.setOnClickListener(
//			new View.OnClickListener()
//			{
//				@Override public void onClick( final View v )
//				{
//
//
//					getSupportFragmentManager().beginTransaction().setCustomAnimations(
//						R.anim.abc_slide_in_top, R.anim.abc_slide_out_top
//					).hide( m_topFragment ).setCustomAnimations(
//						R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom
//					).hide( m_bottomFragment ).commit();
//
//				}
//			}
//		);


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

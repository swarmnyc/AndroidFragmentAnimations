package com.swarmnyc.fragmentanimations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by somya on 10/15/14.
 */
public class FullScreenFragment extends Fragment
{

	public FullScreenFragment()
	{
	}

	@Override
	public View onCreateView(
		LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
	)
	{
		View rootView = inflater.inflate( R.layout.fragment_full_screen, container, false );
		return rootView;
	}

	@Override public void onViewCreated( final View view, final Bundle savedInstanceState )
	{
		super.onViewCreated( view, savedInstanceState );

		view.findViewById( R.id.btn_close ).setOnClickListener(
			new View.OnClickListener()
			{
				@Override public void onClick( final View v )
				{
					getFragmentManager().popBackStack();
				}
			}
		);
	}
}
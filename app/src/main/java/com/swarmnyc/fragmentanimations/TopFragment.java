package com.swarmnyc.fragmentanimations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public
class TopFragment extends Fragment
{

	public
	TopFragment()
	{
	}

	@Override
	public
	View onCreateView(
		LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
	)
	{
		View rootView = inflater.inflate( R.layout.fragment_top, container, false );
		return rootView;
	}
}

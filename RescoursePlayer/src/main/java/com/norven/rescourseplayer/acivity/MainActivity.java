package com.norven.rescourseplayer.acivity;

import java.util.ArrayList;
import java.util.List;

import com.norven.rescourseplayer.adapter.MyFragmentPagerAdapter;
import com.norven.rescourseplayer.customviews.MyViewPaper;
import com.norven.rescourseplayer.fragment.SourcesFragment;

import norven.rescourseplayer.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		List<Fragment> fragments = new ArrayList<Fragment>();
		SourcesFragment sourcesFragment = new SourcesFragment();
		fragments.add(sourcesFragment);
		MyFragmentPagerAdapter viewPaperAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
		MyViewPaper viewPager = (MyViewPaper) findViewById(R.id.source_viewPager);
		viewPager.setAdapter(viewPaperAdapter);
		viewPager.setCurrentItem(0);
	}
}

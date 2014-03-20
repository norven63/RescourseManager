package com.norven.rescourseplayer.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.norven.rescourseplayer.adapter.SimpleFileListAdapter;

import norven.rescourseplayer.R;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class SourcesFragment extends Fragment {
	private final List<File> fileList = new ArrayList<File>();
	private ListView fileListView;
	private SimpleFileListAdapter simpleFileListAdapter;

	private void initFiles(File file) {
		if (null == file || !file.exists()) {
			assert false : "入参不合法！";
			return;
		}

		fileList.clear();

		for (File childFile : file.listFiles()) {
			fileList.add(childFile);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_sourceslist, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			initFiles(Environment.getExternalStorageDirectory());
		} else {
			Toast.makeText(getActivity(), "请插入SD卡。", Toast.LENGTH_SHORT).show();
		}

		simpleFileListAdapter = new SimpleFileListAdapter(fileList, getActivity());
		fileListView = (ListView) getView().findViewById(R.id.file_list_listView);
		fileListView.setAdapter(simpleFileListAdapter);
	}
}

package norven.rescourseplayer.acivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import norven.rescourseplayer.R;
import norven.rescourseplayer.adapter.SimpleFileListAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final List<File> fileList = new ArrayList<File>();
	private ListView fileListView;
	private SimpleFileListAdapter simpleFileListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			initFiles(Environment.getExternalStorageDirectory());
		} else {
			Toast.makeText(this, "请插入SD卡。", Toast.LENGTH_SHORT).show();
		}

		simpleFileListAdapter = new SimpleFileListAdapter(fileList, this);
		fileListView = (ListView) findViewById(R.id.file_list_listView);
		fileListView.setAdapter(simpleFileListAdapter);
	}

	private void initFiles(File file) {
		if (null == file || !file.exists()) {
			assert false : "入参不合法!";
			return;
		}

		fileList.clear();

		for (File childFile : file.listFiles()) {
			fileList.add(childFile);
		}
	}
}

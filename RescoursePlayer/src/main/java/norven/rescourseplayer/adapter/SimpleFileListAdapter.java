package norven.rescourseplayer.adapter;

import java.io.File;
import java.util.List;

import norven.rescourseplayer.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleFileListAdapter extends BaseAdapter {
	private final List<File> rescourse;
	private final Activity activity;

	public SimpleFileListAdapter(List<File> rescourse, Activity activity) {
		super();
		this.rescourse = rescourse;
		this.activity = activity;
	}

	private final static class ViewHolder {
		ImageView imageView;
		TextView textView;
	}

	@Override
	public int getCount() {
		return rescourse == null ? 0 : rescourse.size();
	}

	@Override
	public File getItem(int position) {
		return rescourse == null ? null : rescourse.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		File file = getItem(position);
		View row = convertView;
		if (null == row) {
			row = activity.getLayoutInflater().inflate(R.layout.myview_filelist_item, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) row.findViewById(R.id.file_icn_imageView);
			viewHolder.textView = (TextView) row.findViewById(R.id.file_name_textView);
			row.setTag(viewHolder);
		}

		ViewHolder holder = (ViewHolder) row.getTag();

		holder.imageView.setBackgroundResource(R.drawable.ic_type_folder);
		holder.textView.setText(file.getName());

		return row;
	}
}

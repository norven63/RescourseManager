package norven.rescourseplayer.customviews;

import norven.rescourseplayer.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {
	private static final int TESTATTR = R.styleable.MyAttrView_testattr;

	public MyTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public MyTextView(Context context) {
		super(context);
	}

	private void init(Context context, AttributeSet attrs) {
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyAttrView);
		int testAttr = typedArray.getInt(TESTATTR, 10);
		typedArray.recycle();

		setText(testAttr + "");
	}
}

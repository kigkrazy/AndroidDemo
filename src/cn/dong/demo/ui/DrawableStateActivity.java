package cn.dong.demo.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.dong.demo.R;
import cn.dong.demo.base.BaseActivity;

public class DrawableStateActivity extends BaseActivity implements OnClickListener {
	boolean isSelected;
	boolean isCustom;

	TextView image;

	@Override
	protected int initPageLayoutID() {
		return R.layout.drawable_state_activity;
	}

	@Override
	protected void initPageView() {
		// TODO Auto-generated method stub
		image = (TextView) findViewById(R.id.image);
	}

	@Override
	protected void initPageViewListener() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void process(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		Drawable drawable = image.getCompoundDrawables()[2];
		switch (v.getId()) {
		case R.id.selected:
			if (isSelected) {
				isSelected = false;
			} else {
				isSelected = true;
			}
			image.setSelected(isSelected);
			printState(drawable);
			break;
		case R.id.custom:
			printState(drawable);
			if (isCustom) {
				isCustom = false;
				drawable.setState(new int[] { 0 });
			} else {
				isCustom = true;
				drawable.setState(new int[] { R.attr.state_custom });
			}
			printState(drawable);
			break;
		}
	}

	private void printState(Drawable drawable) {
		int[] ints = drawable.getState();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ints.length; i++) {
			sb.append("i:").append(ints[i]).append(" ");
		}
		Log.d("drawable", sb.toString());
	}

}

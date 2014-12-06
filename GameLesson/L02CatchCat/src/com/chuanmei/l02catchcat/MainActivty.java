package com.chuanmei.l02catchcat;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivty extends Activity implements OnClickListener {

	private RelativeLayout mainLayout;
	private int width, height;
	private int widthCount = 9, heightCount = 9;
	private int rectWidth, rectHeight;

	private final int NORMALCOLOR = Color.GRAY;
	private final int BARCOLOR = Color.YELLOW;
	private final int CATCOLOR = Color.BLUE;

	private Rect[][] rectArr = new Rect[widthCount][heightCount];

	private Rect rect;
	private RelativeLayout.LayoutParams rectLp;
	private Rect cat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mainLayout = new RelativeLayout(this);
		setContentView(mainLayout);

		initGame();
		addRect();
	}

	private void addRect() {

		for (int i = 0; i < widthCount; i++) {
			for (int j = 0; j < heightCount; j++) {

				int rectColor = NORMALCOLOR;
				int randomIndex = (int) (Math.random() * 6);
				if (randomIndex == 1) {
					rectColor = BARCOLOR;
				}
				if (i == 4 && j == 4) {
					rectColor = CATCOLOR;
				}
				rect = new Rect(this, rectColor, i, j);
				rectLp = new RelativeLayout.LayoutParams(rectWidth - 10,
						rectHeight - 10);
				rectLp.leftMargin = j % 2 == 0 ? i * rectWidth + 10 : i
						* rectWidth + 10 + rectWidth / 2;
				rectLp.topMargin = j * rectHeight + 10;
				mainLayout.addView(rect, rectLp);

				rectArr[i][j] = rect;
				rect.setOnClickListener(this);
			}
		}

		cat = rectArr[4][4];
	}

	private void initGame() {

		WindowManager wm = getWindowManager();
		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();

		rectWidth = (width - 30) / widthCount;
		rectHeight = rectWidth;

		System.out.println(rectWidth);
	}

	@Override
	public void onClick(View v) {

		Rect touchRect;

		if (v instanceof Rect) {

			touchRect = (Rect) v;
			if (touchRect.getColor() == NORMALCOLOR) {

				rectArr[touchRect.getPointX()][touchRect.getPointY()]
						.setColor(BARCOLOR);

				int catPointX = cat.getPointX();
				int catPointY = cat.getPointY();

				if (catPointX <= 0 || catPointX >= 8 || catPointY <= 0
						|| catPointY >= 8) {
					showLog("You lost!");
					return;

				}

				Rect catLeftRect = rectArr[catPointX - 1][catPointY];
				Rect catRightRect = rectArr[catPointX + 1][catPointY];

				Rect catTopLeftRect;
				Rect catTopRightRect;
				Rect catButtomLeftRect;
				Rect catButtomRightRect;

				if (catPointY % 2 == 0) {
					catTopLeftRect = rectArr[catPointX - 1][catPointY - 1];
					catTopRightRect = rectArr[catPointX][catPointY - 1];
					catButtomLeftRect = rectArr[catPointX - 1][catPointY + 1];
					catButtomRightRect = rectArr[catPointX][catPointY + 1];
				} else {
					catTopLeftRect = rectArr[catPointX][catPointY - 1];
					catTopRightRect = rectArr[catPointX + 1][catPointY - 1];
					catButtomLeftRect = rectArr[catPointX][catPointY + 1];
					catButtomRightRect = rectArr[catPointX + 1][catPointY + 1];
				}

				if (catLeftRect.getColor() == NORMALCOLOR) {
					changeCatLocation(catLeftRect);
				} else if (catTopLeftRect.getColor() == NORMALCOLOR) {
					changeCatLocation(catTopLeftRect);
				} else if (catTopRightRect.getColor() == NORMALCOLOR) {
					changeCatLocation(catTopRightRect);
				} else if (catRightRect.getColor() == NORMALCOLOR) {
					changeCatLocation(catRightRect);
				} else if (catButtomRightRect.getColor() == NORMALCOLOR) {
					changeCatLocation(catButtomRightRect);
				} else if (catButtomLeftRect.getColor() == NORMALCOLOR) {
					changeCatLocation(catButtomLeftRect);
				} else {
					showLog("You Win!");
				}

			} else if (touchRect.getColor() == BARCOLOR) {
				return;
			} else if (touchRect.getColor() == CATCOLOR) {
				showLog("Don't touch me,I'm Cat!");
				return;
			}
		}
	}

	private void changeCatLocation(Rect changeRect) {
		cat.setColor(NORMALCOLOR);
		changeRect.setColor(CATCOLOR);
		cat = changeRect;
	}

	private void showLog(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}
}

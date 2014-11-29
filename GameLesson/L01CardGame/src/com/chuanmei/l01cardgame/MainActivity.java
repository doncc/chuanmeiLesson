package com.chuanmei.l01cardgame;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private RelativeLayout mainLayout;

	private int width, height;
	private int cardWidth = 70, cardHeight = 70;
	private int widthCount, heightCount;
	private ArrayList<Point> pointArr = new ArrayList<Point>();
	private final int cardCount = 5;
	private Card card;
	private RelativeLayout.LayoutParams cardLp;
	private ArrayList<Card> cardArr = new ArrayList<Card>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mainLayout = new RelativeLayout(this);
		setContentView(mainLayout);

		initGame();
		getAllPoint();
		addCard();
	}

	private void addCard() {
		Point point;

		for (int i = num_index; i <= cardCount; i++) {
			point = pointArr.remove((int) (Math.random() * pointArr.size()));
			card = new Card(this, i);
			cardLp = new RelativeLayout.LayoutParams(cardWidth - 10,
					cardHeight - 10);
			cardLp.leftMargin = point.x;
			cardLp.topMargin = point.y;

			mainLayout.addView(card, cardLp);

			card.setOnClickListener(this);
			cardArr.add(card);
		}
	}

	private void getAllPoint() {

		for (int i = 0; i < widthCount; i++) {
			for (int j = 0; j < heightCount; j++) {
				pointArr.add(new Point(i * cardWidth + 10, j * cardHeight + 10));
			}
		}
	}

	private void initGame() {

		cardArr.clear();
		pointArr.clear();

		WindowManager wm = getWindowManager();
		// WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);

		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();

		widthCount = (width - 10) / cardWidth;
		heightCount = (height - 10) / cardHeight - 1;

	}

	@Override
	public void onClick(View v) {

		if (v instanceof Card) {

			card = (Card) v;
			if (isStartGame) {

				if (card.getNum() == num_index) {
//					card.showB();
					mainLayout.removeView(v);
					cardArr.remove(v);
					
					checkGame();
					
					num_index++;
				} else {
					showLog("game over!");
				}
				return;
			}
			
			for (Card ca : cardArr) {
				ca.showB();
			}
			isStartGame = true;
			
		}
	}

	private void checkGame() {

		if (cardArr.size() <= 0) {
			showLog("you win!");
		}
	}

	private void showLog(String str) {

		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	private int num_index = 1;
	private boolean isStartGame = false;
}

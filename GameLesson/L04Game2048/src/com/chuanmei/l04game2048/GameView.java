package com.chuanmei.l04game2048;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

@SuppressLint("NewApi")
public class GameView extends GridLayout {

	private Card[][] cardArr = new Card[4][4];
	private List<Point> points = new ArrayList<Point>();
	private float startX, startY, cuX, cuY;

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initGame();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGame();
	}

	public GameView(Context context) {
		super(context);
		initGame();
	}

	private void initGame() {
		setColumnCount(4);
		// System.out.println("initGame");
		setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:

					cuX = event.getX() - startX;
					cuY = event.getY() - startY;

					if (Math.abs(cuX) > Math.abs(cuY)) {

						if (cuX < -3) {
							slipLeft();
						} else if (cuX > 3) {
							slipeRight();
						}
					} else if (Math.abs(cuX) < Math.abs(cuY)) {

						if (cuY < -3) {
							slipeTop();
						} else if (cuY > 3) {
							slipeButtom();
						}
					}

					break;

				default:
					break;
				}

				return true;
			}

		});
	}

	private void slipLeft() {

		boolean merge = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				
				for (int x1 = x + 1; x1 < 4; x1++) {
					if (cardArr[x1][y].getNum() > 0) {
						
						if (cardArr[x][y].getNum() == 0) {
							cardArr[x][y].setNum(cardArr[x1][y].getNum());
							cardArr[x1][y].setNum(0);
							merge = true;
							x--;
						}else if (cardArr[x][y].equals(cardArr[x1][y])) {
							cardArr[x][y].setNum(cardArr[x][y].getNum() * 2);
							cardArr[x1][y].setNum(0);
							addSource(cardArr[x][y].getNum());
							merge = true;
						}
						
						break;
					}
				}
			}
		}
		
		if (merge) {
			addNumCard();
		}
	}

	private void slipeRight() {

		boolean merge = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 3; x >= 0; x--) {
				
				for (int x1 = x - 1; x1 >= 0; x1--) {
					if (cardArr[x1][y].getNum() > 0) {
						
						if (cardArr[x][y].getNum() == 0) {
							cardArr[x][y].setNum(cardArr[x1][y].getNum());
							cardArr[x1][y].setNum(0);
							merge = true;
							x++;
						}else if (cardArr[x][y].equals(cardArr[x1][y])) {
							cardArr[x][y].setNum(cardArr[x][y].getNum() * 2);
							cardArr[x1][y].setNum(0);
							addSource(cardArr[x][y].getNum());
							merge = true;
						}
						
						break;
					}
				}
			}
		}
		if (merge) {
			addNumCard();
		}
	}

	private void slipeTop() {
		boolean merge = false;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				
				for (int y1 = y + 1; y1 < 4; y1++) {
					if (cardArr[x][y1].getNum() > 0) {
						
						if (cardArr[x][y].getNum() == 0) {
							cardArr[x][y].setNum(cardArr[x][y1].getNum());
							cardArr[x][y1].setNum(0);
							merge = true;
							y--;
						}else if (cardArr[x][y].equals(cardArr[x][y1])) {
							cardArr[x][y].setNum(cardArr[x][y].getNum() * 2);
							cardArr[x][y1].setNum(0);
							addSource(cardArr[x][y].getNum());
							merge = true;
						}
						
						break;
					}
				}
			}
		}
		if (merge) {
			addNumCard();
		}
		
	}

	private void slipeButtom() {

		boolean merge = false;
		for (int x = 0; x < 4; x++) {
			for (int y = 3; y >= 0; y--) {
				
				for (int y1 = y - 1; y1 >= 0; y1--) {
					if (cardArr[x][y1].getNum() > 0) {
						
						if (cardArr[x][y].getNum() == 0) {
							cardArr[x][y].setNum(cardArr[x][y1].getNum());
							cardArr[x][y1].setNum(0);
							merge = true;
							y++;
						}else if (cardArr[x][y].equals(cardArr[x][y1])) {
							cardArr[x][y].setNum(cardArr[x][y].getNum() * 2);
							cardArr[x][y1].setNum(0);
							addSource(cardArr[x][y].getNum());
							merge = true;
						}
						
						break;
					}
				}
			}
		}
		
		if (merge) {
			addNumCard();
		}
	}
	
	private void addSource(int source){
		MainActivity.addSource(source);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		int width = (Math.min(w, h) - 10) / 4;
		addCard(width, width);
	}

	private void addCard(int width, int height) {

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				Card card = new Card(getContext());
				card.setNum(0);
				addView(card, width, height);
				cardArr[x][y] = card;
			}
		}
		addNumCard();
		addNumCard();
		addNumCard();
		addNumCard();
		addNumCard();
	}

	private void addNumCard() {

		points.clear();
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (cardArr[x][y].getNum() == 0) {
					points.add(new Point(x, y));
				}
			}
		}

		Point point = points.remove((int) (Math.random() * points.size()));
		cardArr[point.x][point.y].setNum(Math.random() * 1 > 0.1 ? 2 : 4);
	}
}

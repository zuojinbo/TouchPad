package com.example.touchpad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * 
 * @Title TouchView
 * @Description »æÍ¼°å£¬´¥Ãþ»æÍ¼
 * @author zjb email:zjblt@qq.com
 * @Date 2017Äê6ÔÂ21ÈÕÉÏÎç10:46:44
 *
 */
public class TouchView extends View {
	
	private Canvas cacheCanvas;
	private Bitmap bitmap;
	public Paint paint;
	private float preX;
	private float preY;

	private Path path;
	public TouchView(Context context, int width, int height) {
		super(context);
		cacheCanvas = new Canvas();
	    bitmap = Bitmap.createBitmap(width, height,Config.ARGB_4444);
		cacheCanvas.setBitmap(bitmap);
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(1);
		paint.setDither(true);
		path = new Path();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint bmPaint = new Paint();
		canvas.drawBitmap(bitmap, 0, 0, bmPaint);
		canvas.drawPath(path, paint);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			preX = event.getX();
			preY = event.getY();
			path.moveTo(preX, preY);
			break;
		case MotionEvent.ACTION_MOVE:
			path.quadTo(preX, preY, event.getX(), event.getY());
			preX = event.getX();
			preY = event.getY();
			break;
			
		case MotionEvent.ACTION_UP:
			cacheCanvas.drawPath(path, paint);
			path.reset();
			break;
		default:
			break;
		}
		invalidate();
		return true;
	}
}

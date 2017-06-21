# TouchPad
====

Android 绘图板
利用双缓冲技术实现的绘图板View
使用时可以引入TouchView控件即可：
```
    llSketchPad = (LinearLayout) findViewById(R.id.ll_sketchpad);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		TouchView touchView = new TouchView(this, metrics.widthPixels, metrics.heightPixels);
		llSketchPad.addView(touchView);
   

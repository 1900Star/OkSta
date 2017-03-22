package waimai.yunlian.com.okstar.activity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import waimai.yunlian.com.okstar.R;

/**
 * Created by Stran on 2016/12/25.
 */
public class ViewActivity extends BaseAcitivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        initShow();
    }

    private void initShow() {
        Canvas canvas = new Canvas();
        Paint  paint  = new Paint();
        paint.setColor(Color.BLACK);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,paint);
    }
}

package waimai.yunlian.com.okstar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import waimai.yunlian.com.okstar.model.PieData;

/**
 * Created by Stran on 2016/12/25.
 */

public class PieView
        extends View
{
    private float mStartangle;
    private int[] mColors = {0xFFCCFF00,
                             0xFF6495ED,
                             0xFFE32636,
                             0xFF800000,
                             0xFF808000,
                             0xFFFF8C69,
                             0xFF808080,
                             0xFFE6B800,
                             0xFF7CFC00};
    private List<PieData> mDataList;
    private int           mWidth, mHeight;
    Paint mPaint = new Paint();

    public PieView(Context context) {
        super(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mDataList == null) { return; }
        canvas.translate(mWidth / 2, mHeight / 2);
        float r= (float) (Math.min(mWidth, mHeight)/2*0.8);
        RectF rectF = new RectF(-r, -r, r, r);

        for (int i=0;i<mDataList.size();i++) {
            float currentAngle=mStartangle;
            PieData pieData   = mDataList.get(i);
            mPaint.setColor((int) pieData.getColor());
            canvas.drawArc(rectF, currentAngle, pieData.getAngle(), true, mPaint);
            currentAngle=pieData.getAngle();

        }
    }
    public void setStartAngle(float angle){
        mStartangle=angle;
        invalidate();

    }

    public void setData(ArrayList<PieData> dataList) {
        mDataList=dataList;
        initData(mDataList);
        invalidate();
    }

    private void initData(List<PieData> list) {
        if (mDataList == null | mDataList.size() == 0) {
            return;
        }

        float sumValue=0;
        for (int i = 0; i < mDataList.size(); i++) {
            PieData pieData = mDataList.get(i);
            sumValue+=pieData.getValue();
          int j=i%mColors.length;
          pieData.setColor(j);

        }
        float sumAngle=0;
        for (int i = 0; i < mDataList.size(); i++) {
            PieData pieData = mDataList.get(i);
            int   percentAge       = (int) (pieData.getValue() / sumValue);
            int   currentAngle = (int) (percentAge * 360);
            pieData.setPercentage(percentAge);
            pieData.setAngle(currentAngle);
            sumAngle+=currentAngle;

        }


    }

}

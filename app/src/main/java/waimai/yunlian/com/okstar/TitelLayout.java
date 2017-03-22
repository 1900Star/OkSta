package waimai.yunlian.com.okstar;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Stran on 2016/12/20.
 */

public class TitelLayout
        extends LinearLayout
        implements View.OnClickListener

{

    private Button   mBack;
    private Button   mEdt;
    private TextView mTitel;

    public TitelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context)
                      .inflate(R.layout.titel, this);
        intView();
        initListener();

    }

    private void initListener() {
        mBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mEdt.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    private void intView() {
        mBack = (Button) findViewById(R.id.back);
        mEdt = (Button) findViewById(R.id.edt);
        mTitel = (TextView) findViewById(R.id.tv_titel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                ((Activity)getContext()).finish();
                break;

            case R.id.edt:
                Toast.makeText(getContext()," YOU Clicked Edit Button",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

    }
}

package waimai.yunlian.com.okstar.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Random;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.util.ImageUitl;

import static waimai.yunlian.com.okstar.util.ImageUitl.picUrlArr;

/**
 * Created by Stran on 2016/12/29.
 */

public class AboutActivity
        extends AppCompatActivity
{


    private Toolbar mToolbar;
    private ImageView mBackDrop;
    private CollapsingToolbarLayout mToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.about_activity);

        initView();
        initData();
    }


    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.about_toolbar);
        mBackDrop = (ImageView) findViewById(R.id.backdrop);
        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);


    }
    private void initData() {

        int      i         = new Random().nextInt(ImageUitl.picUrlArr.length);
        String url=picUrlArr[i];

        mToolbar.setTitle("关于我");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.ic_back);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
        Glide.with(this).load(url).asBitmap().into(mBackDrop);

    }

    public void finishActivity(){
        finish();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }
}

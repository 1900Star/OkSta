package waimai.yunlian.com.okstar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.largeImage.view.LargeImageView;

public class LargeImageViewActivity extends AppCompatActivity
{
    private LargeImageView mLargeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image_view);

        mLargeImageView = (LargeImageView) findViewById(R.id.iv_large);

        try
        {

            InputStream inputStream = getAssets().open("qm.jpg");
            mLargeImageView.setInputStream(inputStream);

        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}

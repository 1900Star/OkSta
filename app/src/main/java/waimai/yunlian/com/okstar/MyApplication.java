package waimai.yunlian.com.okstar;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Stran on 2016/12/29.
 */

public class MyApplication
        extends Application
{

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

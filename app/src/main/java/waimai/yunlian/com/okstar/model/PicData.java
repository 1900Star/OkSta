package waimai.yunlian.com.okstar.model;

import android.widget.ImageView;

/**
 * Created by Stran on 2017/2/28.
 */

public class PicData {
    private ImageView mView;

    public PicData(ImageView view) {
        mView = view;
    }

    public ImageView getView() {
        return mView;
    }

    public void setView(ImageView view) {
        mView = view;
    }
}

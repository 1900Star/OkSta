package waimai.yunlian.com.okstar.model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import waimai.yunlian.com.okstar.R;


/**
 * Created by Stran on 2016/12/28.
 */

public class ImageData {
    private static String TAG = "ImageData";
    Context mContext;
    private List<Person> mList;
    int[]    arrImage     = {R.drawable.aa,
                             R.drawable.bb,
                             R.drawable.cc,
                             R.drawable.dd,
                             R.drawable.ee,
                             R.drawable.ff,
                             R.drawable.gg,
                             R.drawable.hh};
    String[] arrImageName = {"aa",
                             "bb",
                             "cc",
                             "dd",
                             "ee",
                             "ff",
                             "gg",
                             "hh"};


    public ImageData(Context context) {
        mContext = context;
        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        Random random = new Random();
        //        int    imageIndex = random.nextInt(arrImage.length);
        //        int    imageName  = random.nextInt(arrImageName.length);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < arrImageName.length ; j++) {

                Person person = new Person(arrImage[j], arrImageName[j]);

                mList.add(person);
            }
            Log.d(TAG, "        " + mList.size());

        }

    }


    public List<Person> getList() {
        return mList;
    }

    public void setList(List<Person> list) {
        mList = list;
    }
}

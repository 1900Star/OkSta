package waimai.yunlian.com.okstar.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.adapter.ImageAdapter;
import waimai.yunlian.com.okstar.model.PicData;
import waimai.yunlian.com.okstar.util.ImageUitl;
import waimai.yunlian.com.okstar.util.LogUtil;

/**
 * Created by Stran on 2017/2/25.
 */
public class ShowImageActivity extends BaseAcitivity{
    private static final java.lang.String TAG ="ShowImageActivity" ;
    private List<PicData> mList;
    public Context mContext;
//    ImageView imageView=new ImageView(getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_image_activity);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        ImageView    imageView = (ImageView) findViewById(R.id.iv);

        mList = new ArrayList<>();

        //从网络获取图片
        for (int i = 0; i < ImageUitl.picUrlArr.length; i++) {
//           ImageView image = ImageUitl.getGlidLoadPic(this, this.);
//            LogUtil.d("这是图片 信息  "+TAG   , image.toString());
//            PicData picData = new PicData(image);
//            mList.add(picData);
            LogUtil.d("这是List长度  ", "============"+TAG+"=============      "+mList.size());
        }
        ImageAdapter adapter=new ImageAdapter(getApplicationContext(),mList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }
}

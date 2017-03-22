package waimai.yunlian.com.okstar.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.model.PicData;
import waimai.yunlian.com.okstar.util.LogUtil;

/**
 * Created by Stran on 2017/2/28.
 */

public class ImageAdapter
        extends RecyclerView.Adapter<ImageAdapter.MyViewHolder>
{
private           List<PicData> mList;
    private       Context       mContext;

    private String TAG = "ImageAdapter";
    private MyViewHolder mHolder;

    public ImageAdapter( Context context,List<PicData> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                                     .inflate(R.layout.pic_activity, parent, false);
        mHolder = new MyViewHolder(v);

        return mHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PicData picData = mList.get(position);

        BitmapDrawable drawable = (BitmapDrawable) picData.getView().getDrawable();
        Bitmap         bitmap   = drawable.getBitmap();
        LogUtil.d("这是绑定的图片 信息  "+TAG   , bitmap.toString());
       mHolder.mIvPic.setImageBitmap(bitmap);
    }


    @Override
    public int getItemCount() {
        LogUtil.d(TAG,""+mList.size());
        return mList!=null&&mList.size()!=0?mList.size():0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{


        public final ImageView     mIvPic;
        public MyViewHolder(View itemView) {
            super(itemView);
            mIvPic = (ImageView) itemView.findViewById(R.id.iv_pic);

        }
    }
}

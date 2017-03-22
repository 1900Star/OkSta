package waimai.yunlian.com.okstar.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.activity.MsgActivity;
import waimai.yunlian.com.okstar.holder.RcyclerMainHolder;
import waimai.yunlian.com.okstar.model.Person;

/**
 * Created by Stran on 2016/12/20.
 */

public class RecyclerListAdapter
        extends RecyclerView.Adapter<RcyclerMainHolder>
        implements View.OnClickListener
{
    private List<Person>      mList;
    private RcyclerMainHolder mHolder;
    Context context;

    public RecyclerListAdapter(List<Person> list, Context context) {
        this.context = context;
        this.mList = list;

    }

    @Override
    public RcyclerMainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.item, parent, false);
        mHolder = new RcyclerMainHolder(view);


        mHolder.mRl.setOnClickListener(this);

        return mHolder;
    }

    @Override
    public void onBindViewHolder(RcyclerMainHolder holder, int position) {
        Person person = mList.get(position);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                                                     person.getImageId(),
                                                     getBitmapOption(2));

        mHolder.mMIv.setImageBitmap(bitmap);
        //        mHolder.mCircleMainIv.setImageBitmap(bitmap);
//        mHolder.mMIv.setImageResource(person.getImageId());

        //        ImageView imageView = mViewList.get(position);
        //        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        //
        //        mHolder.mMIv.setImageBitmap(bitmap);
    }

    private BitmapFactory.Options getBitmapOption(int inSampleSize) {
        System.gc();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inSampleSize = inSampleSize;
        return options;
    }


    @Override
    public int getItemCount() {
        return mList != null
               ? 0
               : mList.size();
    }

    @Override
    public void onClick(View v) {
        //        int    position = mHolder.getAdapterPosition();
        //        Person person   = mList.get(position - 1);
        //        Toast.makeText(v.getContext(), "this is data  " + person.getTv(), Toast.LENGTH_LONG)
        //             .show();
        context.startActivity(new Intent(context, MsgActivity.class));
    }


}

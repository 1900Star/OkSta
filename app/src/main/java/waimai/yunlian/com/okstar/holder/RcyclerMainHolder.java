package waimai.yunlian.com.okstar.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import waimai.yunlian.com.okstar.R;

/**
 * Created by Stran on 2016/12/28.
 */

public class RcyclerMainHolder
        extends RecyclerView.ViewHolder
{

    public ImageView       mMIv;
    public TextView        mTvItem;
    public LinearLayout   mRl;

    public RcyclerMainHolder(View itemView) {
        super(itemView);
        initView();
    }

    public void initView() {
        mMIv = (ImageView) itemView.findViewById(R.id.iv);

        //        mTvItem = (TextView) itemView.findViewById(R.id.tv_item);
        mRl = (LinearLayout) itemView.findViewById(R.id.rl);

    }
}

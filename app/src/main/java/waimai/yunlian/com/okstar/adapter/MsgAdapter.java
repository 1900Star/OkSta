package waimai.yunlian.com.okstar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.holder.MsgHolder;
import waimai.yunlian.com.okstar.model.Msg;
import waimai.yunlian.com.okstar.util.LogUtil;

/**
 * Created by Stran on 2016/12/22.
 */

public class MsgAdapter
        extends RecyclerView.Adapter<MsgHolder>
        implements View.OnClickListener
{

    private List<Msg> mMsgList;
Context mContext;
    public MsgAdapter(List<Msg> list) {
        mMsgList = list;

    }


    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.msg_item, parent, false);


        return new MsgHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, int position) {
        Msg msg = mMsgList.get(position);

        if (msg.getType() == Msg.TYPE_RECICE) {
            holder.mLeftView.setVisibility(View.VISIBLE);
            holder.mRightView.setVisibility(View.GONE);
            holder.mLeftContent.setText(msg.getContent());
            holder.mLeftContent.setOnClickListener(this);
        } else if (msg.getType() == Msg.TYPE_SEND) {
            holder.mRightView.setVisibility(View.VISIBLE);
            holder.mLeftView.setVisibility(View.GONE);
            holder.mRightContent.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }


    @Override
    public void onClick(View view) {
        LogUtil.d("44444444444444444444444444444444444444444444");

    }
}
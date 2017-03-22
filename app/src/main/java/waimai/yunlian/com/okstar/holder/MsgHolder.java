package waimai.yunlian.com.okstar.holder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.activity.ThreedActivity;
import waimai.yunlian.com.okstar.activity.ViewActivity;

/**
 * Created by Stran on 2016/12/28.
 */

public class MsgHolder extends RecyclerView.ViewHolder

            implements View.OnClickListener
    {

        public final RelativeLayout mLeftView;
        public final RelativeLayout mRightView;
        public       TextView     mLeftContent;
        public       TextView     mRightContent;

        public MsgHolder(View view) {
            super(view);
            mLeftView = (RelativeLayout) view.findViewById(R.id.left_view);
            mRightView = (RelativeLayout) view.findViewById(R.id.right_view);
            mLeftContent = (TextView) view.findViewById(R.id.left_content);
            mRightContent = (TextView) view.findViewById(R.id.right_content);
            initlistener();

        }

        private void initlistener() {
            mRightView.setOnClickListener(this);
            mLeftView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.left_view:
                    Toast.makeText(itemView.getContext(), "this is Left View", Toast.LENGTH_LONG).show();
                    view.getContext().startActivity(new Intent(view.getContext(), ViewActivity.class));
                    break;
                case R.id.right_view:
                    Toast.makeText(itemView.getContext(), "this is Right View", Toast.LENGTH_LONG).show();
                   view.getContext().startActivity(new Intent(view.getContext(), ThreedActivity.class));
                    break;
                default:
                    break;
            }

        }

}

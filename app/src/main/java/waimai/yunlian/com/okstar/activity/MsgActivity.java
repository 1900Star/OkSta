package waimai.yunlian.com.okstar.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.adapter.MsgAdapter;
import waimai.yunlian.com.okstar.model.Msg;

/**
 * Created by Stran on 2016/12/22.
 */

public class MsgActivity
        extends BaseAcitivity
        implements View.OnClickListener
{

    private static final String TAG = "MsgActivity";
    private RecyclerView mRecyclerView;
    private List<Msg> mList = new ArrayList<>();
   static String[] arr = {"this is Smartisan",
                    "You can be call me Star",
                    "我会打五笔","新年快乐！！！"};
    private EditText   mInputContent;
    private Button     mSendBtn;
    private MsgAdapter mAdapter;
    private Button mGoBth;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.msg_activity);
        ActionBar actionBar = getSupportActionBar();

        initView();
        initData();
        initListener();
    }


    private void initListener() {
        mSendBtn.setOnClickListener(this);
        mGoBth.setOnClickListener(this);

    }

    private void initView() {
      
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mInputContent = (EditText) findViewById(R.id.input_content);
        mSendBtn = (Button) findViewById(R.id.send_btn);
        mGoBth = (Button) findViewById(R.id.send_btnLeft);

    }

    private void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

        mAdapter = new MsgAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onClick(View v) {
        String msg = mInputContent.getText()
                                  .toString();
        switch (v.getId()) {

            case R.id.send_btn:
                Msg content1 = new Msg(msg, Msg.TYPE_SEND);
                mList.add(content1);
                mAdapter.notifyItemInserted(mList.size() - 1);
                mRecyclerView.scrollToPosition(mList.size() - 1);
                mInputContent.setText("");
                break;
            case R.id.send_btnLeft:
                Random random = new Random();
                int    i      = random.nextInt(arr.length);


                Log.d(TAG, "        "+i);
                Msg content = new Msg(arr[i], Msg.TYPE_RECICE);
                mList.add(content);
                mAdapter.notifyItemInserted(mList.size() - 1);
                mRecyclerView.scrollToPosition(mList.size() - 1);
                mInputContent.setText("");
                break;
            default:
                 break;
        }



    }


}

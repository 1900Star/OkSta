package waimai.yunlian.com.okstar.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import waimai.yunlian.com.okstar.R;

/**
 * Created by Stran on 2016/12/14.
 */
public class SendActivity
        extends BaseAcitivity
        implements View.OnClickListener
{

    private EditText mName;
    private EditText mPwd;
    private Button   mBth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_activity);
        mBth = (Button) findViewById(R.id.btn);
        mName = (EditText) findViewById(R.id.edt_name);
        mPwd = (EditText) findViewById(R.id.edt_pwd);
        initListener();


    }

    private void initListener() {
        mBth.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //        Intent intent = new Intent(SendActivity.this, MainActivity.class);
        //        intent.putExtra("name","SmartisanT1");
        //        intent.putExtra("sony","XperaZ3");
        //        setResult(RESULT_OK,intent);
        //        finish();
        //        startActivityForResult(intent,100);
        String name = mName.getText()
                           .toString();
        String pwd = mPwd.getText()
                         .toString();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
            ThreedActivity.actonStart(SendActivity.this, name, pwd);

        } else {
            Toast.makeText(SendActivity.this, "请输入姓名和密码", Toast.LENGTH_LONG)
                 .show();
        }


    }
}

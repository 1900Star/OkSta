package waimai.yunlian.com.okstar.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import waimai.yunlian.com.okstar.R;


/**
 * Created by Stran on 2016/12/16.
 */

public class ThreedActivity
        extends BaseAcitivity
        implements View.OnClickListener
{

    private Button          mBtn1;
    private ProgressBar     mPb;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;
    private Button          mBtn2;
    private Button mBtn3;
    private Button mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_activity);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn_th2);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn4 = (Button) findViewById(R.id.btn4);

        mPb = (ProgressBar) findViewById(R.id.pb);

        initListener();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API)
                                                   .build();
    }

    public static void actonStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, ThreedActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
       if (intent!=null){
           show(context,data1,data2);
       }

    }

    public static void show(Context context,String str1, String str2) {
       Toast.makeText(context,str1+"===="+str2,Toast.LENGTH_LONG).show();


    }


    private void initListener() {
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //        Intent intent = new Intent();
        //        intent.putExtra("apple", "MacBookPro");
        //        setResult(2,intent);
        //        finish();
        //        if (mPb.getVisibility()==View.VISIBLE){
        //            mPb.setVisibility(View.INVISIBLE);
        //        }else {
        //            mPb.setVisibility(View.VISIBLE);
        //        }
        //        int progress = mPb.getProgress();
        //        progress=progress+10;
        //        mPb.setProgress(progress);
        //        if (progress==100){
        //            Toast.makeText(this, "apple", Toast.LENGTH_LONG)
        //                 .show();
        //        }
        //        AlertDialog.Builder dialog=new AlertDialog.Builder(ThreedActivity.this);
        //        dialog.setTitle("Station Manager");
        //        dialog.setMessage("this is city");
        //        dialog.setCancelable(false);
        //
        //        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialog, int which) {
        //
        //            }
        //        });  dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialog, int which) {
        //
        //            }
        //        });
        //        dialog.show();
        switch (v.getId()) {
            case R.id.btn1:
                ProgressDialog pd = new ProgressDialog(ThreedActivity.this);
                pd.setTitle("This is ProgressDialog");
                pd.setMessage("Loading...");
                pd.setCancelable(true);
                pd.show();
                 break;
            case R.id.btn_th2:
//                startActivity(new Intent(this, PagerImageActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, ImageActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, LargeImageViewActivity.class));
                break;
            default:
                 break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2) {

            String apple = data.getStringExtra("apple");
            Toast.makeText(this, "SmartisanT3", Toast.LENGTH_LONG)
                 .show();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder().setName("Threed Page") // TODO: Define a title for the content shown.
                                          // TODO: Make sure this auto-generated URL is correct.
                                          .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                                          .build();
        return new Action.Builder(Action.TYPE_VIEW).setObject(object)
                                                   .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                                                   .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        AppIndex.AppIndexApi.start(mClient, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mClient, getIndexApiAction());
        mClient.disconnect();
    }
}

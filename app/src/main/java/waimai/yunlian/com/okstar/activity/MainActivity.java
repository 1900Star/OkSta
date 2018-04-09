package waimai.yunlian.com.okstar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.adapter.RecyclerListAdapter;
import waimai.yunlian.com.okstar.model.ImageData;
import waimai.yunlian.com.okstar.model.Person;

public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener

{

    private static final String TAG = "MainActivit";
    private              String Tag = "MainActivity";
    private RecyclerView        mRecyclerView;
    private List<Person>        mList;
    private RecyclerListAdapter mRecyclerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        //        ActionBar actionBar = getSupportActionBar();
        //        if (actionBar == null) {
        //            actionBar.hide();
        //        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        initData();
    }


    private void initData() {
        mList = new ImageData(this).getList();
        int size = mList.size();

        mRecyclerListAdapter = new RecyclerListAdapter(mList, this);
        StaggeredGridLayoutManager manage = new StaggeredGridLayoutManager(2,
                                                                           StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        mRecyclerView.setLayoutManager(manage);
        mRecyclerView.setAdapter(mRecyclerListAdapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 1:

                    String name = data.getStringExtra("name");
                    String sony = data.getStringExtra("sony");
                    Log.d(TAG, name + "    +   " + sony);
                    if (name.equals("SmartisanT1") && sony.equals("XperaZ3")) {
                        Intent intent = new Intent(MainActivity.this, ThreedActivity.class);
                        startActivityForResult(intent, 2);
                    }
                    default:
                        break;



            }
        }
        if (resultCode == 2) {

            String apple = data.getStringExtra("apple");
            Toast.makeText(this, apple, Toast.LENGTH_LONG)
                 .show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, SendActivity.class);
        startActivityForResult(intent, 1);
    }

    class ViewHolder {
        TextView tvNum;
        TextView tvWord;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "this is add item", Toast.LENGTH_LONG)
                     .show();
                break;
            case R.id.about_item:

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

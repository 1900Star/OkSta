package waimai.yunlian.com.okstar.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import waimai.yunlian.com.okstar.R;
import waimai.yunlian.com.okstar.model.GameData;
import waimai.yunlian.com.okstar.util.ImageUitl;
import waimai.yunlian.com.okstar.util.LogUtil;
import waimai.yunlian.com.okstar.view.ZoomImageView;


/**
 * Created by Stran on 2016/12/29.
 */
public class ImageActivity
        extends BaseAcitivity
{

    private static final java.lang.String TAG = "ImageActivity";
    private ImageView mIvGlide;
    private GameData  mGameData;
    Context mContext;
    private ViewPager mViewPager;
    List<ImageView> mList;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        initView();
        initData();
        initListere();
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp);

    }


    private void initData() {
        mMyAdapter = new MyAdapter();
        mViewPager.setAdapter(mMyAdapter);


    }


    private class MyAdapter
            extends PagerAdapter
    {

        @Override
        public int getCount() {
            return ImageUitl.picUrlArr.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ZoomImageView view = new ZoomImageView(ImageActivity.this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                       ViewGroup.LayoutParams.MATCH_PARENT);
            view.setScaleType(ImageView.ScaleType.MATRIX);

            view.reSetState();
//            Glide.with(context)
//                 .load(url)
//                 .asBitmap()
//                 .error(R.drawable.gg)
//                 .into(view);

            ImageUitl.getGlidLoadPic(mContext, position, view);
            //            ImageUitl.getOkHttpLoadpic(ImageActivity.this, position, view);
            container.addView(view, params);
            return view;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        }
        super.onConfigurationChanged(newConfig);
    }

    private void initListere() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                //                initData();
                //                mList.remove(position);

                LogUtil.d(TAG, "这是第" + position);
            }

            @Override
            public void onPageSelected(int position) {
                LogUtil.d(TAG, "这是选中第" + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                LogUtil.d(TAG, "当前状态是" + state);

            }
        });
    }

}

package waimai.yunlian.com.okstar.util;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import waimai.yunlian.com.okstar.R;

/**
 * Created by Stran on 2017/2/24.
 */

public class ImageUitl {

    static        String   TAG       = "ImageUitl";
    public static String[] picUrlArr = {"http://img.mp.itc.cn/upload/20160921/e2539eff010449e8a04c0387e1c275c7_th.jpeg",
                                        "http://pic8.nipic.com/20100623/2568996_083300720588_2.jpg",
                                        "http://pic8.nipic.com/20100623/2568996_083301157944_2.jpg",
                                        "http://www.asahi.com/showbiz/gallery/20110309sada/images/home03.jpg",
                                        "http://s9.sinaimg.cn/middle/64df0f90gc499680089f8&690",
                                        "http://c.hiphotos.baidu.com/zhidao/pic/item/fc1f4134970a304eef4479edd1c8a786c9175c47.jpg",
                                        "http://imgsrc.baidu.com/baike/pic/item/0e2442a7d933c8950df8a76ad51373f082020018.jpg",
                                        "http://img.yule.com.cn/upload/jpg/nagasawamasami/yule0092.jpg",
                                        "http://posters.imdb.cn/ren-pp/0619178/YB8kFxWnY_1190911372.jpg",
                                        "http://imgsrc.baidu.com/baike/pic/item/e4dde71190ef76c604622df99816fdfaae5167b4.jpg",
                                        "http://cdn.duitang.com/uploads/item/201603/27/20160327100800_ysidF.thumb.700_0.jpeg",
                                        "http://image.xinmin.cn/2012/06/27/20120627113211233486.jpg",
                                        "http://cdn.duitang.com/uploads/item/201205/28/20120528121844_CNemU.jpeg",
                                        "http://img4.duitang.com/uploads/item/201412/18/20141218103953_QVWRs.jpeg",
                                        "http://img5.duitang.com/uploads/item/201408/09/20140809211026_4EXAN.jpeg",
                                        "http://news.xinhuanet.com/shuhua/2012-12/01/124032455_161n.jpg",
                                        "http://h5.86.cc/walls/20160303/1440x900_3ea4f573d7355e5.jpg",
                                        "http://img3.duitang.com/uploads/item/201302/15/20130215110229_HnMGj.jpeg",
                                        "http://imgsrc.baidu.com/baike/pic/item/a08b87d6277f9e2f79c9bcd81a30e924b999f366.jpg",
                                        "http://pic9.nipic.com/20100819/2568996_152536117301_2.jpg",
                                        "http://pic9.nipic.com/20100819/2568996_152535489648_2.jpg",
                                        "http://img0.imgtn.bdimg.com/it/u=290611155,1857671296&fm=214&gp=0.jpg",
                                        "http://i2.w.yun.hjfile.cn/slide/201506/201506052390726352.jpg",
                                        "http://i.ce.cn/ce/xwzx/shgj/gdxw/201605/03/W020160503497361794077.jpg",
                                        "http://img3.duitang.com/uploads/item/201605/12/20160512192447_mFjeG.jpeg",
                                        "http://img.7160.com/uploads/allimg/160707/1-160FG34214.jpg",
                                        "http://cdn.duitang.com/uploads/item/201509/17/20150917160112_QZCKu.jpeg",
                                        "http://image11.m1905.com/uploadfile/2009/1221/20091221061006829.jpg",
                                        "http://qximg.lightplan.cc/2016/05/10/1462863397324242.gif?imageView2/2/w/900/h/1600",
                                        "http://img0.imgtn.bdimg.com/it/u=1036761068,3361653394&fm=214&gp=0.jpg",
                                        "http://imgsrc.baidu.com/baike/pic/item/7c1ed21b0ef41bd576ca27bf51da81cb38db3de4.jpg",
                                        "http://img5.cache.netease.com/photo/0003/2015-01-04/AF45G9UF00B60003.jpg",
                                        "http://www.yoka.com/dna/pics/Star/ba15111c/164/d35e311de7dc7ec97d.jpg",
                                        "http://img1.ph.126.net/s3vPdXW29wx-tiJAeFky3g==/4851502698685350157.jpg",
                                        "http://m15.mask9.com/sites/default/files/styles/lg/public/graphics/20150605/164324-ee2d7e6528487b1b554952e006ac34c14ba93fef-23/people-singer-shao-yibei-p2-mask9.jpg?itok=MBWKmFkb",
                                        "http://img4.imgtn.bdimg.com/it/u=4199968251,2321509994&fm=214&gp=0.jpg",
                                        "http://www.wed114.cn/jiehun/uploads/allimg/130422/23_130422144522_4.jpg",
                                        "http://img2.imgtn.bdimg.com/it/u=3773886563,3596131833&fm=214&gp=0.jpg",
                                        "http://ent.sun0769.com/music/news/201311/W020131126420260416278.jpg",
                                        "http://cdn.duitang.com/uploads/item/201407/25/20140725121058_j2wKR.jpeg",
                                        "http://a3.att.hudong.com/60/01/01200000193375136359017074846.jpg",
                                        "http://img4.duitang.com/uploads/item/201602/21/20160221131416_nyZAa.thumb.700_0.png",
                                        "http://nobon.me/wp-content/uploads/2016/10/iphone_KIMINONAHA__0003_Unknown-3.jpg",
                                        "http://wx4.sinaimg.cn/mw690/005T4vvxly1falxqf43j9j31sc15m4qp0.jpg",
                                        "http://wx3.sinaimg.cn/mw690/005T4vvxly1falxqfrogzj31sc16oke40.jpg",
                                        "http://wx4.sinaimg.cn/mw690/005T4vvxly1falxqdyn4aj31sc16oe840.jpg",
                                        "http://imgsrc.baidu.com/baike/pic/item/d1160924ab18972b2c2fd087e5cd7b899e510a62.jpg",
                                        "http://ww2.sinaimg.cn/large/610dc034jw1f5k1k4azguj20u00u0421.jpg",
                                        "http://qz_coffee.dupao.com/XiuXiuUpload/SharePic/XiuXiu2013820850243.jpg",
                                        "http://imgsrc.baidu.com/forum/pic/item/b25f0e465153f0868b139989.jpg",
                                        "http://album.sina.com.cn/pic/49cef469020003w6",
                                        "http://ww1.sinaimg.cn/large/610dc034gw1fb6aqccs3nj20u00u0wk4.jpg",
                                        "http://img2.imgtn.bdimg.com/it/u=3271180130,1167809918&fm=23&gp=0.jpg"};

    public static ImageView getOkHttpLoadpic(Context context,
                                             int position,
                                             final ImageView imageView)
    {
        String       url    = picUrlArr[position];
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url)
                                               .build();
        client.newCall(request)
              .enqueue(new Callback() {
                  @Override
                  public void onFailure(Call call, IOException e) {

                  }

                  @Override
                  public void onResponse(Call call, Response response)
                          throws IOException

                  {
//                      byte[] picByte = response.body()
//                                               .bytes();
//                      final Bitmap bitmap = BitmapFactory.decodeByteArray(picByte,
//                                                                          0,
//                                                                          picByte.length);

                  }
              });
        return imageView;
    }

    public static ImageView getGlidLoadPic(Context context, int position, ImageView imageView) {


        String url = picUrlArr[position];
        System.out.println("this is ImageUrl    " + url);

        Glide.with(context)
             .load(url)
             .asBitmap()
//             .placeholder(R.drawable.gg)
                          .error(R.drawable.gg)
             .into(imageView);

        return imageView;
    }

    public static ImageView getPicassoLoadPic(Context context,
                                              int position,
                                              final ImageView imageView)
    {
        String url = picUrlArr[position];
        Picasso.with(context)
               .load(url)
               .placeholder(R.drawable.gg)
               .into(imageView);
        return imageView;
    }

    //使用Fresco加载图片
    public static SimpleDraweeView getFrescoLoadimage(Context context,
                                                      int position,
                                                      final SimpleDraweeView drawable)
            throws MalformedURLException
    {
        String picUrl = picUrlArr[position];
        Uri    url    = Uri.parse(picUrl);

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(url)
                                                  .setProgressiveRenderingEnabled(true)
                                                  .build();

        BaseControllerListener listener = new BaseControllerListener() {
            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
            }

            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {
                super.onIntermediateImageFailed(id, throwable);
            }

        };
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                                                    .setUri(picUrl)
                                                    .setControllerListener(listener)
                                                    .build();
        drawable.setController(controller);

        return drawable;
    }
}

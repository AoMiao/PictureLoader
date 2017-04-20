package com.vince.pictureloader.pictureloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Administrator on 2017/4/20.
 */

public class ImageReduce {//图片压缩功能

    public Bitmap reduceBitmapFormResource(Resources resources,int id,int reqWidth,int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources,id,options);
        options.inSampleSize = calculateSample(options,reqWidth,reqHeight);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(resources,id,options);
    }

    public int calculateSample(BitmapFactory.Options options,int reqWidth,int reqHeight){
        return 0;
    }
}

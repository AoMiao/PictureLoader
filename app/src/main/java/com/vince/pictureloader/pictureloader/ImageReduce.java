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
        int sampleSize = 0;//计算采样值
        if(reqHeight==0||reqWidth==0){
            return 1;
        }

        final int width = options.outWidth;
        final int height = options.outHeight;

        if(width>reqWidth||height>reqHeight){
            final int halfWidth = width/2;
            final int halfHeight = height/2;
            while ((halfWidth/sampleSize) >=reqWidth
                    && (halfHeight/sampleSize) >=reqHeight){
                sampleSize *=2;
            }
        }
        return sampleSize;
    }
}

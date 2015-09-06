package com.logicalenigma.bnrcriminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Copyright 2015 Logical Enigma
 * Created by dnachman on 9/6/15.
 */
public class PictureUtils {

    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight) {
        // read in the dims of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        // figure out how much to scale down by
        int inSampleSize = 1;
        if (srcHeight > destHeight || srcWidth > destWidth) {
            if (srcWidth > destHeight) {
                // wider is bigger
                inSampleSize = Math.round(srcHeight / destHeight);
            }
            else {
                inSampleSize = Math.round(srcWidth / destWidth);
            }
        }
        // else no need to scale

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        // read in and create final bitmap
        return BitmapFactory.decodeFile(path, options);
    }

    // because won't know dims until actually drawn
    public static Bitmap getScaledBitmap(String path, Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaledBitmap(path, size.x, size.y);
    }
}

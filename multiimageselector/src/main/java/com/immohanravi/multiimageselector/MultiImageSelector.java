package com.immohanravi.multiimageselector;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.immohanravi.multiimageselector.activities.GalleryActivity;

public class MultiImageSelector {

        private Intent GalleryIntent;
        private Bundle OptionsBundle;

        public static int IMAGE_MODE = 2;
        public static int VIDEO_MODE = 3;
        public static int IMAGE_VIDOE_MODE = 1;


        public static MultiImageSelector of(@NonNull String title, @NonNull int mode) {
                return new MultiImageSelector(title, mode);
        }

        private MultiImageSelector(@NonNull String title, @NonNull int mode) {
                GalleryIntent = new Intent();
                OptionsBundle = new Bundle();
                OptionsBundle.putString("title", title);
                OptionsBundle.putInt("mode", mode);
        }

        public MultiImageSelector MaxSelection(int MaxSelection){
                OptionsBundle.putInt("maxSelection",MaxSelection);
                return this;
        }

        /**
         * Send the crop Intent from an Activity with a custom request code
         *
         * @param activity    Activity to receive result
         * @param requestCode requestCode for result
         */
        public void start(@NonNull Activity activity, int requestCode) {
                activity.startActivityForResult(getIntent(activity), requestCode);
        }

        /**
         * Send the crop Intent from a Fragment
         *
         * @param fragment Fragment to receive result
         */

        /**
         * Send the crop Intent from a support library Fragment
         *
         * @param fragment Fragment to receive result
         */
        public void start(@NonNull Context context, @NonNull Fragment fragment, int requestCode) {
                fragment.startActivityForResult(getIntent(context), requestCode);
        }

        public Intent getIntent(@NonNull Context context) {
                GalleryIntent.setClass(context, GalleryActivity.class);
                GalleryIntent.putExtras(OptionsBundle);
                return GalleryIntent;
        }


}
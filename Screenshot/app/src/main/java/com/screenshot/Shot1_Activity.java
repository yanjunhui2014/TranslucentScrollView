package com.screenshot;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 晖仔(Milo) on 2017/1/6.
 * email:303767416@qq.com
 */

public class Shot1_Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnShot;
    ImageView shotView;

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, Shot1_Activity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shot1);
        init();

    }

    private void init() {
        btnShot = (Button) findViewById(R.id.btn_shot);
        btnShot.setOnClickListener(this);

        shotView = (ImageView) findViewById(R.id.img_shot);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_shot:
                shot(shotView);
                break;
        }
    }

    private void shot(View shotView) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        String fname = "/sdcard/" + sdf.format(new Date()) + ".png";
        shotView.setDrawingCacheEnabled(true);
        shotView.buildDrawingCache();
        Bitmap bitmap = shotView.getDrawingCache();

        if (bitmap != null) {
            System.out.println("bitmap  got !");

            try {
                FileOutputStream out = new FileOutputStream(fname);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                System.out.println("file " + fname + "output done.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("bitmap  is NULL !");
        }
    }

}

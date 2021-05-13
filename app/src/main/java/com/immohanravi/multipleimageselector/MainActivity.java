package com.immohanravi.multipleimageselector;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.immohanravi.multiimageselector.MultiImageSelector;
import com.immohanravi.multiimageselector.activities.GalleryActivity;

import java.util.ArrayList;

import static com.immohanravi.multiimageselector.MultiImageSelector.IMAGE_MODE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button opengallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opengallery = findViewById(R.id.opengallery);

        opengallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent= new Intent(MainActivity.this, GalleryActivity.class);
                // Set the title
                intent.putExtra("title","Select media");
                // Mode 1 for both images and videos selection, 2 for images only and 3 for videos!
                intent.putExtra("mode",1);
                startActivityForResult(intent,100);*/

                MultiImageSelector.of("Select Media",IMAGE_MODE)
                        .MaxSelection(5)
                        .start(MainActivity.this,100);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> selectionResult = new ArrayList<>();
        
        if (resultCode == RESULT_OK){
            if (requestCode == 100 && data!=null){
                selectionResult=data.getStringArrayListExtra("result");
                Log.d(TAG, "onActivityResult: "+selectionResult.size());
            }
        }
        
    }
}
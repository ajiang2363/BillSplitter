package com.example.billsplitter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Button takePhoto;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        this.takePhoto = findViewById(R.id.takeImage);
        takePhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                takePhoto();
            }

        });

    }

    public void takePhoto(){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, 1);
        }
    }

    @Override
    protected void onActivityResult(int request, int result, Intent intent){
        if(request == 1 && result == RESULT_OK){
            imageView = findViewById(R.id.imageView);
            Bundle extra = intent.getExtras();
            Bitmap image = (Bitmap) extra.get("data");
            imageView.setImageBitmap(image);
            imageView.setVisibility(View.VISIBLE);
            loadNextPage(image);
        }
    }

    public void loadNextPage(Bitmap image){
        Intent intent = new Intent(this, imagePage.class);
        intent.putExtra("IMAGE", image);
        startActivity(intent);
    }


}

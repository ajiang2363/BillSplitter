package com.example.billsplitter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.itextpdf.text.Document;



public class imagePage extends AppCompatActivity {

    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageshowing);

        Bundle bundle = getIntent().getExtras();
        this.image = (Bitmap)bundle.get("IMAGE");

        showImage(image);
        changetoPDF(image);
    }

    public void showImage(Bitmap image){
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setImageBitmap(image);
    }

    public void changetoPDF(Bitmap image){
        Document document = new Document();

    }
}

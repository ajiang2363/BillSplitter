package com.example.billsplitter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class imagePage extends AppCompatActivity {

    private Bitmap image;
    private WebView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageshowing);

        Bundle bundle = getIntent().getExtras();
        this.image = (Bitmap)bundle.get("IMAGE");
        this.imageView = findViewById(R.id.showPDF);
        changetoPDF(image);
        //findPDF();
    }


    public void changetoPDF(Bitmap image){

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bytes = stream.toByteArray();



        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300,600,1).create();

        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        Matrix matrix = new Matrix();
        matrix.setValues(new float[] { 1, .5f, 0, 0, 1, 0, 0, 0, 1 });
        canvas.drawBitmap(image, matrix, paint);
        document.finishPage(page);

        String directPath = Environment.getExternalStorageDirectory().getPath()+"/test/";
        File file = new File(directPath);

        if(!file.exists()){
            file.mkdirs();
        }

        String targetPdf = directPath+"test1.pdf";
        File filepath = new File(targetPdf);

        try{
            document.writeTo(new FileOutputStream(filepath));
        }
        catch(IOException e){
            System.out.println(e);
        }

        document.close();
    }

}

package com.example.napo01;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.IllegalFormatWidthException;

public class PfList_Main extends AppCompatActivity {
    private ListView pf_List;
    private PfListAdapter pfListAdapter;
    private Button btn_pfPlus;
    private TextView pdf;
    private IllegalFormatWidthException relativeLayout;
    private String dirpath;
    private Display display;
    private Point size;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pofollist_in);

        pf_List = findViewById(R.id.pf_list);
        btn_pfPlus = findViewById(R.id.btn_pfPlus);
        pdf = findViewById(R.id.pdf);

        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getRealSize(size);

        pfListAdapter = new PfListAdapter(size.x, size.y);

        pf_List.setAdapter(pfListAdapter);
        pfListAdapter.addItems(ContextCompat.getDrawable(getApplicationContext(), R.drawable.logo), "", "");

        pfListAdapter.notifyDataSetChanged();
        btn_pfPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView tv_img = pf_List.findViewById(R.id.pf_img);
                TextView tv_date = (TextView) pf_List.findViewById(R.id.tv_coDate);
                TextView tv_title = (TextView) pf_List.findViewById(R.id.edt_pfTitle);


                String date = tv_date.getText().toString();
                String title = tv_title.getText().toString();

                pfListAdapter.addItems(ContextCompat.getDrawable(getApplicationContext(), R.drawable.logo), date, title);

                pf_List.setAdapter(pfListAdapter);
            }
        });

            }


}


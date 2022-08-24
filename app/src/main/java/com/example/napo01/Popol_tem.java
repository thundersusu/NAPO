package com.example.napo01;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Popol_tem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popo_llist_tem);
    }

    public void handleselection(View view) {

        Toast.makeText(this, "Image is tapped", Toast.LENGTH_SHORT).show();
    }
}
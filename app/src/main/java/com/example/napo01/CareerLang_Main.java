package com.example.napo01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CareerLang_Main extends AppCompatActivity {
    private ListView careerLang_List;
    private CareerLangAdapter careerLangAdapter = new CareerLangAdapter();
    private Button btn_langPlus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerlang);

        careerLang_List = findViewById(R.id.careerLang_List);
        btn_langPlus = findViewById(R.id.btn_langPlus);

        careerLang_List.setAdapter(careerLangAdapter);
        careerLangAdapter.addItems("","","","");
        careerLangAdapter.notifyDataSetChanged();



    }
}

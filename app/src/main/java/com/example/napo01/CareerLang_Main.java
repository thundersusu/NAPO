package com.example.napo01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

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

        btn_langPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tv_kind = (EditText)careerLang_List.findViewById(R.id.lang_kind);
                SearchView tv_test = (SearchView)careerLang_List.findViewById(R.id.lang_test);
                EditText tv_score = (EditText)careerLang_List.findViewById(R.id.lang_score);
                EditText tv_date = (EditText)careerLang_List.findViewById(R.id.lang_date);

                String name = tv_kind.getText().toString();
                String inst = tv_test.getQuery().toString();
                String score = tv_score.getText().toString();
                String date = tv_date.getText().toString();
                tv_test.setIconifiedByDefault(false);

//                careerLangAdapter.addItems(name,inst,score,date);
                careerLangAdapter.addItems(name,inst,score,date);

                careerLang_List.setAdapter(careerLangAdapter);
                careerLangAdapter.notifyDataSetChanged();
            }
        });

    }
}

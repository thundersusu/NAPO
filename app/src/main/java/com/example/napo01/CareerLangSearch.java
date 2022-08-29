package com.example.napo01;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CareerLangSearch extends AppCompatActivity {

    EditText langSearch;
    ListView searchList;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerlang_search);

        langSearch = findViewById(R.id.cert_search);
        searchList = findViewById(R.id.cert_searchList);
        arrayList = new ArrayList<>();

        arrayList.add("a");
        arrayList.add("abc");
        arrayList.add("abdegar");
        arrayList.add("b");
        arrayList.add("basr");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("ea");

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        searchList.setAdapter(adapter);

        langSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                CareerLangSearch.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("choice",  arrayList.get(position));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

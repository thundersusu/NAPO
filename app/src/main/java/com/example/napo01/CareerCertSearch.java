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

public class CareerCertSearch extends AppCompatActivity {

    EditText cert_search;
    ListView cert_searchList;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careercert_search);

        cert_search = findViewById(R.id.cert_search);
        cert_searchList = findViewById(R.id.cert_searchList);

        arrayList = new ArrayList<>();

        arrayList.add("컴활");
        arrayList.add("어쩌구");
        arrayList.add("어어어");
        arrayList.add("낙뢰짱");
        arrayList.add("김현령짱");
        arrayList.add("정혜수짱");
        arrayList.add("김건도짱");
        arrayList.add("송찬호짱");
        arrayList.add("고정수짱");

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        cert_searchList.setAdapter(adapter);

        cert_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String value = cert_search.getText().toString();
                ArrayList<String> search_arrayList = new ArrayList<String>();
                for(int ii = 0; ii < arrayList.size(); ii++){
                    if(arrayList.get(ii).startsWith(value)){
                        search_arrayList.add(arrayList.get(ii));
                    }
                }
                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,search_arrayList);
                cert_searchList.setAdapter(adapter);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cert_searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)adapterView.getItemAtPosition(i);
                Intent intent = new Intent();
                intent.putExtra("choice", value);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}

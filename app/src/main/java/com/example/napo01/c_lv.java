package com.example.napo01;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class c_lv extends AppCompatActivity {
    ListView listview;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    EditText certName, certDate, certInst;
    Button btn_Plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careercert_lv_copy);

    listview = findViewById(R.id.listview);
    certName = findViewById(R.id.certName);
    certDate = findViewById(R.id.certinst);
    certInst = findViewById(R.id.certinst);
    items = new ArrayList<>();


    btn_Plus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = certName.getText().toString();
            if(name == null || name.length()==0){
                Toast.makeText(getApplicationContext(),"내용을 입력해주세요",Toast.LENGTH_SHORT).show();
            }else{
                addItem(name);
                certName.setText("");

            }
        }
    });

    }

    public void addItem(String item){
        items.add(item);
        listview.setAdapter(adapter);
    }


}

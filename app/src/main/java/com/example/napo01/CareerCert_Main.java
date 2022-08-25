package com.example.napo01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CareerCert_Main extends AppCompatActivity {
    private ListView careercert_List;
    private CareerCertAdapter careerCertAdapter = new CareerCertAdapter();
    private Button btn_certPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careercert);

        careercert_List = findViewById(R.id.careercert_List);
        btn_certPlus = findViewById(R.id.btn_certPlus);

        careercert_List.setAdapter(careerCertAdapter);
        careerCertAdapter.addItems("","","");
        careerCertAdapter.notifyDataSetChanged();

        btn_certPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchView tv_ser = (SearchView)careercert_List.findViewById(R.id.cert_ser);
                TextView tv_inst = (TextView)careercert_List.findViewById(R.id.certInst);
                TextView tv_date = (TextView)careercert_List.findViewById(R.id.certDate);

                String ser = tv_ser.getQuery().toString();
                String inst = tv_inst.getText().toString();
                String date = tv_date.getText().toString();

                careerCertAdapter.addItems(ser, inst, date);
                careercert_List.setAdapter(careerCertAdapter);
                careerCertAdapter.notifyDataSetChanged();
            }
        });



    }

}

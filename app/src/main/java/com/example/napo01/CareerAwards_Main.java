package com.example.napo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CareerAwards_Main extends AppCompatActivity {
    private ListView careerAwardsList;
    private CareerAwardsAdapter careerawardsAdapter = new CareerAwardsAdapter();
    private Button btn_plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerawards);

        careerAwardsList = findViewById(R.id.careerAwardsList);
        btn_plus = findViewById(R.id.btn_plus);



        careerAwardsList.setAdapter(careerawardsAdapter);
        careerawardsAdapter.addItems("","","");

        careerawardsAdapter.notifyDataSetChanged();

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 현령코드1
                TextView tv_name = (TextView)careerAwardsList.findViewById(R.id.internName);
                TextView tv_inst = (TextView)careerAwardsList.findViewById(R.id.awardsInst);
                TextView tv_date = (TextView)careerAwardsList.findViewById(R.id.awardsDate);
                String name = tv_name.getText().toString();
                String inst = tv_inst.getText().toString();
                String date = tv_date.getText().toString();
                Log.e("tv_name", tv_name.getText().toString());
                Log.e("tv_name", tv_name.getText().toString());
                Log.e("tv_name", tv_name.getText().toString());

                careerawardsAdapter.addItems(name,inst,date);

                careerAwardsList.setAdapter(careerawardsAdapter);

            }
        });


    }
}
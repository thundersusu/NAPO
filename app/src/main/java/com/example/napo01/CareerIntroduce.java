package com.example.napo01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CareerIntroduce extends AppCompatActivity {
    Button btn_intro;
    TextView tv_intro;
    EditText edt_intro;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerintroduce);

        tv_intro = findViewById(R.id.tv_intro);
        edt_intro = findViewById(R.id.edt_intro);
        btn_intro = findViewById(R.id.btn_intro);

        btn_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edt_intro.getText().toString();
                edt_intro.setText(text);
            }
        });

    }
}

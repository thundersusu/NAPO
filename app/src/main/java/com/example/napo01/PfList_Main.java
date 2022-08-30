package com.example.napo01;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class PfList_Main extends AppCompatActivity {
    private ListView pf_List;
    private PfListAdapter pfListAdapter = new PfListAdapter();
    private Button btn_pfPlus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pofollist_in);

        pf_List = findViewById(R.id.pf_list);


        pf_List.setAdapter(pfListAdapter);
        pfListAdapter.addItems(ContextCompat.getDrawable(getApplicationContext(), R.drawable.logo),"","");

        pfListAdapter.notifyDataSetChanged();
        btn_pfPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView tv_img = pf_List.findViewById(R.id.pf_img);
                TextView tv_date = (TextView)pf_List.findViewById(R.id.tv_coDate);
                TextView tv_title = (TextView)pf_List.findViewById(R.id.edt_pfTitle);



                String date = tv_date.getText().toString();
                String title = tv_title.getText().toString();


                pfListAdapter.addItems(ContextCompat.getDrawable(getApplicationContext(), R.drawable.logo), date, title);

                pf_List.setAdapter(pfListAdapter);
            }
        });

    }
}

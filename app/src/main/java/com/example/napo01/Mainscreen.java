package com.example.napo01;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.napo01.databinding.ActivityMainscreenBinding;
import com.google.android.material.navigation.NavigationView;


public class Mainscreen extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainscreenBinding binding;


    private ImageButton img_pfbtn;
    private TextView tv_mainInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_pf_add, R.id.nav_pf_list, R.id.nav_setting, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mainscreen);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id==R.id.nav_home){
                    Intent intent = new Intent(getApplicationContext(),Mainscreen.class);
                    startActivity(intent);
                } else if (id==R.id.nav_pf_add){
                    Intent intent = new Intent(getApplicationContext(), EditCareer.class);
                    startActivity(intent);
                } else if (id==R.id.nav_pf_list){
                    Intent intent = new Intent(getApplicationContext(), PfList_Main.class);
                    startActivity(intent);
                } else if (id==R.id.nav_logout){
                    Intent intent = new Intent(getApplicationContext(), Team_Login.class);
                    startActivity(intent);
                } else if (id==R.id.nav_setting){
                    Intent intent = new Intent(getApplicationContext(), SettingPage.class);
                    startActivity(intent);
                }

                return true;
            };


        });
        img_pfbtn = findViewById(R.id.img_pfbtn);
        img_pfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Team_Login.class);
                startActivity(intent);
            }
        });

//        tv_mainInfo = findViewById(R.id.tv_mainInfo);
//        Intent intent = getIntent();
//        String name = intent.getStringExtra(name);
//        String phone = intent.getStringExtra(phone);
//        tv_mainInfo.setText(name+"/"+phone);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainscreen, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mainscreen);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
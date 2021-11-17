package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageButton profile;
    public static final String lokasi_postingan_key = "lokasi";
    ImageView btnPrayaTengah,btnRinjani,btnSegaraAnak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiview();

        profile = findViewById(R.id.btnProfile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inisialisasiview(){
        btnPrayaTengah = findViewById(R.id.btnPrayaTengah);
        btnRinjani = findViewById(R.id.btnRinjani);
        btnSegaraAnak = findViewById(R.id.btnSegaraAnak);
        btnPrayaTengah.setOnClickListener(view -> bukaPostinganActivity("Praya Tengah"));
        btnRinjani.setOnClickListener(view -> bukaPostinganActivity("Rinjani"));
        btnSegaraAnak.setOnClickListener(view -> bukaPostinganActivity("Segara Anak"));
    }

    private void bukaPostinganActivity(String lokasi){
        Intent intent = new Intent(MainActivity.this, PostingansActivity.class);
        intent.putExtra(lokasi_postingan_key, lokasi);
        startActivity(intent);
    }


}
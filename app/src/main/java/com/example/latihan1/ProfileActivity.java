package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {
    ImageButton home,akuns;
    public static final String lokasi_postingan_key = "lokasi";
    ImageView btnPrayaTengah,btnRinjani,btnSegaraAnak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        inisialisasiview();

        home = findViewById(R.id.btnHome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        akuns = findViewById(R.id.btnAkun);

        akuns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AkunsActivity.class);
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
        Intent intent = new Intent(this, PostingansActivity.class);
        intent.putExtra(lokasi_postingan_key, lokasi);
        startActivity(intent);
    }
}
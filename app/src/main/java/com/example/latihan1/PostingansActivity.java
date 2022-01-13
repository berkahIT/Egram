package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latihan1.model.PostingansStruktur;

import java.util.List;

public class PostingansActivity extends AppCompatActivity {

    List<PostingansStruktur> PostingansStrukturs;
    ImageButton profile,home;
    int indeksTampil = 0;
    String lokasi;
    ImageButton btnPertama,btnSebelumnya,btnBerikutnya,btnTerakhir;
    TextView txtAkun,txtTgl,txtLike,txtLokasi;
    ImageView imgPostingan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_status);

        Intent intent = getIntent();
        lokasi = intent.getStringExtra(ProfileActivity.lokasi_postingan_key);
        PostingansStrukturs = PostinganData.getPostingansByLokasi(this, lokasi);
        profile = findViewById(R.id.btnProfile);
        home = findViewById(R.id.btnHome);
        inisialisasiView();
        tampilkanProfile();

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostingansActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostingansActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> postinganPertama());
        btnTerakhir.setOnClickListener(view -> postinganTerakhir());
        btnSebelumnya.setOnClickListener(view -> postinganebelumnya());
        btnBerikutnya.setOnClickListener(view -> postinganBerikutnya());

        txtAkun = findViewById(R.id.txtAkun);
        txtLokasi = findViewById(R.id.txtLokasi);
        txtLike = findViewById(R.id.txtLike);
        txtTgl = findViewById(R.id.txtTgl);

        imgPostingan = findViewById(R.id.imgPostingan);
    }

    private void tampilkanProfile() {
        PostingansStruktur p = PostingansStrukturs.get(indeksTampil);
        txtAkun.setText(p.getNama_akun());
        txtLokasi.setText(p.getLokasi());
        txtLike.setText(p.getJumlah_suka());
        txtTgl.setText(p.getTanggal_upload());
        imgPostingan.setImageDrawable(this.getDrawable(p.getDrawableRes()));
    }

    private void postinganPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,getString(R.string.posisi_pertama),Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfile();
        }
    }

    private void postinganTerakhir() {
        int posAkhir = PostingansStrukturs.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,getString(R.string.posisi_terakhir),Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfile();
        }
    }

    private void postinganBerikutnya() {
        if (indeksTampil == PostingansStrukturs.size() - 1) {
            Toast.makeText(this,getString(R.string.posisi_terakhir),Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfile();
        }
    }

    private void postinganebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,getString(R.string.posisi_pertama),Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfile();
        }
    }

}
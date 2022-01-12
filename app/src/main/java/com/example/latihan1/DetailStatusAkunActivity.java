package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.latihan1.model.PostingansStruktur;

public class DetailStatusAkunActivity extends AppCompatActivity {
    PostingansStruktur postingansStruktur;
    TextView txtAkun,txtLokasi,txtLike,txtTgl;
    ImageView imgPostingan;
    ImageButton home,profile;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_status_akun);
        Intent intent = getIntent();
        postingansStruktur = (PostingansStruktur) intent.getSerializableExtra(DaftarStatusActivity.STATUS_TERPILIH);
        inisialisasiView();
        tampilkanDetailStatusAkun(postingansStruktur);

        profile = findViewById(R.id.btnProfile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailStatusAkunActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inisialisasiView(){
        txtAkun = findViewById(R.id.txtAkun);
        txtLokasi = findViewById(R.id.txtLokasi);
        txtLike = findViewById(R.id.txtLike);
        txtTgl = findViewById(R.id.txtTgl);
        imgPostingan = findViewById(R.id.imgPostingan);
    }

    private void tampilkanDetailStatusAkun(PostingansStruktur postingansStruktur){
        Log.d("Detail Status Akun","Menampilkan"+postingansStruktur.getDrawableRes());
        txtAkun.setText(postingansStruktur.getNama_akun());
        txtLokasi.setText(postingansStruktur.getLokasi());
        txtLike.setText(postingansStruktur.getJumlah_suka());
        txtTgl.setText(postingansStruktur.getTanggal_upload());
        imgPostingan.setImageDrawable(this.getDrawable(postingansStruktur.getDrawableRes()));
    }
}
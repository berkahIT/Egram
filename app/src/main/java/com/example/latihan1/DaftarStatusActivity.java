package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.latihan1.model.PostingansStruktur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DaftarStatusActivity extends AppCompatActivity {
    public final static String STATUS_TERPILIH = "status_obj_key";
    ImageButton profile;
    List<PostingansStruktur> PostingansStrukturs = new ArrayList<>();
    ListView listView;
    String lokasi;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
//        Intent intent = getIntent();
//        lokasi = intent.getStringExtra(MainActivity.lokasi_postingan_key);
        PostingansStrukturs = PostinganData.getAllPostingans(this);
        setupListView();

        profile = findViewById(R.id.btnProfile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarStatusActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupListView(){
        listView = findViewById(R.id.listview_status);
        DaftarStatusAdapter adapter = new DaftarStatusAdapter(DaftarStatusActivity.this,PostingansStrukturs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClick);
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            PostingansStruktur terpilih = PostingansStrukturs.get(position);
            bukaStatus(terpilih);
        }
    };

    private void bukaStatus(PostingansStruktur statusTerpilih){
        Log.d("MAIN","Buka activity status");
        Intent intent = new Intent(this, DetailStatusAkunActivity.class);
        intent.putExtra(STATUS_TERPILIH, statusTerpilih);
        startActivity(intent);
    }
}
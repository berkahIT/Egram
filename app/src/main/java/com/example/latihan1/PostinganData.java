package com.example.latihan1;

import android.content.Context;

import com.example.latihan1.model.PostingansStruktur;
import com.example.latihan1.model.PrayaTengah;
import com.example.latihan1.model.Rinjani;
import com.example.latihan1.model.SegaraAnak;

import java.util.ArrayList;
import java.util.List;

public class PostinganData {
    private static List<PostingansStruktur> postingansStrukturList = new ArrayList<>();

    private static List<PrayaTengah> initDataPrayaTengah(){
        List<PrayaTengah> postingansList =  new ArrayList<>();
        postingansList.add(new PrayaTengah("Edwin","17 September 2021","9990",R.drawable.pembina_lks));
        postingansList.add(new PrayaTengah("Edwin","09 September 2021","880",R.drawable.pembina_lks2));
        postingansList.add(new PrayaTengah("Edwin","20 September 2021","920",R.drawable.pembina_lks3));
        return postingansList;
    }

    private static List<SegaraAnak> initDataSegaraAnak(){
        List<SegaraAnak> postingansList =  new ArrayList<>();
        postingansList.add(new SegaraAnak("Edwin","29 September 2021","120",R.drawable.segara_anak));
        postingansList.add(new SegaraAnak("Edwin","07 September 2021","330",R.drawable.segara_anak2));
        postingansList.add(new SegaraAnak("Edwin","11 September 2021","910",R.drawable.segara_anak3));
        return postingansList;
    }

    private static List<Rinjani> initDataRinjani(){
        List<Rinjani> postingansList =  new ArrayList<>();
        postingansList.add(new Rinjani("Edwin","24 September 2021","9230",R.drawable.rinjani_segara_anak));
        postingansList.add(new Rinjani("Edwin","22 September 2021","310",R.drawable.rinjani_segara_anak2));
        postingansList.add(new Rinjani("Edwin","21 September 2021","3210",R.drawable.rinjani_segara_anak3));
        return postingansList;
    }

    private static void initAllPostingans(){
        postingansStrukturList.addAll(initDataPrayaTengah());
        postingansStrukturList.addAll(initDataSegaraAnak());
        postingansStrukturList.addAll(initDataRinjani());
    }

    public static List<PostingansStruktur> getAllPostingans(){
        if(postingansStrukturList.size() == 0){
            initAllPostingans();
        }
        return postingansStrukturList;
    }

    public static List<PostingansStruktur> getPostingansByLokasi(Context ctx, String lokasi){
        List<PostingansStruktur> PostinganByLokasi = new ArrayList<>();
        if(postingansStrukturList.size() == 0){
            initAllPostingans();
        }
        for (PostingansStruktur p : postingansStrukturList){
            if(p.getLokasi().equals(lokasi)){
                PostinganByLokasi.add(p);
            }
        }
        return PostinganByLokasi;
    }

}

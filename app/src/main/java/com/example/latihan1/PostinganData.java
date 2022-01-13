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

    private static List<PrayaTengah> initDataPrayaTengah(Context ctx){
        List<PrayaTengah> postingansList =  new ArrayList<>();
        postingansList.add(new PrayaTengah("Edwin",ctx.getString(R.string.tgl_praya1),"9990",R.drawable.pembina_lks));
        postingansList.add(new PrayaTengah("Edwin",ctx.getString(R.string.tgl_praya2),"880",R.drawable.pembina_lks2));
        postingansList.add(new PrayaTengah("Edwin",ctx.getString(R.string.tgl_praya3),"920",R.drawable.pembina_lks3));
        return postingansList;
    }

    private static List<SegaraAnak> initDataSegaraAnak(Context ctx){
        List<SegaraAnak> postingansList =  new ArrayList<>();
        postingansList.add(new SegaraAnak("Edwin",ctx.getString(R.string.tgl_segara1),"120",R.drawable.segara_anak));
        postingansList.add(new SegaraAnak("Edwin",ctx.getString(R.string.tgl_segara2),"330",R.drawable.segara_anak2));
        postingansList.add(new SegaraAnak("Edwin",ctx.getString(R.string.tgl_segara3),"910",R.drawable.segara_anak3));
        return postingansList;
    }

    private static List<Rinjani> initDataRinjani(Context ctx){
        List<Rinjani> postingansList =  new ArrayList<>();
        postingansList.add(new Rinjani("Edwin",ctx.getString(R.string.tgl_rinjani1),"9230",R.drawable.rinjani_segara_anak));
        postingansList.add(new Rinjani("Edwin",ctx.getString(R.string.tgl_rinjani2),"310",R.drawable.rinjani_segara_anak2));
        postingansList.add(new Rinjani("Edwin",ctx.getString(R.string.tgl_rinjani3),"3210",R.drawable.rinjani_segara_anak3));
        return postingansList;
    }

    private static void initAllPostingans(Context ctx){
        postingansStrukturList.addAll(initDataPrayaTengah(ctx));
        postingansStrukturList.addAll(initDataSegaraAnak(ctx));
        postingansStrukturList.addAll(initDataRinjani(ctx));
    }

    public static List<PostingansStruktur> getAllPostingans(Context ctx){
        if(postingansStrukturList.size() == 0){
            initAllPostingans(ctx);
        }
        return postingansStrukturList;
    }

    public static List<PostingansStruktur> getPostingansByLokasi(Context ctx, String lokasi){
        List<PostingansStruktur> PostinganByLokasi = new ArrayList<>();
        if(postingansStrukturList.size() == 0){
            initAllPostingans(ctx);
        }
        for (PostingansStruktur p : postingansStrukturList){
            if(p.getLokasi().equals(lokasi)){
                PostinganByLokasi.add(p);
            }
        }
        return PostinganByLokasi;
    }

}

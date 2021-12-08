package com.example.latihan1;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.latihan1.model.PostingansStruktur;

import java.util.List;

public class DaftarStatusAdapter extends ArrayAdapter<PostingansStruktur> {
    Context context;

    public DaftarStatusAdapter(Context context, List<PostingansStruktur> PostingansStrukturs){
        super(context, R.layout.row_daftar_status, PostingansStrukturs);
        this.context = context;
    }

    private  static  class ViewHolder{
    TextView txtNamaAkun;
    ImageView btnGambar;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent){
        PostingansStruktur postingansStruktur = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_status,parent,false);
            viewHolder.txtNamaAkun = convertView.findViewById(R.id.txtNamaAkun);
            viewHolder.btnGambar = convertView.findViewById(R.id.btnGambar);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)  convertView.getTag();
        }

        viewHolder.txtNamaAkun.setText(postingansStruktur.getNama_akun());
        viewHolder.btnGambar.setImageDrawable(context.getDrawable(postingansStruktur.getDrawableRes()));
        return  convertView;
    }

}

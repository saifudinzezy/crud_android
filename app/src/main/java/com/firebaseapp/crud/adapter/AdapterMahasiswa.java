package com.firebaseapp.crud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebaseapp.crud.Form;
import com.firebaseapp.crud.R;
import com.firebaseapp.crud.helper.SendData;
import com.firebaseapp.crud.model.Mahasiswa;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.ViewHolder> {

    private List<Mahasiswa> list;
    private Context context;

    public AdapterMahasiswa(List<Mahasiswa> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ln.setOnClickListener(v -> {
            SendData.sendDataToAcitivity(context, Form.class, list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nama)
        TextView nama;
        @BindView(R.id.tgl)
        TextView tgl;
        @BindView(R.id.alamat)
        TextView alamat;
        @BindView(R.id.ln)
        LinearLayout ln;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}


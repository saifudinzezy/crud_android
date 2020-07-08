package com.firebaseapp.crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebaseapp.crud.adapter.AdapterMahasiswa;
import com.firebaseapp.crud.helper.ListMahasiswa;
import com.firebaseapp.crud.model.Mahasiswa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.loading)
    ProgressBar loading;
    ListMahasiswa mahasiswa;
    AdapterMahasiswa adapterMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data Mahasiswa");
        mahasiswa = new ListMahasiswa();
        initUI();
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        startActivity(new Intent(this, Form.class));
    }

    private void initUI(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        mahasiswa.addListMahasiswa();
        adapterMahasiswa = new AdapterMahasiswa(mahasiswa.getMahasiswaList(), this);
        loading.setVisibility(View.GONE);
        rv.setAdapter(adapterMahasiswa);
    }
}
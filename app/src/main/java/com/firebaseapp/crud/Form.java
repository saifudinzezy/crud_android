package com.firebaseapp.crud;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebaseapp.crud.model.Mahasiswa;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.firebaseapp.crud.helper.SendData.KEY;

public class Form extends AppCompatActivity {

    @BindView(R.id.nama)
    TextInputEditText nama;
    @BindView(R.id.tgl)
    TextInputEditText tgl;
    @BindView(R.id.alamat)
    TextInputEditText alamat;
    @BindView(R.id.btn_simpan)
    Button btnSimpan;
    Mahasiswa mahasiswa;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getDataFromAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (flag) getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_delete:
                Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getDataFromAdapter(){
        mahasiswa = getIntent().getParcelableExtra(KEY);
        if (mahasiswa != null ){
            getSupportActionBar().setTitle("Update Mahasiswa");
            flag = true;
            btnSimpan.setText("Update");
            //init
            nama.setText(mahasiswa.getNama());
        }else {
            flag = false;
            getSupportActionBar().setTitle("Tambah Mahasiswa");
        }
    }
}
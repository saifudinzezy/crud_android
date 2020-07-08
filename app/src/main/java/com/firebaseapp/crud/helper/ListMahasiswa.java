package com.firebaseapp.crud.helper;

import com.firebaseapp.crud.model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;

public class ListMahasiswa {
    private List<Mahasiswa> mahasiswaList;

    public ListMahasiswa() {
        mahasiswaList = new ArrayList<>();
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(Mahasiswa angsuran) {
        mahasiswaList.add(angsuran);
    }

    public void addListMahasiswa(){
        for (int i = 0; i < 11; i++) {
            try{
                setMahasiswaList(new Mahasiswa("Nama per : "+(1+0), "23, Juli 200"+(1+0),
                        "Alamat"+(1+0)));
            } catch(NumberFormatException ex){ // handle your exception
            }
        }
    }
}

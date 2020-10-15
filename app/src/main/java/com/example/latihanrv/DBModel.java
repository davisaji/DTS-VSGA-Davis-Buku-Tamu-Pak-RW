package com.example.latihanrv;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Random;

public class DBModel {
    private Context context;
    private DBHelper db;

    public DBModel(Context context) {
        this.context = context;
        this.db = new DBHelper(this.context);
    }

    public void tambahPengunjung(EntitiTabel E){
        String q = "INSERT INTO pengunjung (nama,nik, nomor,email,tanggal,asal,tujuan) VALUES (" +
                "'"+E.getNama()+"'," +
                "'"+E.getNik()+"'," +
                "'"+E.getNomor()+"'," +
                "'"+E.getEmail()+"'," +
                "DATE('now')," +
                "'"+E.getAsal()+"'," +
                "'"+E.getTujuan()+"'" +
                ")";
        //Lempar ke DB
        this.db.tulisData(q);
    }

    public ArrayList<EntitiTabel> ambilSemuaPengunjung(){
        String q = "SELECT * FROM pengunjung ORDER BY ID DESC";
        Cursor c = this.db.bacaData(q);
        //Tampung data
        ArrayList<EntitiTabel> hasil = new ArrayList<>();
        if(c.getCount()>0){
            c.moveToFirst();
            do {
                EntitiTabel E = new EntitiTabel();
                E.setId(c.getInt(0));
                E.setNama(c.getString(1));
                E.setNik(c.getString(2));
                E.setNomor(c.getString(3));
                E.setEmail(c.getString(4));
                E.setTanggal(c.getString(5));
                E.setAsal(c.getString(6));
                E.setTujuan(c.getString(7));
                hasil.add(E);
            }while (c.moveToNext());
        }
        return hasil;
    }
    public ArrayList<EntitiTabel> caripengunjung(String nama){
        String q = "SELECT * FROM pengunjung WHERE nama LIKE '%"+nama+"%' ORDER BY ID DESC";
        Cursor c = this.db.bacaData(q);
        //Tampung data
        ArrayList<EntitiTabel> hasil = new ArrayList<>();
        if(c.getCount()>0){
            c.moveToFirst();
            do {
                EntitiTabel E = new EntitiTabel();
                E.setId(c.getInt(0));
                E.setNama(c.getString(1));
                E.setNik(c.getString(2));
                E.setNomor(c.getString(3));
                E.setEmail(c.getString(4));
                E.setTanggal(c.getString(5));
                E.setAsal(c.getString(6));
                E.setTujuan(c.getString(7));
                hasil.add(E);
            }while (c.moveToNext());
        }
        return hasil;
    }
    public EntitiTabel pilihSatu(int id){
        String q = "SELECT * FROM pengunjung WHERE id='"+id+"'";
        Cursor c = db.bacaData(q);
        if (c.getCount()>0){
            c.moveToFirst();
            EntitiTabel E= new EntitiTabel();
            E.setId(c.getInt(0));
            E.setNama(c.getString(1));
            E.setNik(c.getString(2));
            E.setNomor(c.getString(3));
            E.setEmail(c.getString(4));
            E.setTanggal(c.getString(5));
            E.setAsal(c.getString(6));
            E.setTujuan(c.getString(7));
            return E;
        }
        return null;
    }
}

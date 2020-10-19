package com.example.latihanrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterRV.OnContactClickListener{
    public RecyclerView rv;
    private DBModel dbm;
    private EditText cari;
    private ArrayList<EntitiTabel> semuaPengunjung;
    public static ArrayList<ModelRV> listPengunjung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rvlayout);
        cari = findViewById(R.id.edtCari);

        ambildata();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ambildata();
    }

    public void ambildata(){
        //-----------------------------
        dbm = new DBModel(this);
        semuaPengunjung = dbm.ambilSemuaPengunjung();
        if ( listPengunjung == null ){
            listPengunjung = new ArrayList<>();
            //listPengunjung.add(new ModelRV(1,"agus","nik","081","dvs@gmail","11/10","mojokerto","tikik bu tejo"));
        }
        listPengunjung.clear();
        for (EntitiTabel E : semuaPengunjung){
            listPengunjung.add(new ModelRV(
                    E.getId(),
                    E.getNama(),
                    E.getNik(),
                    E.getNomor(),
                    E.getEmail(),
                    E.getTanggal(),
                    E.getAsal(),
                    E.getTujuan()
            ));
        }
        //-----------------------------
        AdapterRV AC = new AdapterRV(listPengunjung);
        AC.setListener(this);
        rv.setAdapter(AC);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
    @Override
    public void onClick(View view, int position) {
        ModelRV contact = listPengunjung.get(position);
        Intent i = new  Intent(MainActivity.this, DetailPengunjung.class);
        i.putExtra("ID",contact.getId());
        startActivity(i);
        //Toast.makeText(this,Integer.toString(contact.getId()), Toast.LENGTH_LONG).show();
    }

    public void tambahData(View view) {
        Intent i = new  Intent(MainActivity.this, TambahPengunjung.class);
        startActivity(i);
    }

    public void Cari(View view) {
        //-----------------------------
        dbm = new DBModel(this);
        semuaPengunjung = dbm.caripengunjung(cari.getText().toString().trim());
        if ( listPengunjung == null ){
            listPengunjung = new ArrayList<>();
            //listPengunjung.add(new ModelRV(1,"agus","nik","081","dvs@gmail","11/10","mojokerto","tikik bu tejo"));
        }
        listPengunjung.clear();
        for (EntitiTabel E : semuaPengunjung){
            listPengunjung.add(new ModelRV(
                    E.getId(),
                    E.getNama(),
                    E.getNik(),
                    E.getNomor(),
                    E.getEmail(),
                    E.getTanggal(),
                    E.getAsal(),
                    E.getTujuan()
            ));
        }
        //-----------------------------
        AdapterRV AC = new AdapterRV(listPengunjung);
        AC.setListener(this);
        rv.setAdapter(AC);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void resetSearch(View view) {
        ambildata();
    }
}
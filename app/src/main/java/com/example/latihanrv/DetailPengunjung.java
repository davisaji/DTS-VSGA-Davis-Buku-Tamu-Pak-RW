package com.example.latihanrv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailPengunjung extends AppCompatActivity {
    private TextView nama,nik,nomor,email,asal,tujuan,tanggal;
    private String Email,Hp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengunjung);
        nama = findViewById(R.id.txtNama);
        nik = findViewById(R.id.txtNik);
        nomor = findViewById(R.id.txtNomor);
        email = findViewById(R.id.txtEmail);
        asal = findViewById(R.id.txtAlamat);
        tujuan = findViewById(R.id.txtTujuan);
        tanggal = findViewById(R.id.txtTanggal);
        Intent i = getIntent();
        int id = i.getIntExtra("ID",-1);
        if (id>=1){
            DBModel dbm = new DBModel(this);
            EntitiTabel E = dbm.pilihSatu(id);
            nama.setText(E.getNama());
            nik.setText(E.getNik());
            nomor.setText(E.getNomor());
            email.setText(E.getEmail());
            asal.setText(E.getAsal());
            tujuan.setText(E.getTujuan());
            tanggal.setText(E.getTanggal());
            Email = E.getEmail();
            Hp = E.getNomor();
        }else {
            Toast.makeText(this,"ID tidak ditemukan",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public void batal(View view) {
        finish();
    }

    public void KirimEmail(View view) {
        Toast.makeText(view.getContext(), "Mengirim Surel ke "+Email,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{Email});
        intent.putExtra(Intent.EXTRA_SUBJECT, "RW 02 Rogotrunan");
        intent.putExtra(Intent.EXTRA_TEXT, "Selamat Sore,");
        startActivity(intent.createChooser(intent, "Penting"));
    }

    public void panggilanWA(View view) {
        String url = "https://api.whatsapp.com/send?phone="+Hp;
        Toast.makeText(view.getContext(), "Menghubungi "+Hp,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
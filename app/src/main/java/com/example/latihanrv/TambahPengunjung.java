package com.example.latihanrv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TambahPengunjung extends AppCompatActivity {
    EditText nama,nik,nomor,email,asal,tujuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengunjung);
        nama = findViewById(R.id.edtNama);
        nik = findViewById(R.id.edtNik);
        nomor = findViewById(R.id.edtNomor);
        email = findViewById(R.id.edtEmail);
        asal = findViewById(R.id.edtAsal);
        tujuan = findViewById(R.id.edtTujuan);

    }

    public void batal(View view) {
        finish();
    }

    public void simpan(View view) {
        String Message;
        if (TextUtils.isEmpty(nama.getText().toString().trim())){
            Message = "Nama Harus Diisi";
        }else if (TextUtils.isEmpty(nik.getText().toString().trim())){
            Message = "Nik Harus Diisi";
        }else if (TextUtils.isEmpty(nomor.getText().toString().trim())){
            Message = "Nomor Harus Diisi";
        }else if (TextUtils.isEmpty(email.getText().toString().trim())){
            Message = "Email Harus Diisi";
        }else if (!isValidEmail(email.getText().toString().trim())){
            Message = "Format Email Salah";
        }else if (TextUtils.isEmpty(asal.getText().toString().trim())){
            Message = "Asal pengunjung Harus Diisi";
        }else if (TextUtils.isEmpty(tujuan.getText().toString().trim())){
            Message = "Tujuan Pengunjung Harus Diisi";
        }else{
            EntitiTabel ET = new EntitiTabel();
            ET.setNama(nama.getText().toString().trim());
            ET.setNik(nik.getText().toString().trim());
            ET.setNomor(nomor.getText().toString().trim());
            ET.setEmail(email.getText().toString().trim());
            ET.setAsal(asal.getText().toString().trim());
            ET.setTujuan(tujuan.getText().toString().trim());
            DBModel mp = new DBModel(this);
            mp.tambahPengunjung(ET);
            Message = "Data berhasil disimpan";
            finish();
        }
        Toast.makeText(this, Message,Toast.LENGTH_LONG).show();
    }
    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
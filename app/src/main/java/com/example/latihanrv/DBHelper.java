package com.example.latihanrv;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "CatatanWajibLapor.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Kode Membuat Tabel
        String q = "CREATE TABLE pengunjung (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nama VARCHAR(50)," +
                "nik VARCGH(16), " +
                "nomor VARCHAR(20), " +
                "email VARCHAR(20), " +
                "tanggal TEXT, " +
                "asal TEXT, " +
                "tujuan TEXT);";
        sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //jika terjadi perubahan database
    }
    //Menulis data ke database
    public void tulisData(String q){
        SQLiteDatabase sql = this.getWritableDatabase();
        sql.execSQL(q);
    }
    //Membaca data ke database
    public Cursor bacaData(String q){
        SQLiteDatabase sql = this.getReadableDatabase();
        return sql.rawQuery(q,null);
    }
}

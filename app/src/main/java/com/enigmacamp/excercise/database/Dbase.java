package com.enigmacamp.excercise.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Dbase {
    private SQLiteDatabase db;
    private final Context konteks;
    private  final DBHelper dbHelper;

    public Dbase(Context k) {
        konteks = k;
        dbHelper = new DBHelper(konteks, Konstanta.NAMA_DB,
                null, Konstanta.VERSI_DB);
    }

    public void open() throws SQLException {
        try {
            db = dbHelper.getWritableDatabase();
        }
        catch (SQLException e) {
            db = dbHelper.getReadableDatabase();
        }
    }

    public void close() {
        db.close();
    }

    public long insertData(String nama, boolean gender, String tanggal) {
        try {
            ContentValues dataBaru = new ContentValues();
            dataBaru.put(Konstanta.NAMA_ARTIS, nama);
            dataBaru.put(Konstanta.GENDER_ARTIS, gender);
            dataBaru.put(Konstanta.TGLLAHIR_ARTIS, tanggal);

            return db.insert(Konstanta.NAMA_TABEL, null, dataBaru);
        }
        catch (SQLException e) {
            return -1;
        }
    }

    public boolean deleteData(long kunci) {
        return db.delete(Konstanta.NAMA_TABEL,
                Konstanta.ID_ARTIS + "=" + kunci, null) > 0;
    }

    public Cursor getAllData() {
        return db.query(Konstanta.NAMA_TABEL,
                new String[] {Konstanta.ID_ARTIS,
                        Konstanta.NAMA_ARTIS,
                        Konstanta.GENDER_ARTIS,
                        Konstanta.TGLLAHIR_ARTIS},
                null, null, null, null, null);
    }

    public Cursor getName(String nama) {
        Cursor c = db.query(Konstanta.NAMA_TABEL,
                new String[] {Konstanta.ID_ARTIS,
                        Konstanta.NAMA_ARTIS,
                        Konstanta.GENDER_ARTIS,
                        Konstanta.TGLLAHIR_ARTIS},
                Konstanta.NAMA_ARTIS + " LIKE '%" + nama + "%'",
                null, null,  null, null);
        if (c != null)
            c.moveToFirst();
        return c;
    }

    public Cursor getData(long kunci) {
        Cursor c = db.query(Konstanta.NAMA_TABEL,
                new String[] {Konstanta.NAMA_ARTIS,
                              Konstanta.GENDER_ARTIS,
                              Konstanta.TGLLAHIR_ARTIS},
                        Konstanta.ID_ARTIS + "=" + kunci,
                    null, null, null, null);
        if (c != null)
            c.moveToFirst();
        return c;
    }

    public boolean updateData(long kunci, String nama, boolean gender, String tglLahir) {
        ContentValues cv = new ContentValues();
        cv.put(Konstanta.NAMA_ARTIS, nama);
        cv.put(Konstanta.GENDER_ARTIS, gender);
        cv.put(Konstanta.TGLLAHIR_ARTIS, tglLahir);

        return db.update(Konstanta.NAMA_TABEL, cv, Konstanta.ID_ARTIS +
                "=" + kunci, null) > 0;
    }
}

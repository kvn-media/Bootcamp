package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BacaKontak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_kontak);

        ListView listViewKontak = (ListView) findViewById(R.id.listViewKontak);

        Cursor cKontak = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                null, null, null);
        ArrayList<String> daftar = new ArrayList();

        if (cKontak.moveToFirst()) {
            do {
                String idKontak = cKontak.getString(
                        cKontak.getColumnIndex(ContactsContract.Contacts._ID));
                String nama = cKontak.getString(
                        cKontak.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                int punyaTelepon = cKontak.getInt(
                        cKontak.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                String noTelepon = "<Tanpa Telepon>";

                if (punyaTelepon == 1) {
                    Cursor cTelepon = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" +
                                    idKontak, null, null);

                    cTelepon.moveToFirst();
                    noTelepon = cTelepon.getString(
                            cTelepon.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    cTelepon.close();
                }

                daftar.add(nama + " : " + noTelepon);
            }while (cKontak.moveToNext());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, daftar);
        listViewKontak.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
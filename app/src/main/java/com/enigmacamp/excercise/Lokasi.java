package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class Lokasi extends AppCompatActivity implements LocationListener {

    TextView textViewLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi);

        textViewLokasi = (TextView) findViewById(R.id.textViewLokasi);
        textViewLokasi.setText("");

        LocationManager manajerLokasi = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        manajerLokasi.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000, 2, this);
    }

    @Override
    public void onLocationChanged(Location lokasi) {
        if (lokasi != null)
            textViewLokasi.setText(
                    "Posisi\n" +
                            "Bujur: " + String.valueOf(lokasi.getLongitude()) +
                            "\n" +
                            "Lintang: " + String.valueOf(lokasi.getLatitude()));
    }

    @Override
    public void onProviderDisabled(String penyedia) {

    }

    @Override
    public void onProviderEnabled(String penyedia) {

    }

    @Override
    public void onStatusChanged(String penyedia, int status, Bundle ekstra) {

    }
}
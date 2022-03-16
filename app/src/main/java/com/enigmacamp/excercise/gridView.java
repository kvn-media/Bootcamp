package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class gridView extends AppCompatActivity {

    Integer[] IDGambar = {
            R.mipmap.ic_launcher_part2,
            R.mipmap.ic_launcher_part3,
            R.mipmap.ic_launcher_part4,
            R.mipmap.ic_launcher_part5,
            R.mipmap.ic_launcher_part6,
            R.mipmap.ic_launcher_part7,
            R.mipmap.ic_launcher_part8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = (GridView) findViewById(R.id.GridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getApplication(),
                        "Gambar manga" + (posisi + 1) +
                        " telah Anda pilih", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context konteks;

        public ImageAdapter(Context c) {
            konteks = c;
        }

        public int getCount() {
            return IDGambar.length;
        }

        public Object getItem(int posisi) {
            return posisi;
        }

        public long getItemId(int posisi) {
            return posisi;
        }

        public View getView(int posisi, View v, ViewGroup ortu) {
            ImageView imageView;
            if (v == null) {
                imageView = new ImageView(konteks);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(210, 210));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(5, 5, 5, 5);
            }else
                imageView = (ImageView) v;

            imageView.setImageResource(IDGambar[posisi]);
            return imageView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
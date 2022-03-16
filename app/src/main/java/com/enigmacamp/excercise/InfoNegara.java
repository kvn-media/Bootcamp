package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InfoNegara extends AppCompatActivity {

    static final public Integer[] ID_BENDERA = {
            R.drawable.ic_banner_foreground;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_negara);

        ArrayList<RincianData> listData = perolehData();

        final ListView listViewData = (ListView) findViewById(R.id.listViewData);
        AdapterDaftarItem adapter = new AdapterDaftarItem(this, listData);
        listViewData.setAdapter(adapter);

        listViewData.setOnClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> a,
                                    View v, int position, long id) {
                Object terpilih = listViewData.getItemAtPosition(position);
                RincianData rincian = (RincianData) terpilih;

                Intent intent = new Intent(InfoNegara.this, InfoDetail.class );

                Bundle data = new Bundle();

                data.putString("Negara", rincian.perolehNegara());
                data.putString("Ibukota", rincian.perolehIbukota());
                data.putString("Benua", rincian.perolehBenua());
                data.putString("Berdiri", rincian.perolehBerdiri());
                data.putString("Matauang", rincian.perolehMatauang());
                data.putDouble("Luas", rincian.perolehLuas());
                data.putInt("Bendera", rincian.perolehIdBendera());

                intent.putExtras(data);
                startActivityForResult(intent, 1);
        }
        });
    }

    private ArrayList<RincianData> perolehData() {
        hasil = new ArrayList<RincianData>();

        RincianData data;

        data = new RincianData("Austria", "Vienna", "Eropa",
                                "01-01-1156", "Euro (EUR)", 83856, 1);
        hasil.add(data);

        return(hasil);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        }
}
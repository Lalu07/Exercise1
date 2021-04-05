package firdaus.rizkika.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class dataKontak extends AppCompatActivity {

    String[] listNama;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kontak);

        listNama = new String[]{"Lalu","Muhammad","Rizkika","Firdaus","Yusuf","Kiki","Firja"};
        ArrayAdapter<String> kontakAdapter = new ArrayAdapter<String>(dataKontak.this, android.R.layout.simple_expandable_list_item_1, listNama);

        list = findViewById(R.id.listKontak);
        list.setAdapter(kontakAdapter);

    }
}
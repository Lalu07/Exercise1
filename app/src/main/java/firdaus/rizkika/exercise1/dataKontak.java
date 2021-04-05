package firdaus.rizkika.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class dataKontak extends AppCompatActivity {

    String[] listNama;
    ListView list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kontak);
        searchView = findViewById(R.id.searchbox);

        listNama = new String[]{"Lalu","Muhammad","Rizkika","Firdaus","Yusuf","Kiki","Firja"};
        ArrayAdapter<String> kontakAdapter = new ArrayAdapter<String>(dataKontak.this, android.R.layout.simple_expandable_list_item_1, listNama);

        list = findViewById(R.id.listKontak);
        list.setAdapter(kontakAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                kontakAdapter.getFilter().filter(s);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                kontakAdapter.getFilter().filter(s);

                return false;
            }
        });
    }
}
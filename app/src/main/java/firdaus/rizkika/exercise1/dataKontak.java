package firdaus.rizkika.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class dataKontak extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    String[] listNama;
    private ListView list;
    private ListViewAdapter adapter;
    Bundle bundle = new Bundle();
    Intent intent;
    SearchView searchView;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kontak);

        searchView = findViewById(R.id.searchbox);

        listNama = new String[]{"Lalu","Muhammad","Rizkika","Firdaus","Yusuf","Kiki","Firja"};
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();
        for (int i = 0; i < listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a",nama.trim());
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(dataKontak.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });

        //Bagian search
        ArrayAdapter<String> kontakAdapter = new ArrayAdapter<String>(dataKontak.this, android.R.layout.simple_expandable_list_item_1, listNama);
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
        //search sampai sini
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnumber:
                Toast.makeText(getApplicationContext(),"No telepon",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
package firdaus.rizkika.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    TextView newNama, newNomor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        newNama = findViewById(R.id.tvNamaKontak);
        newNomor = findViewById(R.id.tvNotel);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        switch (nama){
            case "Lalu":
                newNama.setText("Lalu Rizkika");
                newNomor.setText("2017001");
                break;
            case "Muhammad" :
                newNama.setText("Muhammad Rizkika");
                newNomor.setText("2017002");
                break;
            case "Rizkika" :
                newNama.setText("Rizkika F.");
                newNomor.setText("2017003");
                break;
            case "Firdaus" :
                newNama.setText("Firdaus Y.");
                newNomor.setText("2017004");
                break;
            case "Yusuf" :
                newNama.setText("Yusuf G.");
                newNomor.setText("2017005");
                break;
            case "Kiki":
                newNama.setText("Kiki Lalu");
                newNomor.setText("2017006");
                break;
            case "Firja" :
                newNama.setText("Firja M.");
                newNomor.setText("2017007");
                break;
        }
    }
}
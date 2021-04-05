package firdaus.rizkika.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Nama, Pass;
    Button Masuk;
    String nama,pass;
    String email = "admin@mail.com";
    String password = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nama = findViewById(R.id.EdNama);
        Pass = findViewById(R.id.EdPass);
        Masuk = findViewById(R.id.LoginBtn);

        Masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { pindah(); }
        });


    }

    public void pindah()
    {
        nama = Nama.getText().toString();
        pass = Pass.getText().toString();

        if (nama.equals(email) && pass.equals(password)){
            Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this,dataKontak.class);
            startActivity(i);
        }
        else if(nama.isEmpty()){
            Toast.makeText(getApplicationContext(),"Email Tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }
        else if (pass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Password tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Login gagal",Toast.LENGTH_LONG).show();
        }

    }
}
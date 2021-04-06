package firdaus.rizkika.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout Nama, Pass;
    TextView Mendaftar,Petunjuk;
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
        Mendaftar = findViewById(R.id.daftar);
        Petunjuk = findViewById(R.id.edHINT);

        Masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { pindah(); }
        });

        Mendaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(), Daftar.class);
                startActivity(a);
            }
        });

        Petunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Email : admin@email.com / Pass : 123", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void pindah()
    {
        nama = Nama.getEditText().getText().toString();
        pass = Pass.getEditText().getText().toString();

        if (nama.isEmpty() && pass.isEmpty()){
            Nama.setError("Email Harus di isi!");
            Pass.setError("Password Harus di isi!");
            Toast.makeText(getApplicationContext(),"Isi data yang di sediakan!",Toast.LENGTH_LONG).show();
        }
        else if(nama.isEmpty()){
            Nama.setError("Email Harus di isi!");
        }
        else if (pass.isEmpty()){
            Pass.setError("Password Harus di isi!");
        }
        else if (nama.equals(email) && pass.equals(password)){
            Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),dataKontak.class);
            startActivity(i);
        }
        else {
            Toast.makeText(getApplicationContext(),"Login gagal",Toast.LENGTH_LONG).show();
        }

    }
}
package firdaus.rizkika.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Daftar extends AppCompatActivity {

    TextInputLayout EdNama, EdEmail, EdAlamat, EdPass, EdRePass;
    String Nama,Email,Alamat,Pass,RePass;
    Button bBatal, bDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        EdNama = findViewById(R.id.edtNama);
        EdAlamat = findViewById(R.id.edtAlamat);
        EdEmail = findViewById(R.id.edtEmail);
        EdPass = findViewById(R.id.edtPass);
        EdRePass = findViewById(R.id.edtRePass);
        bBatal = findViewById(R.id.btnBatal);
        bDaftar = findViewById(R.id.btnDaftar);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validasi();
            }
        });

        bBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void Validasi(){
        Nama = EdNama.getEditText().getText().toString();
        Alamat = EdAlamat.getEditText().getText().toString();
        Email = EdEmail.getEditText().getText().toString();
        Pass = EdPass.getEditText().getText().toString();
        RePass = EdRePass.getEditText().getText().toString();

        if (Nama.isEmpty() && Alamat.isEmpty() && Email.isEmpty() && Pass.isEmpty() && RePass.isEmpty()){
            EdNama.setError("Nama Tidak boleh kosong!");
            EdAlamat.setError("Alamat Tidak boleh kosong!");
            EdEmail.setError("Email Tidak boleh kosong!");
            EdPass.setError("Password Tidak boleh kosong!");
            EdRePass.setError("Masukkan kembali password anda!");
            Toast.makeText(getApplicationContext(),"Semua data Harus di isi !", Toast.LENGTH_SHORT).show();
        }
        else if (Nama.isEmpty()){
            EdNama.setError("Nama Tidak boleh kosong!");
        }
        else if (Alamat.isEmpty()){
            EdAlamat.setError("Alamat Tidak boleh kosong!");
        }
        else if (Email.isEmpty()){
            EdEmail.setError("Email Tidak boleh kosong!");
        }
        else if (Pass.isEmpty()){
            EdPass.setError("Password Tidak boleh kosong!");
        }
        else if (RePass.isEmpty()){
            EdRePass.setError("Masukkan kembali password anda!");
        }
        else if (!Pass.equals(RePass)){
            Toast.makeText(getApplicationContext(),"Password anda tidak sama!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Daftar berhasil",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
    }
}
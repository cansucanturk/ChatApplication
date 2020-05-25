package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GirisActivity extends AppCompatActivity {
    EditText kullaniciAdiEditText;
    Button kaydolmaButon;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        tanimlama();
    }

    public void tanimlama() {
        kullaniciAdiEditText = (EditText) findViewById(R.id.kullaniciAdiEditText);
        kaydolmaButon = (Button) findViewById(R.id.kaydolmaButon);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();

        kaydolmaButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = kullaniciAdiEditText.getText().toString();
                kullaniciAdiEditText.setText("");
                ekle(username);
            }
        });

    }

    public void ekle(final String kullaniciAdi) {
        reference.child("Kullanıcılar").child(kullaniciAdi).child("kullaniciadi").setValue(kullaniciAdi).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Kayıt başarılı", Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(GirisActivity.this,MainActivity.class);
                    intent.putExtra("kullaniciAdi", kullaniciAdi);
                  startActivity(intent);
                }
            }

        });
    }}

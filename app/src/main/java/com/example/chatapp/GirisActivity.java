package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class GirisActivity extends AppCompatActivity {
   EditText kullaniciAdiEditText;
   Button kaydolmaButon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        tanimlama();
    }

    public void tanimlama()
    {
        kullaniciAdiEditText = (EditText)findViewById(R.id.kullaniciAdiEditText);
        kaydolmaButon = (Button)findViewById(R.id.kaydolmaButon);
    }

    public void kaydol(){

    }
}

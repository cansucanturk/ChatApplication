package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    String userName, otherName;
    TextView chatUserName;
    ImageView backImage, sendImage;
    EditText chatEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        tanimla();
    }

    public void tanimla(){

        userName = getIntent().getExtras().getString("username");
        otherName = getIntent().getExtras().getString("othername");

        Log.i("alinanDegerler: ", userName+"--"+ otherName);
        chatUserName = (TextView)findViewById((R.id.chatUserName));
        backImage = (ImageView)findViewById(R.id.backImage);
        chatEditText = (EditText)findViewById(R.id.chatEditText);
        chatEditText.setText(otherName);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                intent.putExtra("kullaniciAdi", userName);
                startActivity(intent);
            }
        });
    }
}

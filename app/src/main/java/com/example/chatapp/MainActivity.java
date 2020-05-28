package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    List<String> list;
    String userName;
    RecyclerView userRecyclerView;
    UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        listele();
    }

    public void tanimla()
    {
        userName = getIntent().getExtras().getString("kullaniciAdi");
        firebaseDatabase = firebaseDatabase.getInstance();
        reference =firebaseDatabase.getReference();
        list= new ArrayList<>();
        userRecyclerView = (RecyclerView)findViewById(R.id.userRecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,2);
        userRecyclerView.setLayoutManager(layoutManager);
        userAdapter = new UserAdapter(MainActivity.this, list, MainActivity.this);
        userRecyclerView.setAdapter(userAdapter);
    }

    public void listele(){

        reference.child("kullanicilar").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if(!dataSnapshot.getKey().equals(userName)) {
                    list.add(dataSnapshot.getKey());
                    Log.i("Kullanici", dataSnapshot.getKey());

                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

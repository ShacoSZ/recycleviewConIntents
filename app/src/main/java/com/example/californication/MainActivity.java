package com.example.californication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.californication.adaptadores.personaadaptador;
import com.example.californication.modelos.persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdesign);
        List<persona> personas=new ArrayList<persona>();

        personas.add(new persona("Felits","871-442-33-97",
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pinterest.com.mx/pin/662873638890763105/"))));
        personas.add(new persona("Armando","874-596-12-30",
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=jJzw1h5CR-I"))));

        personaadaptador uno =new personaadaptador(personas);
        RecyclerView tres =(RecyclerView) findViewById(R.id.dos);
        tres.setAdapter(uno);
        tres.setLayoutManager(new LinearLayoutManager(this));
        tres.setHasFixedSize(true);

    }
}
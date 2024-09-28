package com.aplicacionesmoviles.contoldepuertas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class puerta extends AppCompatActivity {

    private ArrayList<String> registros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puerta);

        registros = new ArrayList<>();

        Button btn =findViewById(R.id.btnAbrir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String currentDateAndTime=sdf.format(new Date());

                if(registros==null){
                    registros=new ArrayList<>();
                }

                registros.add("Puerta abierta en: " + currentDateAndTime);
                Intent intent = new Intent(puerta.this, accesos.class);
                intent.putStringArrayListExtra("datos", registros);
                startActivity(intent);
            }
        });

        Button btnCerrar=findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(puerta.this, "Puerta Cerrada", Toast.LENGTH_SHORT).show();
            }
        });

        Button button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

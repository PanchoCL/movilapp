package com.aplicacionesmoviles.contoldepuertas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void ingresar(View v){
        EditText user=this.findViewById(R.id.Usuario);
        String usuario=user.getText().toString();
        EditText pass=this.findViewById(R.id.Contrasenia);
        String contrasenia=pass.getText().toString();

        if(usuario.equals("admin") && contrasenia.equals("admin1")){
            Intent i=new Intent(this, puerta.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Error en las credenciales", Toast.LENGTH_SHORT).show();
        }
    }
    public void RegistrarCuenta(View v){
        Intent i=new Intent(this, Registro.class);
        startActivity(i);
    }
}
package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parcial.R;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button btnEntrar, btnRegistrar;
EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEntrar) {
            // Acciones cuando se hace clic en el botón Entrar
        } else if (v.getId() == R.id.btnRegistrar) {
            Intent i = new Intent(MainActivity.this, Registrar.class);
            startActivity(i);
        }
    }

}
package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    EditText us, pas, nom, ap;
    Button reg, can;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        us=(EditText)findViewById(R.id.RegUser);
        pas=(EditText)findViewById(R.id.RegPass);
        nom=(EditText)findViewById(R.id.RegNombre);
        ap=(EditText)findViewById(R.id.RegApellido);
        reg=(Button)findViewById(R.id.btnRegRegistrar);
        can=(Button)findViewById(R.id.btnRegCancelar);


        //reg.setOnClickListener(this);
        //can.setOnClickListener(this);
    }
    public void Retroceder(View v) {
        if (v.getId() == R.id.btnRegRegistrar) {
            // Acciones cuando se hace clic en el botón Entrar
            Usuario u=new Usuario();
            daoUsuario dao = new daoUsuario(this);

            u.setUsuario(us.getText().toString());
            u.setPassword(pas.getText().toString());
            u.setNombre(nom.getText().toString());
            u.setApellido(ap.getText().toString());
            dao = null;
            if (!u.isNull()){
                Toast.makeText(this, "ERROR: Campos Vacios",Toast.LENGTH_LONG).show();
            }else if (dao.insertUsuario(u)){
                Toast.makeText(this, "Registro Exitoso",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Usuario Ya Existente!",Toast.LENGTH_LONG).show();
            }

        } else if (v.getId() == R.id.btnRegistrar) {
            Intent i = new Intent(Registrar.this, MainActivity.class);
            startActivity(i);
        }
    }


}
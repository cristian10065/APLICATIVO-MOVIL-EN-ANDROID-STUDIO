package com.example.parcial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table usuario(id integer primary key autoincrement, usuario text, pass text, nombre text, ap text)";

    //dao recibe el contexto osea c
    public  daoUsuario (Context c){
        this.c=c;
        //nos sirve para abrir o crear la base de datos, en caso de que no exista o ya exista
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        //cramos nuestro objeto que vamos a crear
        u=new Usuario();
    }
    public boolean insertUsuario (Usuario u){
        if (buscar(u.getUsuario())==0){
            // si me retorna 0 al comprobar el nombre de usuario, significa que no existe en la base de datos
            // lo que nos permitiria seguir adelante, registrando el usuario
            ContentValues cv=new ContentValues();
            cv.put("usuario",u.getUsuario());
            cv.put("pass",u.getPassword());
            cv.put("nombre",u.getNombre());
            cv.put("ap",u.getApellido());
            return (sql.insert("usuario", null,cv)>0);
        }else {
            return false;
            //en caso que se cumpla esta condicion significaria que no se pudo insertar el parametro en la base de datos
        }
    }
    public int buscar(String u){
        int x=0;
        //con este metodo vamos a buscar si hay el numero de usuarios en la base de datos
        lista=selectUsuario();
        for (Usuario us:lista){
            //para vefiricar que no existen dos usurios registrados con el mismo nombre de usuario
            if (us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
        //y en caso que exista un usuario con el mismo nombre, entonces me va a retornarlo
    }

    public ArrayList<Usuario> selectUsuario(){
        ArrayList<Usuario> lista=new ArrayList<Usuario>();
        lista.clear();
        //nos va a seleccionar todos los usuarios que hay en la base de datos
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()) {
            do {
                //si nos devuelve, lo extraemos y lo pasamos a la lista
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellido(cr.getString(4));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return  lista;
    }




}

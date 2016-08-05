package com.example.programacion5a.formulariosqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.txtnombre);
        et2=(EditText) findViewById(R.id.txtapellido);
        et3=(EditText) findViewById(R.id.txtcelular);
    }

    public void registrar(View view){
        AdminSqlite admin=new AdminSqlite(this,"administracion",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        String nom=et1.getText().toString();
        String ape=et2.getText().toString();
        String cel=et3.getText().toString();

        ContentValues registro=new ContentValues();
        registro.put("nombre",nom);
        registro.put("apellido",ape);
        registro.put("celular",cel);

        if(bd.insert("alumnos",null,registro)>0){
            Toast.makeText(this,"Alumno registrado",Toast.LENGTH_SHORT).show();
        }
        bd.close();

        et1.setText(" ");
        et2.setText(" ");
        et3.setText(" ");
    }
}

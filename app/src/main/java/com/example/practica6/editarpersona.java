package com.example.practica6;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class editarpersona extends AppCompatActivity {

    ImageView img1,img2,img3,img4,img5,img6;
    EditText txtImg1,txtImg2, txtImg3, txtImg4, txtImg5, txtImg6;
    String telefono="";
    String correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarpersona);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

        txtImg1 = findViewById(R.id.txtImg1);
        txtImg2 = findViewById(R.id.txtImg2);
        txtImg3 = findViewById(R.id.txtImg3);
        txtImg4 = findViewById(R.id.txtImg4);
        txtImg5 = findViewById(R.id.txtImg5);
        txtImg6 = findViewById(R.id.txtImg6);
    }
    public void onClick(View view)
    {
        SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(telefono, txtImg1.getText().toString());
        editor.putString(correo, txtImg2.getText().toString());
        editor.putString(telefono, txtImg2.getText().toString());
        editor.putString(correo, txtImg2.getText().toString());
        editor.putString(telefono, txtImg3.getText().toString());
        editor.putString(correo, txtImg3.getText().toString());
        editor.putString(telefono, txtImg4.getText().toString());
        editor.putString(correo, txtImg4.getText().toString());
        editor.putString(telefono, txtImg5.getText().toString());
        editor.putString(correo, txtImg5.getText().toString());
        editor.putString(telefono, txtImg6.getText().toString());
        editor.putString(correo, txtImg6.getText().toString());
        editor.commit();
        Toast.makeText(this, "Se han actualizados las llamadas y correos de las personas", Toast.LENGTH_LONG).show();;
    }
}
package com.example.practica6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

public class Personas extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    ImageView img1, img2, img3, img4, img5, img6;
    String correo;
    String telefono;
    Button btnEditar;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

        btnEditar = findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pers = new Intent(Personas.this, editarpersona.class);
                startActivity(pers);
            }
        });

        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo = "correo1";
                telefono = "telefono1";
                registerForContextMenu(img1);
                return false;
            }
        });
        img2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo = "correo2";
                telefono = "telefono2";
                registerForContextMenu(img2);
                return false;
            }
        });
        img3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo = "correo3";
                telefono = "telefono3";
                registerForContextMenu(img3);
                return false;
            }
        });
        img4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo = "correo4";
                telefono = "telefono4";
                registerForContextMenu(img4);
                return false;
            }
        });
        img5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo = "correo5";
                telefono = "telefono5";
                registerForContextMenu(img5);
                return false;
            }
        });
        img6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo = "correo6";
                telefono = "telefono6";
                registerForContextMenu(img6);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.persona, menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String cadena = "";
        prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        switch (item.getItemId()) {
            case R.id.opcion3:
                cadena = prefs.getString(telefono, null);
                if (cadena == null) {
                    Toast.makeText(this,getString(R.string.toastTlfVacio) , Toast.LENGTH_SHORT).show();
                } else {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("teléfono:" + cadena));
                        startActivity(callIntent);
                    } else {
                        requestPermissions(new String[]{CALL_PHONE}, 1);
                    }

                }
                break;
            case R.id.opcion4:
                cadena = prefs.getString(correo, null);
                if (cadena == null) {
                    Toast.makeText(this,getString(R.string.toastCorreoVacio) , Toast.LENGTH_SHORT).show();
                }else{
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, cadena);
                    startActivity(emailIntent);
                }
                break;
        }
        return true;
    }
}



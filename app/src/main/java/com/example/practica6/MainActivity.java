package com.example.practica6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Intent op1, op2;
    ImageView imagenPersona, imagenBloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = new Intent(this, Personas.class);
        op2 = new Intent(this, BlocDeNotas.class);
    imagenPersona   = findViewById(R.id.imagenPersona);
    imagenBloc      = findViewById(R.id.imagenBloc);

    imagenPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pers = new Intent(MainActivity.this, Personas.class);
                startActivity(pers);
            }
        });
    imagenBloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bloc = new Intent(MainActivity.this, BlocDeNotas.class);
                startActivity(bloc);
            }
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inicio, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.opcion1: startActivity(op1);break;
            case R.id.opcion2: startActivity(op2);break;
        }
        return false;
    }
}


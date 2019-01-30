package com.example.practica6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class BlocDeNotas extends AppCompatActivity {

    EditText txtBloc;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc_de_notas);

        txtBloc =   findViewById(R.id.txtBloc);
        pref = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        txtBloc.setText(pref.getString("BlocDeNotas", ""));
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("BlocDeNotas", txtBloc.getText().toString());
        editor.commit();
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bloc, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("BlocDeNotas", txtBloc.getText().toString());
        editor.commit();
        return false;
    }
}

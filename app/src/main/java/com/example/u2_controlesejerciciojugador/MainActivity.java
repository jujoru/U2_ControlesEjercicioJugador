package com.example.u2_controlesejerciciojugador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    Button btnAnterior, btnSiguiente;
    EditText etNombre;
    Spinner spDorsal;
    RadioGroup rgPosicion;
    CheckBox cbMundial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnterior = (Button)findViewById(R.id.btnAnterior);
        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        etNombre = (EditText)findViewById(R.id.etNombre);
        spDorsal = (Spinner)findViewById(R.id.spDorsal);
        rgPosicion = (RadioGroup) findViewById(R.id.rgPosicion);
        cbMundial = (CheckBox) findViewById(R.id.cbMundial);

        String[] dorsales = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
        ArrayAdapter<String> adaptadorDorsales = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,dorsales);
        spDorsal.setAdapter(adaptadorDorsales);

    }

    public void clickAnterior(View view){

    }

    public void clickSiguiente(View view){

    }

    public void clickLimpiar(View view){

    }

    public void clickGuardar(View view){

    }
}

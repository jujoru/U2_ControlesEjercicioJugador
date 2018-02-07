package com.example.u2_controlesejerciciojugador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvNombre, tvDorsal, tvPosicion, tvMundial;
    Button btnAnterior, btnSiguiente;
    EditText etNombre;
    Spinner spDorsal;
    RadioGroup rgPosicion;
    CheckBox cbMundial;
    ArrayList<Jugador> lista_jugadores = new ArrayList<Jugador>();
    int indice;

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
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvDorsal = (TextView)findViewById(R.id.tvDorsal);
        tvPosicion = (TextView)findViewById(R.id.tvPosicion);
        tvMundial = (TextView)findViewById(R.id.tvMundial);
        indice=-1;

        String[] dorsales = {"","1","2","3","4","5","6","7","8","9","10","11","12","13"};
        ArrayAdapter<String> adaptadorDorsales = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,dorsales);
        spDorsal.setAdapter(adaptadorDorsales);

    } //FIN ONCREATE

    public void clickAnterior(View view){
        if(indice>0){
            indice--;
            cargarJugador();
        }else{
            mostrarMensaje("Has llegado al principio");
        }

    }

    public void clickSiguiente(View view){
        if(indice<lista_jugadores.size()-1){
            indice++;
            cargarJugador();
        }else{
            //Si queremos que la lista vuela a empear una vez llegado al último elemento
            indice=0;
            cargarJugador();
        }
    }

    public void clickLimpiar(View view){
        limpiarFormulario();
    }

    public void clickGuardar(View view){
        String cajaNombre = etNombre.getText().toString();
        String spinnerDorsal = spDorsal.getSelectedItem().toString();
        int idPosicion = rgPosicion.getCheckedRadioButtonId();

        if(cajaNombre.equals("") || spinnerDorsal.equals("") || idPosicion==-1){

            mostrarMensaje("Debes de rellenar los campos obligatorios");

        }else{

            boolean tieneMundial = cbMundial.isChecked();
            RadioButton rbCopia = (RadioButton)findViewById(idPosicion);
            String posicion = rbCopia.getText().toString();
            int dorsal = Integer.parseInt(spinnerDorsal);

            Jugador j=new Jugador(cajaNombre, dorsal,posicion, tieneMundial);
            lista_jugadores.add(j);

            btnAnterior.setEnabled(true);
            btnSiguiente.setEnabled(true);
            limpiarFormulario();
        }

    }

    //Mis metodos
    private void limpiarFormulario(){

        etNombre.setText("");
        spDorsal.setSelection(0);
        rgPosicion.clearCheck();
        cbMundial.setChecked(false);

    }

    private void mostrarMensaje(String mensaje){

        Toast.makeText(getApplicationContext(),mensaje,
                Toast.LENGTH_LONG).show();

    }

    private void cargarJugador(){
        Jugador j = lista_jugadores.get(indice);
        tvNombre.setText("Nombre: "+j.getNombre());
        tvDorsal.setText("Dorsal: "+j.getDorsal()+"");
        tvPosicion.setText("Posicion: "+j.getPosicion());

        String mundial = "";
        if(j.isTieneMundial()){
            mundial="Si";
        }else{
            mundial="No";
        }
        tvMundial.setText("Tiene mundial: "+mundial);
    }
}//FIN MAIN

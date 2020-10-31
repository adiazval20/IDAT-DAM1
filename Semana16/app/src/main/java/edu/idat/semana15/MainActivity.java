package edu.idat.semana15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana15.adapter.IComunicacion;
import edu.idat.semana15.adapter.PersonaAdapter;
import edu.idat.semana15.entity.Persona;
import edu.idat.semana15.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements IComunicacion {
    private Persona persona;

    private MainViewModel viewModel;
    private ListView lsvPersonas;

    private EditText edtApellidoPaterno, edtApellidoMaterno, edtNombres;
    private Button btnCancelar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtApellidoPaterno = findViewById(R.id.edtApellidoPaterno);
        edtApellidoMaterno = findViewById(R.id.edtApellidoMaterno);
        edtNombres = findViewById(R.id.edtNombres);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        lsvPersonas = findViewById(R.id.lsvPersonas);

        PersonaAdapter adapter = new PersonaAdapter(this, R.layout.item_persona, new ArrayList<>(), this);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, new ArrayList<>());
        lsvPersonas.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.listPersonas().observe(this, new Observer<List<Persona>>() {
            @Override
            public void onChanged(List<Persona> personas) {
//                List lstString = new ArrayList();
//                for (Persona persona : personas) {
//                    lstString.add(String.format("%s %s %s", persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getNombres()));
//                }

                adapter.clear();
                adapter.addAll(personas);
                adapter.notifyDataSetChanged();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFormulario(new Persona());
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persona.setApellidoPaterno(edtApellidoPaterno.getText().toString());
                persona.setApellidoMaterno(edtApellidoMaterno.getText().toString());
                persona.setNombres(edtNombres.getText().toString());

                viewModel.savePersona(persona);

                cargarFormulario(new Persona());
            }
        });

        cargarFormulario(new Persona());
    }

    private void cargarFormulario(Persona persona) {
        this.persona = persona;

        edtApellidoPaterno.setText(persona.getApellidoPaterno());
        edtApellidoMaterno.setText(persona.getApellidoMaterno());
        edtNombres.setText(persona.getNombres());
    }

    @Override
    public void editar(Persona persona) {
        cargarFormulario(persona);
    }
}
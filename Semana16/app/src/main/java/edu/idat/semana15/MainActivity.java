package edu.idat.semana15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana15.entity.Persona;
import edu.idat.semana15.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private ListView lsvPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvPersonas = findViewById(R.id.lsvPersonas);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.listPersonas().observe(this, new Observer<List<Persona>>() {
            @Override
            public void onChanged(List<Persona> personas) {
                List lstString = new ArrayList();
                for (Persona persona : personas) {
                    lstString.add(String.format("%s %s %s", persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getNombres()));
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, lstString);
                lsvPersonas.setAdapter(adapter);
            }
        });
    }
}
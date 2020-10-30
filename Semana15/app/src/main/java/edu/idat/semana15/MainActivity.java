package edu.idat.semana15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import edu.idat.semana15.entity.Persona;
import edu.idat.semana15.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.listPersonas().observe(this, new Observer<List<Persona>>() {
            @Override
            public void onChanged(List<Persona> personas) {
                Toast.makeText(MainActivity.this, String.valueOf(personas.size()), Toast.LENGTH_LONG).show();
            }
        });
    }
}
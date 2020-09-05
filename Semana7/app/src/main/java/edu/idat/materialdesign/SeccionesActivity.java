package edu.idat.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SeccionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secciones);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Secciones");

        List<String> lstSecciones = new ArrayList<>();
        lstSecciones.add("Inicio");
        lstSecciones.add("Productos");
        lstSecciones.add("Artículos");
        lstSecciones.add("Ayuda");

        ListView lsvSecciones = findViewById(R.id.lsvSecciones);
        ArrayAdapter<String> seccionesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstSecciones);
        lsvSecciones.setAdapter(seccionesAdapter);
    }
}
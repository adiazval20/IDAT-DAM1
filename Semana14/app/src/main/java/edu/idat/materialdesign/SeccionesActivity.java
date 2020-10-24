package edu.idat.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.materialdesign.adapter.SeccionAdapter;
import edu.idat.materialdesign.entity.Seccion;

public class SeccionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secciones);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Secciones");

        GridView grvSecciones = findViewById(R.id.grvSecciones);

        List<Seccion> lstSecciones = new ArrayList<>();
        lstSecciones.add(new Seccion(1, "Inicio", R.drawable.ic_baseline_home_24, "#aab6fe", "#001064"));
        lstSecciones.add(new Seccion(2, "Tienda", R.drawable.ic_baseline_shopping_cart_24, "#ffffa8", "#f57f17"));

        SeccionAdapter seccionAdapter = new SeccionAdapter(this, R.layout.item_seccion, lstSecciones);
        grvSecciones.setAdapter(seccionAdapter);

        grvSecciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Seccion seccion = (Seccion) parent.getItemAtPosition(position);

                switch (seccion.getId()) {
                    case 1:
                        // Cargar fragment Inicio
                        break;
                    case 2:
                        // Cargar fragment Tienda
                        break;
                }
            }
        });
    }
}
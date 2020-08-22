package edu.idat.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Context context = this;
        BottomNavigationView bnvMenu = findViewById(R.id.bnvMenu);
        bnvMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.optInicio:
                        Toast.makeText(context, "INICIO", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.optProductos:
                        Toast.makeText(context, "PRODUCTOS", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.optUbicacion:
                        Toast.makeText(context, "UBICACIÓN", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}
package edu.idat.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

        loadFragment(new InicioFragment());

        final Context context = this;
        BottomNavigationView bnvMenu = findViewById(R.id.bnvMenu);
        bnvMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.optInicio:
                        loadFragment(new InicioFragment());
                        break;
                    case R.id.optProductos:
                        loadFragment(new ProductosFragment());
                        break;
                    case R.id.optArticulos:
                        loadFragment(new ArticulosFragment());
                        break;
                    case R.id.optUbicacion:
                        loadFragment(new UbicacionFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.frmContenedor, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
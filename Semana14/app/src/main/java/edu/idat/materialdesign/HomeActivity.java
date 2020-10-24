package edu.idat.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    private Map<Integer, Integer> posicionesMenu;
    private int posicionActual;
    private int animacionIn, animacionOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbarHome = findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbarHome);

        posicionesMenu = new HashMap<>();
        posicionesMenu.put(R.id.optInicio, 0);
        posicionesMenu.put(R.id.optProductos, 1);
        posicionesMenu.put(R.id.optArticulos, 2);
        posicionesMenu.put(R.id.optUbicacion, 3);
        posicionesMenu.put(R.id.optAnimaciones, 4);

        posicionActual = posicionesMenu.get(R.id.optInicio);

        loadFragmentByMenuId(R.id.optInicio);

        final Context context = this;
        BottomNavigationView bnvMenu = findViewById(R.id.bnvMenu);
        bnvMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragmentByMenuId(item.getItemId());
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        loadFragmentByMenuId(item.getItemId());
        return true;
    }

    private void loadFragmentByMenuId(int id) {
        Fragment fragment = new Fragment();

        switch (id) {
            case R.id.optInicio:
                fragment = new InicioFragment();
                break;
            case R.id.optProductos:
                fragment = new ProductosFragment();
                break;
            case R.id.optArticulos:
                fragment = new ArticulosFragment();
                break;
            case R.id.optUbicacion:
                fragment = new UbicacionFragment();
                break;
            case R.id.optAnimaciones:
                fragment = new AnimacionesFragment();
                break;
        }

        if (posicionActual < posicionesMenu.get(id)) {
            animacionIn = R.anim.move_right_left_in;
            animacionOut = R.anim.move_right_left_out;
        } else {
            animacionIn = R.anim.move_left_right_in;
            animacionOut = R.anim.move_left_right_out;
        }
        posicionActual = posicionesMenu.get(id);

        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(animacionIn, animacionOut);
        transaction.replace(R.id.frmContenedor, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
package edu.idat.materialdesign;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.idat.materialdesign.adapter.ProductoAdapter;
import edu.idat.materialdesign.entity.Producto;

public class ProductosFragment extends Fragment implements IComunicacion {
    public ProductosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView rcvProductos = view.findViewById(R.id.rcvProductos);
        rcvProductos.setLayoutManager(new GridLayoutManager(getContext(), 1));

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Iphone", "Descripción de producto Iphone", R.drawable.iphone, 3000));
        productos.add(new Producto(2, "Samsung", "Descripción de producto Samsung", R.drawable.samsung2, 2500));
        productos.add(new Producto(3, "Otro Samsung", "Descripción de otro producto Samsung", R.drawable.samsung2, 2500));

        ProductoAdapter adapter = new ProductoAdapter(productos, this);
        rcvProductos.setAdapter(adapter);
    }

    @Override
    public void cargarActividad(Class<?> actividad) {
        Intent intent = new Intent(getContext(), actividad);
        startActivity(intent);
    }
}
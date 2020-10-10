package edu.idat.materialdesign.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.idat.materialdesign.IComunicacion;
import edu.idat.materialdesign.R;
import edu.idat.materialdesign.entity.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {
    private List<Producto> productos;
    private IComunicacion comunicacion;

    public ProductoAdapter(List<Producto> productos, IComunicacion comunicacion) {
        this.productos = productos;
        this.comunicacion = comunicacion;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view, comunicacion);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.cargarDatos(producto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }
}

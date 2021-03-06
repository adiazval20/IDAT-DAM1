package edu.idat.materialdesign.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.idat.materialdesign.CompraActivity;
import edu.idat.materialdesign.IComunicacion;
import edu.idat.materialdesign.R;
import edu.idat.materialdesign.entity.Producto;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgProducto;
    private TextView txtNombre, txtDescripcion, txtPrecio;
    private Button btnRealizarCompra;
    private IComunicacion comunicacion;

    public ProductoViewHolder(@NonNull View itemView, final IComunicacion comunicacion) {
        super(itemView);

        this.comunicacion = comunicacion;

        imgProducto = itemView.findViewById(R.id.imgProducto);
        txtNombre = itemView.findViewById(R.id.txtNombre);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        txtPrecio = itemView.findViewById(R.id.txtPrecio);
        btnRealizarCompra = itemView.findViewById(R.id.btnRealizarCompra);

        btnRealizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicacion.cargarActividad(CompraActivity.class);
            }
        });
    }

    public void cargarDatos(Producto producto) {
        imgProducto.setImageResource(producto.getImagenId());
        txtNombre.setText(producto.getNombre());
        txtDescripcion.setText(producto.getDescripcion());
        txtPrecio.setText(String.format("S/%.2f", producto.getPrecio()));
    }
}

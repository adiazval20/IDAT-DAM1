package edu.idat.materialdesign.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.idat.materialdesign.R;
import edu.idat.materialdesign.entity.Categoria;

public class CategoriaViewHolder extends RecyclerView.ViewHolder {
    private Categoria categoria;
    private ImageView imgIcono;
    private TextView txtNombre;

    public CategoriaViewHolder(@NonNull final View itemView) {
        super(itemView);
        imgIcono = itemView.findViewById(R.id.imgIcono);
        txtNombre = itemView.findViewById(R.id.txtNombre);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), categoria.getNombre(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void cargarDatos(Categoria categoria) {
        this.categoria = categoria;
        imgIcono.setImageResource(categoria.getImagenId());
        txtNombre.setText(categoria.getNombre());
    }
}

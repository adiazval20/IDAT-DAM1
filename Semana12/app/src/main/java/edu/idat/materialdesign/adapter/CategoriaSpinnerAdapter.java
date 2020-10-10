package edu.idat.materialdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.idat.materialdesign.R;
import edu.idat.materialdesign.entity.Categoria;

public class CategoriaSpinnerAdapter extends ArrayAdapter<Categoria> {
    private List<Categoria> categorias;

    public CategoriaSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Categoria> objects) {
        super(context, resource, objects);
        this.categorias = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return generarVista(position, convertView, parent, false);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return generarVista(position, convertView, parent, true);
    }

    private View generarVista(int position, @Nullable View convertView, @NonNull ViewGroup parent, boolean mostrarImagen) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_categoria_spinner, parent, false);
        }

        Categoria categoria = categorias.get(position);

        ImageView imgIcono = convertView.findViewById(R.id.imgIcono);
        TextView txtNombre = convertView.findViewById(R.id.txtNombre);

        imgIcono.setImageResource(categoria.getImagenId());
        imgIcono.setVisibility(mostrarImagen ? View.VISIBLE : View.GONE);
        txtNombre.setText(categoria.getNombre());

        return convertView;
    }
}

package edu.idat.materialdesign.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.idat.materialdesign.R;
import edu.idat.materialdesign.entity.Seccion;

public class SeccionAdapter extends ArrayAdapter<Seccion> {
    public SeccionAdapter(@NonNull Context context, int resource, @NonNull List<Seccion> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Seccion seccion = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_seccion, parent, false);
        }

        LinearLayout lytSeccion = convertView.findViewById(R.id.lytSeccion);
        ImageView imgIcono = convertView.findViewById(R.id.imgIcono);
        TextView txtNombre = convertView.findViewById(R.id.txtNombre);

        lytSeccion.setBackgroundColor(Color.parseColor(seccion.getHexBackColor()));

        imgIcono.setImageResource(seccion.getImagenId());
        imgIcono.setColorFilter(Color.parseColor(seccion.getHexColor()));

        txtNombre.setText(seccion.getNombre());
        txtNombre.setTextColor(Color.parseColor(seccion.getHexColor()));

        return convertView;
    }
}

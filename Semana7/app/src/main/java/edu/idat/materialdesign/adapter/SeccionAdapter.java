package edu.idat.materialdesign.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.idat.materialdesign.entity.Seccion;

public class SeccionAdapter extends ArrayAdapter<Seccion> {
    public SeccionAdapter(@NonNull Context context, int resource, @NonNull List<Seccion> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Seccion seccion = getItem(position);

        return super.getView(position, convertView, parent);
    }
}

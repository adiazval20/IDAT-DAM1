package edu.idat.semana15.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.idat.semana15.R;
import edu.idat.semana15.entity.Persona;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    private IComunicacion comunicacion;

    public PersonaAdapter(@NonNull Context context, int resource, @NonNull List<Persona> objects, IComunicacion comunicacion) {
        super(context, resource, objects);
        this.comunicacion = comunicacion;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_persona, parent, false);
        }

        Persona persona = getItem(position);

        TextView txtNombres = convertView.findViewById(R.id.txtNombres);
        txtNombres.setText(String.format("%s %s %s", persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getNombres()));

        Button btnEditar = convertView.findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicacion.editar(persona);
            }
        });

        return convertView;
    }
}

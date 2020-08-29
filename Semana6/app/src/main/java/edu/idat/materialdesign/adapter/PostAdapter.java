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
import edu.idat.materialdesign.entity.Post;

public class PostAdapter extends ArrayAdapter<Post> {
    public PostAdapter(@NonNull Context context, int resource, @NonNull List<Post> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);
        }

        TextView txtTitulo = convertView.findViewById(R.id.txtTitulo);
        TextView txtSubtitulo = convertView.findViewById(R.id.txtSubtitulo);
        ImageView imgPost = convertView.findViewById(R.id.imgPost);
        TextView txtMensaje = convertView.findViewById(R.id.txtMensaje);

        Post post = getItem(position);

        txtTitulo.setText(post.getTitulo());
        txtSubtitulo.setText(post.getSubTitulo());
        imgPost.setImageResource(post.getImagen());
        txtMensaje.setText(post.getMensaje());

        return convertView;
    }
}

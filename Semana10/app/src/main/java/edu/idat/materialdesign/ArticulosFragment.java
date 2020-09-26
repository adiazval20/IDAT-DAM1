package edu.idat.materialdesign;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.materialdesign.adapter.PostAdapter;
import edu.idat.materialdesign.entity.Post;

public class ArticulosFragment extends Fragment {
    public ArticulosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articulos, container, false);
    }

    //    CTRL + O
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListView lsvPosts = view.findViewById(R.id.lsvPosts);
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Iphone", "29/08/2020", R.drawable.iphone, "Esta es una publicación", R.drawable.chat));
        posts.add(new Post(2, "Samsung", "28/08/2020", R.drawable.samsung2, "Esta es otra publicación", R.drawable.logo));

        PostAdapter adapter = new PostAdapter(getContext(), R.layout.item_post, posts);

        lsvPosts.setAdapter(adapter);
    }
}
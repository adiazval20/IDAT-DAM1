package edu.idat.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.materialdesign.adapter.PostAdapter;
import edu.idat.materialdesign.entity.Post;

public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lista de Publicaciones");

        ListView lsvPosts = findViewById(R.id.lsvPosts);
//        List<String> list = new ArrayList<>();
//        list.add("Elemento 1");
//        list.add("Elemento 2");
//        list.add("Elemento 3");

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Iphone", "29/08/2020", R.drawable.iphone, "Esta es una publicación"));
        posts.add(new Post(2, "Samsung", "28/08/2020", R.drawable.samsung2, "Esta es otra publicación"));

        PostAdapter adapter = new PostAdapter(this, R.layout.item_post, posts);

        lsvPosts.setAdapter(adapter);
    }
}
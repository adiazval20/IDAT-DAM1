package edu.idat.materialdesign;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class InicioFragment extends Fragment {
    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ImageView imgInicio = view.findViewById(R.id.imgInicio);

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator translateX, rotation, alpha;

        translateX = ObjectAnimator.ofFloat(imgInicio, "translateX", 200f);
        translateX.setDuration(6000);
        animatorSet.play(translateX);

        rotation = ObjectAnimator.ofFloat(imgInicio, "rotation", 90f);
        rotation.setDuration(6000);
        animatorSet.play(rotation);

        alpha = ObjectAnimator.ofFloat(imgInicio, "alpha", 1f);
        alpha.setDuration(6000);
        animatorSet.play(alpha);

        animatorSet.start();
    }
}
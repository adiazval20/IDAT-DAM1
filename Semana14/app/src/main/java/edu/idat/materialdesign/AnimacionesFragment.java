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
import android.widget.Button;
import android.widget.ImageView;

public class AnimacionesFragment extends Fragment {
    private final int DURACION = 600;
    private Button btnInicioX;
    private Button btnFinX;
    private ImageView imgAnimX;

    private Button btnInicioY;
    private Button btnFinY;
    private ImageView imgAnimY;

    private Button btnInicioAlpha;
    private Button btnFinAlpha;
    private ImageView imgAnimAlpha;

    private Button btnInicioRotation;
    private Button btnFinRotation;
    private ImageView imgAnimRotation;

    private Button btnInicioCombinado;
    private Button btnFinCombinado;
    private ImageView imgAnimCombinado;

    public AnimacionesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animaciones, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btnInicioX = view.findViewById(R.id.btnInicioX);
        btnFinX = view.findViewById(R.id.btnFinX);
        imgAnimX = view.findViewById(R.id.imgAnimX);

        btnInicioY = view.findViewById(R.id.btnInicioY);
        btnFinY = view.findViewById(R.id.btnFinY);
        imgAnimY = view.findViewById(R.id.imgAnimY);

        btnInicioAlpha = view.findViewById(R.id.btnInicioAlpha);
        btnFinAlpha = view.findViewById(R.id.btnFinAlpha);
        imgAnimAlpha = view.findViewById(R.id.imgAnimAlpha);

        btnInicioRotation = view.findViewById(R.id.btnInicioRotation);
        btnFinRotation = view.findViewById(R.id.btnFinRotation);
        imgAnimRotation = view.findViewById(R.id.imgAnimRotation);

        btnInicioCombinado = view.findViewById(R.id.btnInicioCombinado);
        btnFinCombinado = view.findViewById(R.id.btnFinCombinado);
        imgAnimCombinado = view.findViewById(R.id.imgAnimCombinado);

        // DESPLAZAMIENTO HORIZONTAL
        btnFinX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimX, "translationX", 200f, DURACION);
            }
        });

        btnInicioX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimX, "translationX", 0f, DURACION);
            }
        });

        // DESPLAZAMIENTO VERTICAL
        btnInicioY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimY, "translationY", 200f, DURACION);
            }
        });

        btnFinY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimY, "translationY", 0f, DURACION);
            }
        });

        // DESVANECIMIENTO
        btnInicioAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimAlpha, "alpha", 0f, DURACION);
            }
        });

        btnFinAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimAlpha, "alpha", 1f, DURACION);
            }
        });

        // ROTACIÓN
        btnFinRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimRotation, "rotation", 90f, DURACION);
            }
        });

        btnInicioRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(imgAnimRotation, "rotation", 0f, DURACION);
            }
        });

        // ANIMACIONES COMBINADAS
        btnFinCombinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animarCombinado(imgAnimCombinado, true, DURACION);
            }
        });

        btnInicioCombinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animarCombinado(imgAnimCombinado, false, DURACION);
            }
        });
    }

    private void animar(View view, String efecto, float valor, int duracion) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, efecto, valor);
        animator.setDuration(duracion);
        animator.start();
    }

    private void animarCombinado(View view, boolean comenzando, int duracion) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator rotacion, traslacion;

        rotacion = ObjectAnimator.ofFloat(view, "rotation", comenzando ? 90f : 0f);
        rotacion.setDuration(duracion);
        animatorSet.play(rotacion);

        traslacion = ObjectAnimator.ofFloat(view, "translationX", comenzando ? 200f : 0f);
        traslacion.setDuration(duracion);
        animatorSet.play(traslacion);

        animatorSet.start();
    }
}
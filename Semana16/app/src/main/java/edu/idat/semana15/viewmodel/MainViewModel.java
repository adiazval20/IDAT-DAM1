package edu.idat.semana15.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.semana15.entity.Persona;
import edu.idat.semana15.repository.PersonaRepository;

public class MainViewModel extends AndroidViewModel {
    private PersonaRepository personaRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        personaRepository = new PersonaRepository(application);
    }

    public LiveData<List<Persona>> listPersonas() {
        return personaRepository.list();
    }

    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }
}

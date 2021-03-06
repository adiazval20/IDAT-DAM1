package edu.idat.semana15.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.semana15.AppDatabase;
import edu.idat.semana15.dao.PersonaDao;
import edu.idat.semana15.entity.Persona;

public class PersonaRepository {
    private PersonaDao dao;

    public PersonaRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        dao = db.personaDao();
    }

    public LiveData<List<Persona>> list() {
        return dao.list();
    }

    public void save(Persona persona) {
        AppDatabase.dbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (persona.getId() == 0) {
                    dao.insert(persona);
                } else {
                    dao.update(persona);
                }
            }
        });
    }
}

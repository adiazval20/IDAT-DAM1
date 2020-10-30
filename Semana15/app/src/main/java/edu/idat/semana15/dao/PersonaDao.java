package edu.idat.semana15.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.idat.semana15.entity.Persona;

@Dao
public interface PersonaDao {
    @Query("SELECT * FROM Persona")
    LiveData<List<Persona>> list();

    @Query("SELECT * FROM Persona WHERE id = :id")
    LiveData<Persona> findById(long id);

    @Insert
    long insert(Persona persona);

    @Insert
    void insertAll(Persona... personas);

    @Update
    void update(Persona persona);

    @Delete
    void delete(Persona persona);
}

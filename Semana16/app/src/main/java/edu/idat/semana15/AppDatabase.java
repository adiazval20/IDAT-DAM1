package edu.idat.semana15;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.idat.semana15.dao.PersonaDao;
import edu.idat.semana15.entity.Persona;

@Database(entities = {Persona.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase appDb;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);

    public abstract PersonaDao personaDao();

    public static AppDatabase getDatabase(Context context) {
        if (appDb == null) {
            synchronized (AppDatabase.class) {
                if (appDb == null) {
                    appDb = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DEMO_DB")
                            .addCallback(initCallback)
                            .build();
                }
            }
        }
        return appDb;
    }

    private static Callback initCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            dbExecutor.execute(new Runnable() {
                @Override
                public void run() {
//                    Persona juan = new Persona("Perez", "Díaz", "Juan");
//                    Persona maria = new Persona("Sanchez", "Cabrera", "María");
//                    Persona alberto = new Persona("Cárdenas", "Reyes", "Alberto");
//
//                    PersonaDao dao = appDb.personaDao();
//                    dao.insert(juan);
//                    dao.insert(maria);
//                    dao.insert(alberto);
                }
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}

package candy.cartel.mynotes.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import candy.cartel.mynotes.Models.Notes;

@Database(entities = {Notes.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {  // В этом файле описан абстрактный класс с единственным методом getInstance, который возвращает данные из БД

    private static RoomDB database;                 // RoomDB - интерфейс, работающий поверх встроенного SQLite API
    private static String DATABASE_NAME = "NoteApp";

    public synchronized static RoomDB getInstance(Context context){
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()   // Делает потоки по работе с БД асинхронными
                    .fallbackToDestructiveMigration()  // Миграция - SQL запрос, который меняет под себя структуру БД
                    .build();
        }
        return database;
    }

    public abstract mainDAO mainDao();
}
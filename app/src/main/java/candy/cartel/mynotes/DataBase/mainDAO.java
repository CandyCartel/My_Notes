package candy.cartel.mynotes.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import candy.cartel.mynotes.Models.Notes;

@Dao // Data Access Object - в этом файле описываются методы для работы с БД
public interface mainDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)  // Метод создания заметки
    void insert (Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")  // Запрос на получение всех заметок
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :id")  // Запрос на обновление данных заметки
    void update(int id, String title, String notes);

    @Delete  // Метод удаления заметки
    void delete (Notes notes);

    @Query("UPDATE notes SET pinned = :pin WHERE ID = :id")   // Метод добавления заметки в избранные
    void pin(int id, boolean pin);
}
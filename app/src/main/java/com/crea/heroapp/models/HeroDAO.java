package com.crea.heroapp.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface HeroDAO {

    @Query("SELECT * FROM hero")
    List<Hero> getAll();

    @Query("SELECT * FROM hero WHERE id like :id")
    List<Hero> loadAllByIds(Long id);

    @Query("SELECT * FROM hero WHERE name LIKE :name")
    List<Hero> findByName(String name);

    @Insert
    void insertAll(List<Hero> heros);

    @Delete
    void delete(Hero hero);

}

package com.crea.heroapp.workers;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.crea.heroapp.models.Hero;
import com.crea.heroapp.models.HeroDAO;

import org.jetbrains.annotations.NotNull;

public class DBManager {

    private AppDatabase appDataBase;
    @Database(entities = {Hero.class}, version = 1)
    public static abstract class AppDatabase extends RoomDatabase {
        public abstract HeroDAO heroDao();
    }

    private static final DBManager instance = new DBManager();

    public static DBManager getInstance() {
        return instance;
    }

    public void initDataBase(@NotNull Application context) {
        this.appDataBase = Room.databaseBuilder(context,
                AppDatabase.class, "hero-db").allowMainThreadQueries().build();
    }

    public AppDatabase getAppDataBase() {
        return appDataBase;
    }
}

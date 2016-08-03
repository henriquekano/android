package com.example.henri_000.fechaaconta.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.henri_000.fechaaconta.R;
import com.example.henri_000.fechaaconta.model.Item;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by henri_000 on 21/08/2015.
 */
public class ItemOpenDatabaseHelper extends OrmLiteSqliteOpenHelper {

    private final static String DATABASE_NAME = "fechaaconta";
    private final static int DATABASE_VERSION = 1;

    private Dao<Item, Long> itemDAO;

    public ItemOpenDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Item.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try{
            TableUtils.dropTable(connectionSource, Item.class, false);
            onCreate(sqLiteDatabase);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Dao<Item, Long> getItemDAO() throws SQLException{
        if(itemDAO == null){
            itemDAO = getDao(Item.class);
        }
        return itemDAO;
    }
}

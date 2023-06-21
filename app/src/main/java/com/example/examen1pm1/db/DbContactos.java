package com.example.examen1pm1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper {

    Context context;

    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaContacto(String pais, String nombre, String telefono, String nota) {
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("pais", pais);
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("nota", nota);
            //values.put("imagen", imagen);

            id = db.insert(TABLE_CONTACTOS, null, values);

        } catch (Exception ex) {
            ex.toString();
        }


        return id;
    }
}
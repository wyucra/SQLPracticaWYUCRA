package com.yucra.willysoft.miaplicacion4.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yucra.willysoft.miaplicacion4.model.AlumnoModel;

/**
 * Created by ariso on 13/05/2017.
 */

public class SQLPracticaDatabaseHelper  extends SQLiteOpenHelper {

    private static  final  String DB_NAME="mydbpractica.db";
    private static  final  Integer DB_VERSION=1;

    private final StringBuffer SQL_CREATE_TABLE_ALUMNO = new StringBuffer()
            .append("CREATE TABLE IF NOT EXISTS "+ AlumnoModel.TABLE_NAME+" ( ")
            .append(AlumnoModel.ID_FIELD+" INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(AlumnoModel.NOMBRES_FIELD+" TEXT, ")
            .append(AlumnoModel.CORREO_FIELD+" TEXT, ")
            .append(AlumnoModel.EDAD_FIELD+" INTEGER ")
            .append(")");

    private static  final StringBuffer SQL_DELETE_TABLE_ALUMNO= new StringBuffer().append("DROP TABLE IF EXISTS "+AlumnoModel.TABLE_NAME);



    public SQLPracticaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(SQL_CREATE_TABLE_ALUMNO.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

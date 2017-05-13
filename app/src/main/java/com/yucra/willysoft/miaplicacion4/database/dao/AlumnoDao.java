package com.yucra.willysoft.miaplicacion4.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.yucra.willysoft.miaplicacion4.database.SQLPracticaDatabaseHelper;
import com.yucra.willysoft.miaplicacion4.model.AlumnoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ariso on 13/05/2017.
 */

public class AlumnoDao {


    private static final String TAG = "AlumnoDao";

    private final String ALL_COLUMNS [] = {AlumnoModel.ID_FIELD,
            AlumnoModel.NOMBRES_FIELD,
            AlumnoModel.CORREO_FIELD,
            AlumnoModel.EDAD_FIELD
           };

    private SQLiteDatabase mSQLiteDatabase;

    public AlumnoDao(Context context) {
        mSQLiteDatabase= new SQLPracticaDatabaseHelper(context).getWritableDatabase();

    }

    public long insertAlumno(AlumnoModel alumnoModel){
        long status = mSQLiteDatabase.insert(AlumnoModel.TABLE_NAME, null, convertAlumnoToContentValues(alumnoModel));
        //En metodo 'insert' retorna un long, podría ser el ID de la fila o -1 si ocurre un error.
        Log.v(TAG,"status = "+status);
        return status;
    }


    private ContentValues convertAlumnoToContentValues(AlumnoModel alumnoModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put(AlumnoModel.NOMBRES_FIELD, alumnoModel.getNombres());
        contentValues.put(AlumnoModel.CORREO_FIELD, alumnoModel.getCorreo());
        contentValues.put(AlumnoModel.EDAD_FIELD, alumnoModel.getEdad());
        return contentValues;
    }



    /*private List<AlumnoModel> convertCursorToList(Cursor mCursor){
        List<AlumnoModel> arrAlumno = new ArrayList<>();
        if (mCursor.moveToFirst()) {
            do {
                ClienteModel clienteItem = new ClienteModel();
                clienteItem.setId(mCursor.getInt(mCursor.getColumnIndex(ClienteModel.ID_FIELD)));
                clienteItem.setNombreCompleto(mCursor.getString(mCursor.getColumnIndex(ClienteModel.NOMBRE_FIELD)));
                clienteItem.setEmail(mCursor.getString(mCursor.getColumnIndex(ClienteModel.EMAIL_FIELD)));
                clienteItem.setTelefono(mCursor.getString(mCursor.getColumnIndex(ClienteModel.TELEFONO_FIELD)));
                clienteItem.setDireccion(mCursor.getString(mCursor.getColumnIndex(ClienteModel.DIRECCION_FIELD)));
                clienteItem.setIdEmpresaCliente(mCursor.getInt(mCursor.getColumnIndex(ClienteModel.ID_EMPRESA_FIELD)));
                clienteItem.setFechNacimiento(mCursor.getString(mCursor.getColumnIndex(ClienteModel.FECHA_NAC_FIELD)));
                clienteItem.setIdEstadoCivil(mCursor.getInt(mCursor.getColumnIndex(ClienteModel.ID_ESTADO_CIVIL_FIELD)));

                //recuperando Integer y convirtiendolo a Booleano.
                Boolean tieneHijos = mCursor.getInt(mCursor.getColumnIndex(ClienteModel.TIENE_HIJOS_FIELD)) == 1;
                clienteItem.setTieneHijos(tieneHijos);

                arrClientes.add(clienteItem);
            }while (mCursor.moveToNext());
        }
        return arrClientes;
    }*/

}

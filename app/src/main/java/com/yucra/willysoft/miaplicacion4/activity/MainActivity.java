package com.yucra.willysoft.miaplicacion4.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yucra.willysoft.miaplicacion4.R;
import com.yucra.willysoft.miaplicacion4.database.dao.AlumnoDao;
import com.yucra.willysoft.miaplicacion4.model.AlumnoModel;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlumnoDao alumnoDao= new AlumnoDao(this);

        AlumnoModel animal1= new AlumnoModel();
        animal1.setNombres("WILLY");
        animal1.setEdad(20);
        animal1.setCorreo("willy@gmail.com");

        AlumnoModel animal2= new AlumnoModel();
        animal1.setNombres("JONHY");
        animal1.setEdad(10);
        animal1.setCorreo("johny@gmail.com");


        long estado= alumnoDao.insertAlumno(animal1);
        long estado2= alumnoDao.insertAlumno(animal2);

        Log.d(TAG,"resultado del alumno 1:"+estado);
        Log.d(TAG,"resultado del alumno 2:"+estado2);

    }
}

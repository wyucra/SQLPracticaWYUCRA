package com.yucra.willysoft.miaplicacion4.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ariso on 13/05/2017.
 */

public class AlumnoModel implements Parcelable {


    public static  final String TABLE_NAME="alumno";

    public static  final String ID_FIELD="idAlumno";

    public static  final String CORREO_FIELD="correo";

    public static  final String EDAD_FIELD="edad";

    public static  final String NOMBRES_FIELD="nombres";

    private Integer idAlumno;
    private String nombres;
    private String correo;
    private Integer edad;

    @Override
    public String toString() {
        return "AlumnoModel{" +
                "idAlumno=" + idAlumno +
                ", nombres='" + nombres + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                '}';
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idAlumno);
        dest.writeString(this.nombres);
        dest.writeString(this.correo);
        dest.writeValue(this.edad);
    }

    public AlumnoModel() {
    }

    protected AlumnoModel(Parcel in) {
        this.idAlumno = (Integer) in.readValue(Integer.class.getClassLoader());
        this.nombres = in.readString();
        this.correo = in.readString();
        this.edad = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<AlumnoModel> CREATOR = new Parcelable.Creator<AlumnoModel>() {
        @Override
        public AlumnoModel createFromParcel(Parcel source) {
            return new AlumnoModel(source);
        }

        @Override
        public AlumnoModel[] newArray(int size) {
            return new AlumnoModel[size];
        }
    };
}

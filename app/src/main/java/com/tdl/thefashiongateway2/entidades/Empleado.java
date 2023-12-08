package com.tdl.thefashiongateway2.entidades;

public class Empleado {
    private int id_empleado;
    private String nombre_empleado;
    private String apellidos_empleado;
    private String tlf_empleado;
    private String correo_empleado;
    private String clave_empleado;

    //Constructor
    public Empleado(int id_empleado, String nombre_empleado, String apellidos_empleado, String tlf_empleado, String correo_empleado, String clave_empleado) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellidos_empleado = apellidos_empleado;
        this.tlf_empleado = tlf_empleado;
        this.correo_empleado = correo_empleado;
        this.clave_empleado = clave_empleado;
    }

    //Getters y Setters
    public int getId_empleado() {
        return id_empleado;
    }
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }
    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellidos_empleado() {
        return apellidos_empleado;
    }
    public void setApellidos_empleado(String apellidos_empleado) {
        this.apellidos_empleado = apellidos_empleado;
    }

    public String getTlf_empleado() {
        return tlf_empleado;
    }
    public void setTlf_empleado(String tlf_empleado) {
        this.tlf_empleado = tlf_empleado;
    }

    public String getCorreo_empleado() {
        return correo_empleado;
    }
    public void setCorreo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    public String getClave_empleado() {
        return clave_empleado;
    }
    public void setClave_empleado(String clave_empleado) {
        this.clave_empleado = clave_empleado;
    }
}

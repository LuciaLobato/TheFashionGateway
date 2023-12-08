package com.tdl.thefashiongateway2.entidades;

public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private String apellidos_cliente;
    private String tlf_cliente;
    private String correo_cliente;
    private String clave_cliente;

    //Constructor
    public Cliente(int id_cliente, String nombre_cliente, String apellidos_cliente, String tlf_cliente, String correo_cliente, String clave_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellidos_cliente = apellidos_cliente;
        this.tlf_cliente = tlf_cliente;
        this.correo_cliente = correo_cliente;
        this.clave_cliente = clave_cliente;
    }

    //Getters y Setters
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellidos_cliente() {
        return apellidos_cliente;
    }
    public void setApellidos_cliente(String apellidos_cliente) {
        this.apellidos_cliente = apellidos_cliente;
    }

    public String getTlf_cliente() {
        return tlf_cliente;
    }
    public void setTlf_cliente(String tlf_cliente) {
        this.tlf_cliente = tlf_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }
    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getClave_cliente() {
        return clave_cliente;
    }
    public void setClave_cliente(String clave_cliente) {
        this.clave_cliente = clave_cliente;
    }

}

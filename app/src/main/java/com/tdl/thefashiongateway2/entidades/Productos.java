package com.tdl.thefashiongateway2.entidades;

import android.graphics.Bitmap;

import com.mysql.cj.jdbc.Blob;

public class Productos {
    //ATRIBUTOS:
    private int id;
    private String nombre;
    private String grupo;
    private String tipo;
    private String color;
    private float precio;
    private int rebaja;
    private byte[] imagen1;
    private Bitmap imagen2;

    //CONSTRUCTORES:
    public Productos(int id, String nombre,String grupo, String tipo, String color,float precio,int rebaja, byte[] imagen1,Bitmap imagen2){
        this.id=id;
        this.nombre = nombre;
        this.grupo = grupo;
        this.tipo = tipo;
        this.color = color;
        this.precio = precio;
        this.rebaja = rebaja;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
    }
    public Productos(){}

    //PROPIEDADES:
    //ID:
    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }

    //Nombre:
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Grupo:
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    //Tipo:

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Color:
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //Precio:
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    //Rebaja:
    public int getRebaja() {
        return rebaja;
    }
    public void setRebaja(int rebaja) {
        this.rebaja = rebaja;
    }

    //Imagen1:
    public byte[] getImagen1() {
        return imagen1;
    }
    public void setImagen1(byte[] imagen1) {
        this.imagen1 = imagen1;
    }

    //Imagen2:
    public Bitmap getImagen2() {
        return imagen2;
    }
    public void setImagen2(Bitmap imagen2) {
        this.imagen2 = imagen2;
    }
}

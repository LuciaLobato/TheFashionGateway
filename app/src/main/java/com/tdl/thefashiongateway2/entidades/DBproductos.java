package com.tdl.thefashiongateway2.entidades;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.Nullable;
import java.util.ArrayList;

public class DBproductos extends DbHelper {
    Context context;

    public DBproductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProducto(String nombre, String detalle, String imagen) {
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWriteableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("descripcion", detalle);
            values.put("imagen", imagen);
            id = db.insert("TABLE_PRODUCTOS", null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    ///Metodo q nos trae en un arraylist todos los datos de la tabla Productos:
    public ArrayList<Productos> mostrarProductos() {
        ArrayList<Productos> listaProductos = new ArrayList<>();

        //CONEXION A LA BASE DE DATOS:

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWriteableDatabase();


        Productos producto = null;

        //Consulta a la base de datos por todos los productos:
        Cursor cursorProductos = null;
        cursorProductos = db.rawQuery("SELECT * FROM PRODUCTOS", null);
        if (cursorProductos.moveToFirst()) {
            do {
                producto = new Productos();
                producto.setId(cursorProductos.getInt(0));
                producto.setNombre(cursorProductos.getString(1));
                producto.setGrupo(cursorProductos.getString(2));
                producto.setTipo(cursorProductos.getString(3));
                producto.setColor(cursorProductos.getString(4));
                producto.setPrecio(cursorProductos.getFloat(5));
                producto.setRebaja(cursorProductos.getInt(6));
                //producto.setImagen2(cursorProductos.getBlob(7));
                listaProductos.add(producto);
            } while (cursorProductos.moveToNext());
        }
        cursorProductos.close();
        return listaProductos;




/*
        byte[] imagenGenerica_Blob= new byte[900]; //imagen BLOB
        Bitmap imagenGenerica_BitMap = BitmapFactory.decodeByteArray(imagenGenerica_Blob, 0, imagenGenerica_Blob.length); //imagen Bitmap

        //Creo un par de productos manualmente para pruebas:
        producto= new Productos();
        producto.setId(1);
        producto.setNombre("Camisa Vila1");
        producto.setDescripcion("Camisa femenina talla XL");
        producto.setImagen1(imagenGenerica_Blob);
        producto.setImagen2(imagenGenerica_BitMap);
        producto.setPrecio(25.03f);
        listaProductos.add(producto);

        producto= new Productos(2,"pantalón","pantalón corto, talla S",10.50f, null, null);
        listaProductos.add(producto);


        return listaProductos;

 */

    }

}

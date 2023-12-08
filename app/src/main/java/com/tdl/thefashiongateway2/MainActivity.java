package com.tdl.thefashiongateway2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.tdl.thefashiongateway2.entidades.DBproductos;
import com.tdl.thefashiongateway2.entidades.Productos;
import com.tdl.thefashiongateway2.adaptadores.ListaProductosAdapter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //ATRIBUTOS:
    RecyclerView listaProductos;
    ArrayList<Productos> listaArrayProductos;
    ImageView imgOpciones;

    //RESPUESTA A EVENTOS:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaProductos= findViewById(R.id.listaProductos);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DBproductos dbProductos = new DBproductos(MainActivity.this);
        listaArrayProductos = new ArrayList<>();

        ListaProductosAdapter adapter = new ListaProductosAdapter(dbProductos.mostrarProductos());
        listaProductos.setAdapter(adapter);

        imgOpciones = (ImageView)  findViewById(R.id.imgOciones);
        imgOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, imgOpciones);
                popup.getMenuInflater().inflate(R.menu.menu_opciones, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId()==R.id.itemDatosUsuario){
                            Toast.makeText(MainActivity.this, "Datos Usuario", Toast.LENGTH_SHORT).show();
                        }else if (item.getItemId()==R.id.itemCarrito){
                            Toast.makeText(MainActivity.this, "Carrito", Toast.LENGTH_SHORT).show();
                        }else if (item.getItemId()==R.id.itemPedidos){
                            Toast.makeText(MainActivity.this, "Pedidos", Toast.LENGTH_SHORT).show();
                        }else if (item.getItemId()==R.id.itemTienda){
                            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        }else if (item.getItemId()==R.id.itemSalir){
                            finish();
                        }
                        return true;
                    }
                });

                popup.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if (item.getItemId()==R.id.itemDatosUsuario){
            Toast.makeText(this, "Datos Usuario", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.itemCarrito){
            Toast.makeText(this, "Carrito", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.itemPedidos){
            Toast.makeText(this, "Pedidos", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.itemTienda){
            Toast.makeText(this, "Tienda", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.itemSalir){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }





//    lblregistrar.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//            startActivity(i);
//
//        }
//    });






/*    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }*/

/*    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id menuNuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }*/
}
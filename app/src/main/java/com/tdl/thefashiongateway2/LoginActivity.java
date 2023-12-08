package com.tdl.thefashiongateway2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tdl.thefashiongateway2.Connection.ConnectionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    ///ATRIBUTOS:
    EditText usuario, clave;
    TextView lblregistrar;
    TextView lblsaltariniciosesion;
    Button btningresar;
    Connection con;
    Connection con2;
    String ConnectionResult="";

    ///CONSTRUCTOR:
    public LoginActivity() {
        ConnectionBD instanceConnection= new ConnectionBD();
        con= instanceConnection.connect_toSQL();

    }

    public void GetTextFromSQL(){
//        try{
//            ConnectionHelper connectiolHelper= new ConnectionHelper();
//            con2=connectiolHelper.conectionClass();
//            if(con2!=null){
//                String query = "Select * from clientes";
//                Statement st=con2.createStatement();
//                ResultSet rs=st.executeQuery(query);
//                while(rs.next())
//                {
//                    String tx1=rs.getString(1);
//                    String tx2=rs.getString(2);
//                }
//            }else{
//                ConnectionResult="Check Connection";
//            }
//
//        }catch (Exception ex){
//        }
    }

    ///RESPUESTAS A EVENTOS de android:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usuario=(EditText)  findViewById(R.id.txtusuario);
        clave=(EditText)  findViewById(R.id.txtclave);
        lblregistrar=(TextView)  findViewById(R.id.lblregistrar);
        lblsaltariniciosesion=(TextView)  findViewById(R.id.lblsaltariniciosesion);
        btningresar=(Button)  findViewById(R.id.btningresar);

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginActivity.login().execute("");

            }
        });
        lblregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);

            }
        });
        lblsaltariniciosesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.configuracion){
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                startActivity(i);
//            }
        }
        if (id==R.id.info){
            Toast.makeText(this, "Información: App de Lucía. Visite www.thefashiongateway.com", Toast.LENGTH_LONG).show();
            return true;}
        if (id==R.id.salir){ finish();}

        return super.onOptionsItemSelected(item);
    }


    ///OTRAS FUNCIONES:
    public class login extends AsyncTask<String,String,String>{
        ///ATRIBUTOS:
        String z=null;
        Boolean exito=false;


        ///RESPUESTAS A EVENTOS:
        @Override protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override protected void onPostExecute(String s){
            super.onPostExecute(s);
        }

        @Override protected String doInBackground(String... strings) {

            if (con == null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "Verifique su conexión", Toast.LENGTH_SHORT).show();
                    }
                });
                z="En Conexión";
            }
            else{
                try{
                    String sql= "SELECT * FROM clientes WHERE email = '"+ usuario.getText()+"' AND password = '"+ clave.getText()+ "'";
                    Statement stm = con.createStatement();
                    ResultSet rs= stm.executeQuery(sql);

                    if (rs.next()){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "Acceso exitoso", Toast.LENGTH_SHORT).show();
                                Intent menu = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(menu);
                            }
                        });

                        usuario.setText("");
                        clave.setText("");
                    }
                    else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "error en el usuario o contraseña", Toast.LENGTH_SHORT).show();
                            }
                        });
                        usuario.setText("");
                        clave.setText("");
                    }

                }catch (Exception e){
                    exito=false;
                    Log.e("ERROR DE CONEXIÓN : ", e.getMessage());
                }
            }


            return null;
        }
    }




}
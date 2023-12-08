package com.tdl.thefashiongateway2.Connection;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBD {
    @SuppressLint("NewApi")
    public Connection connect_toSQL(){
        //BD SQL Server en Azure(portal.azure.com), con la cuenta de tedelia@outlook.es
        //      Servidor:    tiendatfg.database.windows.net
        //      Usar autenticación SQL : lucia    <Aicul_567>
         String host= "tiendatfg.database.windows.net";
        // host="52.236.184.163:1433";    //de Azure de JESUS
        host="lucia.database.windows.net:1433";//De Azure de LUCIA
         //String usuario="lucia@tiendatfg"; //jesus
        String usuario="LuciaLS@lucia";//lucia
         String password="Lucia1234";
         //String basedatos="tiendatfg"; //jesus
        String basedatos="TheFashionGateway";

        Connection connection = null;
        String connectionURL=null;

        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            //connectionURL="jdbc:jtds:sqlserver://"+ host+"/"+basedatos + ";user=" + usuario +";password=" + password + ";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            //connectionURL="jdbc:sqlserver://"+ host+";database="+basedatos + ";user=" + usuario +";password=" + password + ";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connectionURL="jdbc:jtds:sqlserver://"+ host+"/"+basedatos + ";user=" + usuario +";password=" + password + ";ssl=request";
            //connectionURL="jdbc:jtds:sqlserver://tiendatfg.database.windows.net:1433;database=tiendatfg;user=lucia@tiendatfg;password={Aicul_567};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection= DriverManager.getConnection(connectionURL);
            Log.e("Conexión SQL correcta :",connectionURL);
        }catch (Exception e){
            e.printStackTrace();
            Log.i("Error de conexión SQL", e.getMessage());
        }

        return connection;
    }

    @SuppressLint("NewApi")
    public Connection connect_toSQL2(){
        //BD SQL Server en Azure(portal.azure.com), con la cuenta de tedelia@outlook.es
        //      Servidor:    tiendatfg.database.windows.net
        //      Usar autenticación SQL : lucia    <Aicul_567>
        String host= "tiendatfg.database.windows.net";
        host="52.236.184.163";
        String port="1433";
        String usuario="lucia@tiendatfg"; //  ó "lucia" ó "sa"
        String password="Aicul_567"; //ó la password de sa
        String basedatos="tiendatfg";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL=null;

        try{
            Class.forName("com.microsoft.sqlserver.jdbc");
            //Class.forName("net.sourceforge.jtds.jdbc.Driver");
            //connectionURL="jdbc:jtds:sqlserver://"+ host+"/"+basedatos + ";user=" + usuario +";password=" + password + ";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            //connectionURL="jdbc:sqlserver://"+ host+";database="+basedatos + ";user=" + usuario +";password=" + password + ";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            //connectionURL="jdbc:jtds:sqlserver://"+ host+"/"+basedatos + ";user=" + usuario +";password=" + password + ";";
            //connectionURL= "jdbc:jtds:sqlserver://"+host+":"+port+";"+"databasename="+basedatos+";user="+usuario+";password="+password+";";
            connectionURL="jdbc:sqlserver://tiendatfg.database.windows.net:1433;database=tiendatfg;user=lucia@tiendatfg;password={Aicul_567};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection= DriverManager.getConnection(connectionURL);
        }catch (Exception e){
            e.printStackTrace();
            Log.e("Error de conexión SQL", e.getMessage());
        }

        return connection;
    }

    @SuppressLint("NewApi")
    public Connection connect_toMySQL(){
        String host= "lucia1.mysql.database.azure.com:3306";
        String usuario="lucia";
        String password="Aicul_567";
        String basedatos="tienda";

        Connection connection = null;
        String connectionURL1=null;
        String connectionURL2=null;

        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("com.mysql.jdbc.Driver");
            //connectionURL1="jdbc:mysql//"+ this.host+"/"+this.basedatos + ";user=" + this.usuario +";password=" + this.password + ";";
            //connection= DriverManager.getConnection(connectionURL1);
            connectionURL2="jdbc:mysql//"+ host+"/"+basedatos;
            connection= DriverManager.getConnection(connectionURL2,usuario,password);
        }catch (Exception e){
            e.printStackTrace();
            Log.e("Error de conexión SQL", e.getMessage());
        }

        return connection;
    }

}

package com.example.animals;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;


public class DataBaseConnection {
    public Connection dataBaseLink;

    public Connection getConnection(){
         String dataBaseUser="sa";
        String dataBasePassword="1234";
        String url="jdbc:sqlserver://localhost:1433;databaseName=animals";
    try{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    dataBaseLink=DriverManager.getConnection(url,dataBaseUser,dataBasePassword);
     }catch (Exception e){
    e.printStackTrace();
    e.getMessage();
    }
    return dataBaseLink;
    }

}

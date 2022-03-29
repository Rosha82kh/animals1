package com.example.animals;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExcuteProcedure {

    public Connection dataBaseLink;

    public Connection getConnection(){
        String dataBaseName=" ";
        String dataBaseUser="sa";
        String dataBasePassword="1234";
        String url="jdbc:sqlserver://localhost:1433;databaseName=animals";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataBaseLink= DriverManager.getConnection(url,dataBaseUser,dataBasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return dataBaseLink;
    }

    public void EXECUTE_insert_customer () throws SQLException {
        try {
            getConnection();
            String sql=(" insert into customer values (?,?,?,?)");
            CallableStatement cs = dataBaseLink.prepareCall(sql);
            cs.setInt(1,232);
            cs.setString(2,"rowaa1");
            cs.setString(3,"Padborg2");
            cs.setString(4,"9998283");
            cs.execute();
            System.out.print("customer table updated successfully\n");
        }catch (SQLException se){
            se.getMessage();
        }
    }
    public void EXECUTE_insert_pet () throws SQLException {
        try {
            getConnection();
            String sql=("insert into pet values (?,?)");
            CallableStatement cs = dataBaseLink.prepareCall(sql);
            cs.setInt(1,32);
            cs.setInt(2,664);
            cs.execute();
            System.out.print("pet table updated successfully\n");
        }catch (SQLException se){
            se.getMessage();
        }


    }

    public void EXECUTE_insert_booking () throws SQLException {
        try {
            getConnection();
            String sql=("insert into booking values (?,?,?,?,?)");
            CallableStatement cs = dataBaseLink.prepareCall(sql);
            cs.setInt(1,531);
            cs.setInt(2,555);
            cs.setInt(3,666);
            cs.setInt(4,5432);
            cs.setInt(5,2211);

            cs.execute();
            System.out.print("booking table updated successfully\n");
        }catch (SQLException se){
            se.getMessage();
        }

    }
    public  void Excute_vacant_cage_week(){
        try {
            getConnection();
            String sql=("SELECT count(cageNo) AS vacantCage\n" +
                    "FROM booking\n" +
                    "WHERE weekNo=?");
            String SQL1=(" set @value=(SELECT count(@cageNo) AS vacantCage\n" +
                    "FROM booking\n" +
                    "WHERE @weekNo=12)\n" +
                    " return @value");
            CallableStatement cs = dataBaseLink.prepareCall(sql);
            cs.setInt(6,12);

            cs.execute();
            System.out.print("vacant cage ="+ "");
        }catch (SQLException se){
            se.getMessage();
        }
    }

    public static void main(String[] args) throws SQLException {
        ExcuteProcedure ep=new ExcuteProcedure();
       // ep.EXECUTE_insert_booking();
       // ep.EXECUTE_insert_customer();
       // ep.EXECUTE_insert_pet();
        ep.Excute_vacant_cage_week();
    }
}

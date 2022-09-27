package com.deneme.BosturDeneyebilirsin.jdbc;

import com.deneme.BosturDeneyebilirsin.entity.AdresDTO;
import com.deneme.BosturDeneyebilirsin.entity.UserAdresDTO;

import java.sql.*;
import java.util.*;

public class JdbcDbConnector {


    static List<AdresDTO> adresler=new ArrayList<>();
    static Map<Long,Object> adres=new HashMap<>();
    static Map<Long,Object> kisi=new HashMap<>();
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //System.out.println(getAdres());
        //getUserUndAdres(15);
        getUser(10);
    }


    public List<String> getUserUndAdres1(int id) throws ClassNotFoundException, SQLException {

        List<String> sonuc=new ArrayList<>();
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/denemedb","postgres","123456");
        Statement statement=connection.createStatement();
        Connection connection1= DriverManager.getConnection("jdbc:postgresql://localhost:5432/gitdb","postgres","123456");
        Statement statement1=connection1.createStatement();

        ResultSet resultSet=statement.executeQuery("SELECT * from adreses WHERE id="+id);

        ResultSet resultSet1=statement1.executeQuery("SELECT * from users WHERE id="+id);

        while (resultSet.next()){
            sonuc.add("adres id: "+(resultSet.getString("id")));
            sonuc.add("sokak: "+(resultSet.getString("sokak")));

        }

        while (resultSet1.next()){
            sonuc.add("user id: "+(resultSet1.getString("id")));
            sonuc.add("Isim: "+resultSet1.getString("isim"));
        }
        connection.close();
        statement.close();
        resultSet.close();
        connection1.close();
        statement1.close();
        resultSet1.close();
        return sonuc;

    }

    public static void  getUser(int id) throws ClassNotFoundException, SQLException{

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/gitdb","postgres","123456");
        Statement statement=connection.createStatement();

        ResultSet resultSet=statement.executeQuery("SELECT * from users where id="+id);

        while (resultSet.next()){
            System.out.println("Isim: "+resultSet.getString("isim"));
        }


        connection.close();
        statement.close();
        resultSet.close();

    }
    public static List<AdresDTO> getAdres() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/denemedb","postgres","123456");
        Statement statement=connection.createStatement();


        ResultSet resultSet=statement.executeQuery("SELECT * from adreses");

        while (resultSet.next()){

            AdresDTO adresDTO=new AdresDTO(resultSet.getLong("id"),resultSet.getString("sokak"),resultSet.getString("zip"),resultSet.getString("sehir"),resultSet.getString("ulke"));
             adresler.add(adresDTO);
        }

        connection.close();
        statement.close();
        resultSet.close();
        return adresler;
    }

    public UserAdresDTO getUserUndAdres(int id) throws  SQLException {
        AdresDTO adresDTO = null;
        UserAdresDTO userAdresDTO = null;

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/denemedb","postgres","123456");
        Statement statement=connection.createStatement();
        Connection connection1= DriverManager.getConnection("jdbc:postgresql://localhost:5432/gitdb","postgres","123456");
        Statement statement1=connection1.createStatement();

        ResultSet resultSet=statement.executeQuery("SELECT * from adreses WHERE id="+id);

        ResultSet resultSet1=statement1.executeQuery("SELECT * from users WHERE id="+id);

        while (resultSet.next()){
            adresDTO=new AdresDTO(resultSet.getLong("id"),resultSet.getString("sokak"),resultSet.getString("zip"),resultSet.getString("sehir"),resultSet.getString("ulke"));
            adres.put(resultSet.getLong("id"),adresDTO);

        }

        while (resultSet1.next()){
            userAdresDTO=new UserAdresDTO(resultSet1.getLong("id"),resultSet1.getString("isim"),resultSet1.getString("soyIsim"),resultSet1.getString("adres"), resultSet1.getString("telefon"), resultSet1.getString("email"), resultSet1.getString("securityNumber"), resultSet1.next(), resultSet1.getLong("bookId"),adresDTO );
            kisi.put(resultSet1.getLong("id"),userAdresDTO);
        }
        connection.close();
        statement.close();
        resultSet.close();
        connection1.close();
        statement1.close();
        resultSet1.close();
        return userAdresDTO;

    }



}

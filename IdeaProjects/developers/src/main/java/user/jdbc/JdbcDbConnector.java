package user.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import user.entity.AdresDTO;

public class JdbcDbConnector {


    static List<AdresDTO> adresler=new ArrayList<>();
    static Map<String,String> adres=new HashMap<>();
    static Map<Long,Object> kisi=new HashMap<>();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getUserUndAdres1(1L));
        //getUserUndAdres(15);
        // getUser(10);
        //getAdresById(10L);
    }


    public static List<String> getUserUndAdres1(Long id) throws ClassNotFoundException, SQLException {

        List<String> sonuc=new ArrayList<>();
        Connection connection= DriverManager.getConnection("jdbc:postgresql://ec2-3-214-2-141.compute-1.amazonaws.com:5432/dcpm0vnc99o1id","vyypcekxbxdhuh","14e227d094171f74b9f876b082386ad94cf0e354c9f69407b28ac542bfde75df");
        Statement statement=connection.createStatement();
        Connection connection1= DriverManager.getConnection("jdbc:postgresql://ec2-3-214-2-141.compute-1.amazonaws.com:5432/dcpm0vnc99o1id","vyypcekxbxdhuh","14e227d094171f74b9f876b082386ad94cf0e354c9f69407b28ac542bfde75df");
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

    public static void  getUser(Long id) throws ClassNotFoundException, SQLException{

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
   /* public static List<AdresDTO> getAdres() throws SQLException {
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
    }*/

    public static AdresDTO getAdresById(Long id) throws  SQLException {

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/denemedb","postgres","123456");
        Statement statement=connection.createStatement();

        ResultSet resultSet=statement.executeQuery("SELECT * from adreses WHERE id="+id);


        while (resultSet.next()){
            adres.put("id", String.valueOf((resultSet.getLong("id"))));
            adres.put("sokak",resultSet.getString("sokak"));
            adres.put("zip",resultSet.getString("zip"));
            adres.put("sehir",resultSet.getString("sehir"));
            adres.put("ulke",resultSet.getString("ulke"));

        }

        AdresDTO adresDTO=new AdresDTO((adres.get("id")), adres.get("sokak"),  adres.get("zip"),  adres.get("sehir"), adres.get("ulke"));

        connection.close();
        statement.close();
        resultSet.close();

        return adresDTO;

    }



}

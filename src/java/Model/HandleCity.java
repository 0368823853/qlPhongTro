/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import DAO.City;
import Model.KiemTraKetNoiDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Nguyen Khanh
 */
public class HandleCity {
    private Connection connect;
    public HandleCity () {
        connect = KiemTraKetNoiDB.ConnectDB();
    }
    public ArrayList<City> getAllProduct () throws SQLException {
        try {
            ArrayList<City> dsData =  new ArrayList<City>();
            String sql = "SELECT * FROM dbsv";
            Statement st = connect.createStatement();
           ResultSet result =  st.executeQuery(sql);
           while (result.next()) {
               City city = new City(result.getInt(1), result.getString(2), result.getString(3), result.
                       getString(4), result.getString(5), result.getString(6), result.getString(7));
               dsData.add(city);
           }
           return dsData;
        }catch(Exception ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public boolean insert(City cty) {
        try {
             String sql = String.format("insert into dbsv values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", cty.getID(),
                     cty.getHoten(), cty.getEmail(), cty.getDiachi(), cty.getToan(), cty.getVan(), cty.getAnh());
              Statement st = connect.createStatement();
              return  st.executeUpdate(sql) > 0;
        }catch(Exception ex) {
            System.out.print(ex);
            return false;
        }
    }
   public boolean update(City cty) {
        try {
             String sql = String.format("update dbsv set hoten = '%s',  email = '%s', diachi = '%s', toan = '%s', van = '%s', anh = '%s' where id = '%s' ",
                     cty.getHoten(), cty.getEmail(), cty.getDiachi(), cty.getToan(), cty.getVan(), cty.getAnh(), cty.getID());
              Statement st = connect.createStatement();
              return  st.executeUpdate(sql) > 0;
        }catch(Exception ex) {
            System.out.print(ex);
            return false;
        }
    }
     public boolean delete(String id) {
        try {
             String sql = String.format("delete from dbsv where id = '%s'",  id);
              Statement st = connect.createStatement();
              return  st.executeUpdate(sql) > 0;
        }catch(Exception ex) {
            System.out.print(ex);
            return false;
        }
    }
    
        public City getCityById(String id) {
        City city = null;
        try {
              String sql = String.format("SELECT * from dbsv where id = '%s'",  id);
              Statement st = connect.createStatement();
              ResultSet result =  st.executeQuery(sql); 
            if (result.next()) {
                city = new City();
                city.setID(result.getInt(1));
                city.setHoten(result.getString(2));
                city.setEmail(result.getString(3));
                city.setDiachi(result.getString(4));
                city.setToan(result.getString(5));
                city.setVan(result.getString(6));
                city.setAnh(result.getString(7));                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return city;
    }

    
     
}

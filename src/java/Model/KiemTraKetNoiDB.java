/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nguyen Khanh
 */
public class KiemTraKetNoiDB {
     private static  java.sql.Connection conn;
      public static java.sql.Connection ConnectDB() {
         try { 
             Class.forName("com.mysql.jdbc.Driver"); 
             conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien?useSSL=false", "root", "123456@Ab");
             System.out.println("Connect Done");
             return conn;
        }catch(Exception e) {
            e.printStackTrace();
        }
         return null;
    }
    
    public static void main(String[] args) {
        Connection conn = KiemTraKetNoiDB.ConnectDB();
        if (conn != null){
            System.out.println("Ket noi SQL thanh cong");
        }
        else{
            System.out.println("ERO");
        }
    }
}

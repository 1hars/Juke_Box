package Juke_Box.DB;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection cn;
    public Connection getConnection(){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Juke_box","root","root");
            //System.out.println("Connection");
        }
        catch(Exception ee){
            System.out.println("Not connection");
        }
        return cn;
    }

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        db.getConnection();
    }
}

import java.sql.*;
import java.io.*;
public class j4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/db";
            String uname="root";
            String password="beast";
            Connection con=DriverManager.getConnection(url, uname, password);
            String q="insert into img(pic) values(?)";
            PreparedStatement ps=con.prepareStatement(q);
            FileInputStream fs=new FileInputStream("F:\\Lokesh\\Image\\l13.jpg");
            ps.setBinaryStream(1,fs,fs.available());
            ps.executeUpdate();
            System.out.println("inserted");
            con.close();
        } catch (Exception e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }
    }
}

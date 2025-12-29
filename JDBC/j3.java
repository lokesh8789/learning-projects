import java.sql.*;
import java.util.Scanner;;
public class j3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/db";
            String uname="root";
            String password="beast";
            Connection con=DriverManager.getConnection(url, uname, password);
            String q="insert into table1(tName,tCity)values(?,?)";
            //get the PreparedStatement Object
            PreparedStatement ps=con.prepareStatement(q);
            //set values to query
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Name: ");
            String name=sc.nextLine();
            System.out.println("Enter City: ");
            String city=sc.nextLine();
            ps.setString(1, name);
            ps.setString(2, city);
            ps.executeUpdate();
            System.out.println("inserted");
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

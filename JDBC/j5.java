import java.sql.*;
import java.util.Scanner;
public class j5 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/db";
            String uname="root";
            String password="beast";
            Connection con=DriverManager.getConnection(url, uname, password);
            String q="update table1 set tName=?,tCity=? where tId=?";
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Name");
            String name=sc.nextLine();
            System.out.println("Enter city");
            String city=sc.nextLine();
            System.out.println("Enter ID");
            int id=sc.nextInt();
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,name);
            ps.setString(2, city);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("updated");
            sc.close();
            con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

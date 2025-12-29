import java.sql.*;
class j1{
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //creating a connection
            String url="jdbc:mysql://localhost:3306/db";
            String uname="root";
            String password="beast";
            Connection con=DriverManager.getConnection(url, uname, password);
            if(con.isClosed())
            {
                System.out.println("Connection is closed");
            }
            else 
            {
                System.out.println("Connection is open");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
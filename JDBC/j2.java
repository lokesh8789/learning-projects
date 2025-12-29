import java.sql.*;

public class j2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/db";
            String uname="root";
            String password="beast";
            Connection con=DriverManager.getConnection(url, uname, password);

            //create a query
            String q="create table table1(tId int(20) primary key auto_increment,tName varchar(200) not null,tCity varchar(400))";
            //create a statement
            Statement st=con.createStatement();
            st.executeUpdate(q);
            System.out.println("table created");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

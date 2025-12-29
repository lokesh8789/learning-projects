import java.sql.*;
public class j6 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/db";
            String uname="root";
            String password="beast";
            Connection con=DriverManager.getConnection(url, uname, password);
            String q="select * from table1";
            Statement st=con.createStatement();
            ResultSet set=st.executeQuery(q);
            while(set.next())
            {
                int id=set.getInt(1);
                String name=set.getString(2);
                String city=set.getString(3);
                System.out.println(id+" : "+name+" : "+city);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

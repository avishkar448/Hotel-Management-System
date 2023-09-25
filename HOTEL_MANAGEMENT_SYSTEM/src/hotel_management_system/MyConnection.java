package hotel_management_system;

import java.sql.*;

public class MyConnection {

    Connection conn;
    Statement stmt;
    MyConnection(){
        try{
            // Class.forName("com.mysql.cj.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/hotel_management_system";
            String username="root";
            String password="9730328530";

            conn=DriverManager.getConnection(url,username,password);

            stmt=conn.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
}

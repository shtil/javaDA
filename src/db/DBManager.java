package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shtil on 10.06.14.
 */
public class DBManager {

    public  DBManager(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
           // Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/cake", "root", "shtil27101988");
       /* return  DriverManager.getConnection("jdbc:mysql://localhost/java?" +
                "user=root&password=shtil27101988");*/
    }

    public List<User> getAllUsers (){

        List<User> result = new ArrayList<>();

        try(
                Connection c = getConnection();
              //  Statement st = c.createStatement();
              PreparedStatement prst = c.prepareStatement("SELECT * FROM posts;");

        ){
           ResultSet rs = prst.executeQuery();

            System.out.println(rs.getRow());

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setName(rs.getString(3));
                user.setEmail(rs.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


        return result;
    }

}

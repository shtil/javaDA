package db;

import java.util.List;

/**
 * Created by shtil on 10.06.14.
 */
public class Application {

    private static DBManager dbManager = new DBManager();

    public static void main(String[] args) {
        List<User> users = dbManager.getAllUsers();

        for (User user: users){
            System.out.println(user);
        }
    }

}

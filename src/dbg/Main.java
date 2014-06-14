package dbg;

/**
 * Created by shtil on 11.06.14.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}

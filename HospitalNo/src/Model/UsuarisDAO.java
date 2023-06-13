package Model;

import java.lang.invoke.StringConcatFactory;
import java.sql.*;

public class UsuarisDAO {
    private static final String DB_URL = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWD = "";


    public static String getUserPassword(String user) {
        Connection dbconnection = null;
        Statement statement = null;
        ResultSet result = null;
        String sql;
        String pass="";

        try {
            dbconnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = dbconnection.createStatement();
            sql = "SELECT contrasena FROM Usuaris WHERE Usuario= '" + user + "'";

            result = statement.executeQuery(sql);
            while (result.next()){
                pass = result.getString("contrasena");
            }

            result.close();
            statement.close();
            dbconnection.close();


        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        return pass;

    }
}

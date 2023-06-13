package Model;

import java.sql.*;
import java.util.ArrayList;

public class InfermerDAO {

    private static final String DB_URL = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWD = "";
    public static boolean addInfermer(Infermer inf){

        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();
            sql= "INSERT INTO Infermeres VALUES('" +inf.getNif()+"','"+inf.getNom()+"','"+inf.getCognoms()+"','"+inf.getCorreu()+"','"+inf.getHorari_de_feina()+"','"+inf.getTelefon()+"')";

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1;
    }
    public static boolean removeInfermer(String nif){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "DELETE FROM Infermeres WHERE nif ='" + nif+"'";

            System.out.println(sql);
            nrows=statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1 ;
    }

    public static ArrayList<Infermer> getInfermers(){
        ArrayList<Infermer> infermers= new ArrayList<>();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "SELECT * FROM Infermeres";

            result= statement.executeQuery(sql);

            while(result.next()){
                Infermer inf= new Infermer();
                inf.setNif(result.getString("nif"));
                inf.setNom(result.getString("nom"));
                inf.setCognoms(result.getString("cognoms"));
                inf.setCorreu(result.getString("correu"));
                inf.setHorari_de_feina(result.getString("horaridefeina"));
                inf.setTelefon(result.getString("telefon"));

                infermers.add(inf);
            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return infermers;

    }

    public static boolean updateInfermer(Infermer inf){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        String cadena="";
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();

            sql= "UPDATE Infermeres SET ";
            if (!inf.getNom().isEmpty()){
                cadena+= "nom = '"+inf.getNom()+"', ";
            }
            if (!inf.getCognoms().isEmpty()){
                cadena+= "cognoms = '"+inf.getCognoms()+"', ";
            }
            if (!inf.getCorreu().isEmpty()){
                cadena+= "correu = '"+inf.getCorreu()+"', ";
            }
            if (!inf.getHorari_de_feina().isEmpty()){
                cadena+= "horaridefeina = '"+inf.getHorari_de_feina()+"', ";
            }
            if (!inf.getTelefon().isEmpty()){
                cadena+= "telefon = '"+inf.getTelefon()+"' ";
            }

            sql+=cadena +"WHERE nif= '"+inf.getNif()+"'";

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return nrows==1;
    }

}

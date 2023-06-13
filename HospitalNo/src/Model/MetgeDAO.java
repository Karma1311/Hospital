package Model;

import java.sql.*;
import java.util.ArrayList;

public class MetgeDAO {
    private static final String DB_URL = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWD = "";
    public static boolean addMetge(Metge mt){

        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();
            sql= "INSERT INTO Metges VALUES('"+mt.getNif()+"','"+mt.getNom()+"','"+mt.getCognoms()+"','"+mt.getEspecialitats()+"','"+mt.getCorreu()+"','"+mt.getHorari_de_feina()+"')";

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return nrows==1;
    }

    public static boolean removeMetge(String nif){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "DELETE FROM Metges WHERE nif='"+nif +"'";

            System.out.println(sql);
            nrows=statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1 ;
    }
    public static ArrayList<Metge> getMetges(){
        ArrayList<Metge> metges= new ArrayList<>();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "SELECT * FROM Metges";

            result= statement.executeQuery(sql);

            while(result.next()){
                Metge mt= new Metge();
                mt.setNif(result.getString("nif"));
                mt.setNom(result.getString("nom"));
                mt.setCognoms(result.getString("cognoms"));
                mt.setEspecialitats(result.getString("especialitats"));
                mt.setCorreu(result.getString("correu"));
                mt.setHorari_de_feina(result.getString("horaridefeina"));
                

                metges.add(mt);
            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return metges;

    }
    public static boolean updateMetge(Metge mt){

        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        String cadena="";
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();

            sql= "UPDATE Metges SET ";

            if (!mt.getNom().isEmpty()){
                cadena+= "nom = '"+mt.getNom()+"', ";
            }
            if (!mt.getCognoms().isEmpty()){
                cadena+= "cognoms = '"+mt.getCognoms()+"', ";
            }
            if (!mt.getEspecialitats().isEmpty()){
                cadena+= "especialitats = '"+mt.getEspecialitats()+"', ";
            }
            if (!mt.getCorreu().isEmpty()){
                cadena+= "correu = '"+mt.getCorreu()+"', ";
            }
            if (!mt.getHorari_de_feina().isEmpty()){
                cadena+= "horaridefeina = '"+mt.getHorari_de_feina()+"' ";
            }

            sql+=cadena +"WHERE nif= '"+mt.getNif()+"'";

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

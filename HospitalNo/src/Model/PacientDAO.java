package Model;

import java.sql.*;
import java.util.ArrayList;

public class PacientDAO {
    private static final String DB_URL = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWD = "";

    public static boolean addPacient(Pacient pa) {

        Connection dbconnection = null;
        Statement statement = null;
        String sql;
        int nrows = 0;

        try {
            dbconnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = dbconnection.createStatement();
            sql = "INSERT INTO Pacients VALUES('"+pa.getNif()+"','"+pa.getNom()+"','"+pa.getCognom()+"','"+pa.getEdat()+"','"+pa.getSexe()+"','"+pa.getTipus_sang()+"','"+pa.getHistorial_clinic()+"','"+pa.getTelefon()+"','"+pa.getCorreu()+"','"+pa.getAlergies()+"')";

            System.out.println(sql);
            nrows = statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows == 1;
    }
    public static boolean removcePacient(String nif){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "DELETE FROM Pacients WHERE nif ='" + nif+"'";

            System.out.println(sql);
            nrows=statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1 ;
    }

    public static ArrayList<Pacient> getPacients(){
        ArrayList<Pacient> pacients= new ArrayList<>();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "SELECT * FROM Pacients";

            result= statement.executeQuery(sql);

            while(result.next()){
                Pacient pa= new Pacient();
                pa.setNif(result.getString("nif"));
                pa.setNom(result.getString("nom"));
                pa.setCognom(result.getString("cognoms"));
                pa.setEdat(result.getString("edat"));
                pa.setSexe(result.getString("sexe"));
                pa.setTipus_sang(result.getString("tipusdesang"));
                pa.setHistorial_clinic(result.getString("historialclinic"));
                pa.setTelefon(result.getString("telefon"));
                pa.setCorreu(result.getString("correu"));
                pa.setAlergies(result.getString("alergies"));

                pacients.add(pa);
            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pacients;

    }

    public static boolean updatePacient(String nif, String nom ,String cognom,String edat, String sexe,String tipus_sang, String historial_clinic ,String telefon, String correu, String alergies){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        String cadena="";
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();

            sql= "UPDATE Pacients SET ";
            if (!nom.isEmpty()){
                cadena+= "nom = '"+nom+"', ";
            }
            if (!cognom.isEmpty()){
                cadena+= "cognoms = '"+cognom+"', ";
            }
            if (!edat.isEmpty()){
                cadena+= "edat = '"+edat+"', ";
            }

            if (!tipus_sang.isEmpty()){
                cadena+= "tipusdesang = '"+tipus_sang+"', ";
            }
            if (!historial_clinic.isEmpty()){
                cadena+= "historialclinic = '"+historial_clinic;
            }
            if (!telefon.isEmpty()){
                cadena+= "telefon = '"+telefon+"', ";
            }
            if (!correu.isEmpty()){
                cadena+= "correu = '"+correu+"', ";
            }
            if (!alergies.isEmpty()){
                cadena+= "alergies = '"+alergies+"', ";
            }
            if (!sexe.isEmpty()){
                cadena+= "sexe = '"+sexe+"' ";
            }

            sql+=cadena +"WHERE nif= '"+nif+"'";

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return nrows==1;
    }
    public static Pacient getPacientsByNif(String nif){
        Pacient pacient= new Pacient();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();

            sql= "SELECT * FROM Pacients WHERE Nif= '"+nif+"'";

            result= statement.executeQuery(sql);

            while(result.next()){
                Pacient pa= new Pacient();
                pacient.setNif(result.getString("nif"));
                pacient.setNom(result.getString("nom"));
                pacient.setCognom(result.getString("cognoms"));
                pacient.setEdat(result.getString("edat"));
                pacient.setSexe(result.getString("sexe"));
                pacient.setTipus_sang(result.getString("tipusdesang"));
                pacient.setHistorial_clinic(result.getString("historialclinic"));
                pacient.setTelefon(result.getString("telefon"));
                pacient.setCorreu(result.getString("correu"));
                pacient.setAlergies(result.getString("alergies"));

            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pacient;

    }

}

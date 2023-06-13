package Model;

import java.sql.*;
import java.util.ArrayList;

public class ConsultaDAO {
    private static final String DB_URL = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWD = "";

    public static boolean addConsulta(Consulta con){

        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();
            String cadena;
            if(con.getNif_infermer().isEmpty()){
                cadena="');";
            }
            else{
                cadena="','"+con.getNif_infermer()+"');";
            }

            sql= "INSERT INTO Consultes VALUES (" + con.id+",'"+con.dia+"','"+con.hora+"','"+con.lloc+"','"+con.nif_metge+"','"+con.nif_pacient+cadena ;

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1;
    }
    public static boolean removeConsulta(int id){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "DELETE FROM Consultes WHERE id= '"+ id+"'";

            System.out.println(sql);
            nrows=statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1 ;
    }

    public static ArrayList<Consulta> getConsultes(){
        ArrayList<Consulta> consultas= new ArrayList<>();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "SELECT * FROM Consultes";

            result= statement.executeQuery(sql);

            while(result.next()){
                Consulta con= new Consulta();
                con.setDia(result.getString("dia"));
                con.setLloc(result.getString("lloc"));
                con.setHora(result.getString("hora"));
                con.setNif_metge(result.getString("nif_metge"));
                con.setNif_pacient(result.getString("nif_pacient"));
                con.setNif_infermer(result.getString("nif_infermer"));

                consultas.add(con);
            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            System.out.println("El Usuari que ha introduit no existeix");
            throw new RuntimeException(e);
        }
        return consultas;

    }

    public static ArrayList<Consulta> getConsultesbyMetge(String nifMetge){
        ArrayList<Consulta> consultas= new ArrayList<>();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "SELECT * FROM Consultes c Inner Join Metges mt on c.metge_nif=mt.nif WHERE nif = '" + nifMetge+"'" ;

            result= statement.executeQuery(sql);

            while(result.next()){
                Consulta con= new Consulta();
                con.setId(result.getInt("id"));
                con.setDia(result.getString("dia"));
                con.setLloc(result.getString("lloc"));
                con.setHora(result.getString("hora"));
                con.setNif_pacient(result.getString("pacient_nif"));

                consultas.add(con);
            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultas;
    }

    public static boolean cambiarHoraConsulta(Consulta con){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        String cadena="";
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();

            sql= "UPDATE Consultes SET ";

            if (!con.getLloc().isEmpty()){
                cadena+= "lloc = '"+con.getLloc()+"', ";
            }
            if (!con.getDia().isEmpty()){
                cadena+= "dia = '"+con.getDia()+"', ";
            }
            if (!con.getNif_metge().isEmpty()){
                cadena+= "metge_nif = '"+con.getNif_metge()+"','";
            }
            if (!con.getNif_pacient().isEmpty()){
                cadena+= "pacient_nif = '"+con.getNif_pacient()+"', ";
            }
            if (!con.getHora().isEmpty()){
                cadena+= "hora = '"+con.getHora()+"' ";
            }

            sql+=cadena +"WHERE id= '" + con.getId()+ "'" ;

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return nrows==1;

    }

    public static boolean cambiarHoraConsultaPacient(int id ,String dia,String hora,String nifpa){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        String cadena="";
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();

            sql= "UPDATE Consultes SET ";
            if (!hora.isEmpty()){
                cadena+= "hora = '"+hora+"' ";
            }

            if (!dia.isEmpty()){
                cadena+= "dia = '"+dia+"', ";
            }

            sql+=cadena +"WHERE id = '"+id+"'" ;

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return nrows==1;

    }
    public static ArrayList<Consulta> getConsultesbyPacient(String nifPacient){
        ArrayList<Consulta> consultas= new ArrayList<>();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "SELECT * FROM Consultes c Inner Join Pacients pa on c.pacient_nif=pa.nif WHERE pa.nif = '" + nifPacient+"'" ;

            result= statement.executeQuery(sql);

            while(result.next()){
                Consulta con= new Consulta();
                con.setId(result.getInt("id"));
                con.setDia(result.getString("dia"));
                con.setLloc(result.getString("lloc"));
                con.setHora(result.getString("hora"));
                con.setNif_metge(result.getString("pacient_nif"));

                consultas.add(con);
            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultas;
    }

    public static ArrayList<Consulta> getConsultesbyInfemera(String nifInfermer){
        ArrayList<Consulta> consultas= new ArrayList<>();
        Connection dbconnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "SELECT * FROM Consultes c Inner Join Infermeres i on c.infermer_id=i.nif WHERE i.nif = '" + nifInfermer+"'" ;

            result= statement.executeQuery(sql);

            while(result.next()){
                Consulta con= new Consulta();
                con.setId(result.getInt("id"));
                con.setDia(result.getString("dia"));
                con.setLloc(result.getString("lloc"));
                con.setHora(result.getString("hora"));
                con.setNif_metge(result.getString("metge_nif"));
                con.setNif_pacient(result.getString("pacient_nif"));

                consultas.add(con);
            }
            result.close();
            statement.close();
            dbconnection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultas;
    }

    public static boolean removeConsultabyMetges(String nifmet){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "DELETE FROM Consultes WHERE metge_nif= '"+ nifmet+"'";

            System.out.println(sql);
            nrows=statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1 ;
    }

    public static boolean updateConsultaforInfermer(String nifInf){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        String cadena="";
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = dbconnection.createStatement();

            sql= "UPDATE Consultes SET ifermer_id = null Where infermer_id = '"+nifInf+"'" ;

            System.out.println(sql);
            nrows= statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return nrows==1;

    }

    public static boolean removeConsultaforPacient(String nifpa){
        Connection dbconnection= null;
        Statement statement= null;
        String sql;
        int nrows=0;

        try {
            dbconnection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement= dbconnection.createStatement();
            sql= "DELETE FROM Consultes WHERE pacient_nif= '"+ nifpa+"'";

            System.out.println(sql);
            nrows=statement.executeUpdate(sql);
            statement.close();
            dbconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nrows==1 ;
    }

}

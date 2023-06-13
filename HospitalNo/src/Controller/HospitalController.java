package Controller;

import Model.*;

import java.util.ArrayList;

public class HospitalController {

    public static ArrayList<Metge> getMetges(){
        ArrayList<Metge> metges= MetgeDAO.getMetges();
        return metges;

    }

    public static ArrayList<Infermer> getInfermers(){
        ArrayList<Infermer>  infermers= InfermerDAO.getInfermers();
        return infermers;

    }
    public static ArrayList<Consulta> getConsultes() {
        ArrayList<Consulta> consultas = ConsultaDAO.getConsultes();
        return consultas;
    }
    public static ArrayList<Pacient> getPacients(){
        ArrayList<Pacient>  pacients= PacientDAO.getPacients();
        return pacients;

    }
    public static ArrayList<Consulta> getConsultesByMetge(String nif){
        ArrayList<Consulta>  consultes= ConsultaDAO.getConsultesbyMetge(nif);
        return consultes;

    }
    public static boolean addInfermers(Infermer inf) {
        return InfermerDAO.addInfermer(inf);
    }

    public static boolean addMetges(Metge mt){
        return MetgeDAO.addMetge(mt);
    }

    public static boolean addPacients(Pacient pa){
        return PacientDAO.addPacient(pa);
    }

    public static boolean addConsultes(Consulta con){return ConsultaDAO.addConsulta(con);}

    public static boolean removeMetges(String nif){return MetgeDAO.removeMetge(nif);}
    public static boolean removeInfermers(String nif){return InfermerDAO.removeInfermer(nif);}
    public static boolean removePacients(String nif){return PacientDAO.removcePacient(nif);}
    public static boolean removeConsultes(int id){return ConsultaDAO.removeConsulta(id);}
    public static boolean removeConsultesByMetge(String nifmet){return ConsultaDAO.removeConsultabyMetges(nifmet);}
    public static boolean removeConsultesByPacient(String nifpa){return ConsultaDAO.removeConsultaforPacient(nifpa);}


    public static boolean updateMetges(Metge met){
        return MetgeDAO.updateMetge(met);
    }

    public static boolean updateInfermers(Infermer inf){
        return InfermerDAO.updateInfermer(inf);
    }

    public static boolean updatePacients(String nif, String nom ,String cognom,String edat, String sexe,String tipus_sang, String historial_clinic ,String telefon, String correu, String alergies){
        return PacientDAO.updatePacient(nif,nom,cognom,edat,sexe,tipus_sang,historial_clinic,telefon,correu,alergies);
    }

    public static boolean updateConsultes(Consulta con){
        return ConsultaDAO.cambiarHoraConsulta(con);
    }

    public static boolean updateConsultesbyinfermers(String nif){
        return ConsultaDAO.updateConsultaforInfermer(nif);
    }


    public static String getUserPassword(String user){
        return  UsuarisDAO.getUserPassword(user);
    }

    public static boolean updateConsultesByPacient(int id,String dia,String hora,String nif){
        return ConsultaDAO.cambiarHoraConsultaPacient(id,dia,hora,nif);
    }

    public static Pacient getPacientByNif(String nif){
        return  PacientDAO.getPacientsByNif(nif);
    }
    public static ArrayList<Consulta> getConsultesByPacient(String panif){
        ArrayList<Consulta>  consultes= ConsultaDAO.getConsultesbyPacient(panif);
        return consultes;

    }
    public static ArrayList<Consulta> getConsultesByInfermers(String inif){
        ArrayList<Consulta>  consultes= ConsultaDAO.getConsultesbyInfemera(inif);
        return consultes;

    }
}

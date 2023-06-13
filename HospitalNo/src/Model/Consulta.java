package Model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Consulta {
    public int id;
    public String dia;
    public String lloc;
    public String hora;
    public String nif_metge;
    public String nif_pacient;
    public String nif_infermer;

    public Consulta(){
        this.id=0;
        this.dia= null;
        this.lloc= "";
        this.hora= null;
        this.nif_metge="";
        this.nif_pacient="";
        this.nif_infermer="";
    }

    public Consulta(int id,String dia, String lloc,String hora,String nif_metge,String nif_pacient,String nif_infermer){
        this.id=id;
        this.dia= dia;
        this.lloc= lloc;
        this.hora=hora;
        this.nif_metge=nif_metge;
        this.nif_pacient=nif_pacient;
        this.nif_infermer=nif_infermer;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNif_metge() {
        return nif_metge;
    }

    public void setNif_metge(String nif_metge) {
        this.nif_metge = nif_metge;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public String getNif_pacient() {
        return nif_pacient;
    }

    public void setNif_pacient(String nif_pacient) {
        this.nif_pacient = nif_pacient;
    }

    public String getNif_infermer() {
        return nif_infermer;
    }

    public void setNif_infermer(String nif_infermer) {
        this.nif_infermer = nif_infermer;
    }

    @Override
    public String toString(){
        String str="Identificador: "+ getId()+"\n"+
                "Dia: "+getDia()+"\n"+
                "Hora: "+getHora()+"\n"+
                "Lloc: "+getLloc()+"\n"+
                "NIF del metge: "+getNif_metge()+"\n" +
                "NIF del pacient: "+getNif_pacient()+"\n" ;

        return str;

    }








}




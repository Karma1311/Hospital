package Model;

public class Pacient {
    private String nif;
    private String nom;
    private String cognom;
    private String edat;
    private String sexe;
    private String tipus_sang;
    private String historial_clinic;
    private String telefon;
    private String correu;
    private String alergies;

    public Pacient(){
        this.nif= "";
        this.nom= "";
        this.cognom= "";
        this.edat= "";
        this.sexe= "";
        this.tipus_sang= "";
        this.historial_clinic= "";
        this.telefon= "";
        this.correu= "";
        this.alergies= "";
    }

    public Pacient(String nif, String nom ,String cognom,String edat, String sexe,String tipus_sang, String historial_clinic ,String telefon, String correu, String alergies){
        this.nif= nif;
        this.nom= nom;
        this.cognom=cognom;
        this.edat= edat;
        this.sexe= sexe;
        this.telefon=telefon;
        this.correu= correu;
        this.alergies= alergies;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getEdat() {
        return edat;
    }

    public void setEdat(String edat) {
        this.edat = edat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTipus_sang() {
        return tipus_sang;
    }

    public void setTipus_sang(String tipus_sang) {
        this.tipus_sang = tipus_sang;
    }

    public String getHistorial_clinic() {
        return historial_clinic;
    }

    public void setHistorial_clinic(String historial_clinic) {
        this.historial_clinic = historial_clinic;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    @Override
    public String toString() {
        String str = "Nom: " + this.nom + "\n" +
                "Cognoms: " + this.cognom + "\n" +
                "NIF: " + this.nif + "\n" +
                "Edat: " + this.edat + "\n" +
                "Sexe: " + this.sexe + "\n" +
                "Tipus de Sang: " + this.tipus_sang + "\n" +
                "Historial clinic: " + this.historial_clinic + "\n"+
                "Correu: " + this.correu + "\n" ;
        return str;
    }

}

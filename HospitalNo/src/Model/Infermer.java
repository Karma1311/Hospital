    package Model;

public class Infermer {
    private String nif;
    private String nom;
    private String cognoms;
    private String correu;
    private String horari_de_feina;
    private String telefon;

    public Infermer(){
        this.nif="";
        this.nom="";
        this.cognoms="";
        this.correu="";
        this.horari_de_feina="";
        this.telefon="";
    }

    public Infermer(String nif, String nom ,String cognoms, String correu, String horari_de_feina ,String telefon){
        this.nif= nif;
        this.nom= nom;
        this.cognoms= cognoms;
        this.correu= correu;
        this.horari_de_feina= horari_de_feina;
        this.telefon=telefon;

    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public  String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getHorari_de_feina() {
        return horari_de_feina;
    }

    public void setHorari_de_feina(String horari_de_feina) {
        this.horari_de_feina = horari_de_feina;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        String str = "Nom: " + this.nom + "\n" +
                "Cognoms: " + this.cognoms + "\n" +
                "NIF: " + this.nif + "\n" +
                "Telefon: " + this.telefon + "\n" +
                "Correu: " + this.correu + "\n" +
                "Horari de feina: " + this.horari_de_feina + "\n";
        return str;

    }
}

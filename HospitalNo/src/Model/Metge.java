package Model;

public class Metge {

    private String nif;
    public String nom;
    private String cognoms;
    private String especialitats;
    private String correu;
    private String horari_de_feina;

    public Metge() {
        this.nif = "";
        this.nom = "";
        this.cognoms = "";
        this.especialitats = "";
        this.correu = "";
        this.horari_de_feina = "";

    }

    public Metge(String nif, String nom, String cognoms, String especialitats, String correu, String horari_de_feina) {
        this.nif = nif;
        this.nom = nom;
        this.cognoms = cognoms;
        this.especialitats = especialitats;
        this.correu = correu;
        this.horari_de_feina = horari_de_feina;


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

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getEspecialitats() {
        return especialitats;
    }

    public void setEspecialitats(String especialitats) {
        this.especialitats = especialitats;
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



    public String toString() {
        String str = "Nom: " + this.nom + "\n" +
                "Cognoms: " + this.cognoms + "\n" +
                "NIF: " + this.nif + "\n" +
                "Especialitat: " + this.especialitats + "\n" +
                "Correu: " + this.correu + "\n" +
                "Horari de feina: " + this.horari_de_feina + "\n";
        return str;
    }

}





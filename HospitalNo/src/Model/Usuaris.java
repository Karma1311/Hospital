package Model;

public class Usuaris {

    private String usuari;
    private String contrasena;


    public Usuaris(){
        this.usuari="";
        this.contrasena="";
    }

    public Usuaris(String usuari,String contrasena){
        this.usuari=usuari;
        this.contrasena=contrasena;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

package Vista;

import Controller.HospitalController;
import Model.Consulta;
import Model.Infermer;
import Model.Metge;
import Model.Pacient;
import at.favre.lib.crypto.bcrypt.BCrypt;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option, option2, user, option3, option4, option5, option6;
        String nif, inif, username, pass, pacient;
        Scanner key = new Scanner(System.in);
        HospitalController controller = new HospitalController();
        ArrayList<Metge> metges = controller.getMetges();
        ArrayList<Infermer> infermers = controller.getInfermers();
        ArrayList<Pacient> pacients = controller.getPacients();
        ArrayList<Consulta> con = new ArrayList<>();
        SimpleDateFormat diat = new SimpleDateFormat();
        DateTimeFormatter horat = DateTimeFormatter.ofPattern("HH:mm:ss");


            System.out.println("INICI DE SESSIÓ:\n" +
                    "Quin tipus de usuari es vostè ? \n" +
                    "1.Administrador\n" +
                    "2.Pacient");
            user = key.nextInt();
            key.nextLine();

            switch (user) {
                case 1:
                    System.out.println("Introdueixi les credencials: ");
                    System.out.print("Nom d'usuari: ");
                    username = key.nextLine();
                    System.out.print("Contrasenya: ");
                    pass = key.nextLine();
                    String passbd = controller.getUserPassword(username);
                    BCrypt.Result result = BCrypt.verifyer().verify(pass.toCharArray(), passbd);
                    if (result.verified) {
                        System.out.println("Contraseña correcta");

                        do {

                            System.out.println("----------GESTIÓ HOSPITALARIA ADMINISTRADOR-----------\n" +
                                    "Que desitja fer:\n" +
                                    "0.Sortir\n" +
                                    "1.Mostrar Dades\n" +
                                    "2.Afegir Dades\n" +
                                    "3.Elminiar Usuaris\n" +
                                    "4.Actualitzar dades");
                            option = key.nextInt();
                            key.nextLine();

                            if (option>4 || option<0){
                                System.out.println("S'ha d'introduir un numero del 0 al 5");
                            }

                            switch (option) {
                                case 0:
                                    System.out.println("Sortint del programa....");
                                    break;

                                //SELECTS
                                case 1:


                                    System.out.println("Que vol mostrar?:\n" +
                                            "0.Enrere \n" +
                                            "1.Metges \n" +
                                            "2.Infermers \n" +
                                            "3.Pacients \n" +
                                            "4.Consultes per metge\n" +
                                            "5.Consultes per infermer\n");
                                    option2 = key.nextInt();
                                    key.nextLine();
                                    switch (option2) {
                                        case 0:
                                            System.out.println("Sortint al menu");
                                            break;
                                        case 1:
                                            System.out.println(Main.getMetgesString(metges));
                                            break;
                                        case 2:
                                            System.out.println(Main.getInfermersString(infermers));
                                            break;
                                        case 3:
                                            System.out.println(Main.getPacientsString(pacients));
                                            break;
                                        case 4:
                                            System.out.print("Introdueixi el NIF del Metge: ");
                                            nif = key.next();
                                            if (nif.isEmpty()){
                                                System.out.println("Introdueixi el nif del metge sisplau");
                                            }else{
                                                con = controller.getConsultesByMetge(nif);
                                                System.out.println(Main.getConsultesByMetgeString(con));
                                            }
                                            break;
                                        case 5:
                                            System.out.print("Introdueixi el NIF del Infermer: ");
                                            inif = key.next();
                                            if (inif.isEmpty()){
                                                System.out.println("Introdueixi el nif del infermer sisplau");
                                            }else{
                                                con = controller.getConsultesByInfermers(inif);
                                                System.out.println(Main.getConsultesByInfermersString(con));
                                            }
                                            break;
                                    }
                                    break;


                                //INSERTS
                                case 2:

                                    System.out.println("Quin tipus de usuari o consulta vol afegir?:\n" +
                                            "0.Sortir\n" +
                                            "1.Metge\n" +
                                            "2.Infermer\n" +
                                            "3.Pacient\n" +
                                            "4.Consulta");
                                    option3 = key.nextInt();
                                    key.nextLine();
                                    switch (option3) {
                                        case 0:
                                            System.out.println("Sortint al menu");
                                            break;
                                        case 1:
                                            String nifm, nom, cognoms, espe, correu, horari;
                                            System.out.print("Nom: ");
                                            nom = key.nextLine();
                                            System.out.print("Cognoms: ");
                                            cognoms = key.nextLine();
                                            System.out.print("NIF: ");
                                            nifm = key.nextLine();
                                            System.out.print("Especialitats: ");
                                            espe = key.nextLine();
                                            System.out.print("Correu: ");
                                            correu = key.nextLine();
                                            System.out.print("Horari: ");
                                            horari = key.nextLine();
                                            Metge met = new Metge(nifm, nom, cognoms, espe, correu, horari);
                                            controller.addMetges(met);

                                            System.out.println("Usuari introduit correctament");
                                            break;
                                        case 2:
                                            String nifi, nomi, cognomsi, telef, correui, horariinf;
                                            System.out.print("Nom: ");
                                            nomi = key.nextLine();
                                            System.out.print("Cognoms: ");
                                            cognomsi = key.nextLine();
                                            System.out.print("NIF: ");
                                            nifi = key.nextLine();
                                            System.out.print("Telefon: ");
                                            telef = key.nextLine();
                                            System.out.print("Correu: ");
                                            correui = key.nextLine();
                                            System.out.print("Horari: ");
                                            horariinf = key.nextLine();
                                            Infermer inf = new Infermer(nifi, nomi, cognomsi, correui, horariinf, telef);
                                            controller.addInfermers(inf);

                                            System.out.println("Usuari introduit correctament");
                                            break;
                                        case 3:
                                            String nifp, nomp, cognomsp, telefp, correup, histo, tipuss, alergies, sexe, edat;

                                            System.out.print("Nom: ");
                                            nomp = key.nextLine();
                                            System.out.print("Cognoms: ");
                                            cognomsp = key.nextLine();
                                            System.out.print("NIF: ");
                                            nifp = key.nextLine();
                                            System.out.print("Edat: ");
                                            edat = key.nextLine();
                                            System.out.print("Sexe: ");
                                            sexe = key.nextLine();
                                            System.out.print("Tipus Sanguini: ");
                                            tipuss = key.nextLine();
                                            System.out.print("Historial Clinic: ");
                                            histo = key.nextLine();
                                            System.out.print("Telefon : ");
                                            telefp = key.nextLine();
                                            System.out.print("Correu: ");
                                            correup = key.nextLine();
                                            System.out.print("Alergies: ");
                                            alergies = key.nextLine();
                                            Pacient pa = new Pacient(nifp, nomp, cognomsp, edat, sexe,tipuss, histo, telefp, correup, alergies);
                                            controller.addPacients(pa);
                                            System.out.println("Usuari introduit correctament");
                                            break;

                                        case 4:
                                            Random rnd = new Random();
                                            int infer = 0;
                                            int id = rnd.nextInt(100);
                                            String dia, hora, lloc, nif2, nifp2, nifinf = "";
                                            System.out.print("Dia (aaaa-mm-dd) :");
                                            dia = key.nextLine();
                                            System.out.print("Hora (00:00) :");
                                            hora = key.nextLine();
                                            System.out.print("Lloc :");
                                            lloc = key.nextLine();
                                            System.out.print("NIF del Metge :");
                                            nif2 = key.nextLine();
                                            System.out.print("NIF del Pacient:");
                                            nifp2 = key.nextLine();
                                            System.out.println("Cal algun infermer ? \n" +
                                                    "1.Si \n" +
                                                    "2.No ");
                                            infer = key.nextInt();
                                            key.nextLine();

                                            if (infer == 2) {
                                                nifinf = "";
                                            } else if (infer == 1) {
                                                Main.getInfermersString(infermers);
                                                System.out.println("Introdueixi el nif del infermer que necessita");
                                                nifinf = key.nextLine();

                                            }
                                            Consulta consulta = new Consulta(id, dia, lloc, hora, nif2, nifp2, nifinf);
                                            controller.addConsultes(consulta);
                                            System.out.println("S'ha afegit la consulta amb exit");

                                            break;
                                    }
                                    break;


                                //DELETES
                                case 3:


                                    System.out.println("Quin tipus d'usuari o consulta vol eliminar?\n" +
                                            "0.Sortir\n" +
                                            "1.Metge\n" +
                                            "2.Infermer\n" +
                                            "3.Pacient\n" +
                                            "4.Consulta");
                                    option4 = key.nextInt();
                                    key.nextLine();
                                    switch (option4) {
                                        case 0:
                                            System.out.println("Sortint al menu");
                                            break;
                                        case 1:
                                            String nifmetge;
                                            System.out.print("Introdueixi el NIF del Metge que vol eliminar: ");
                                            nifmetge = key.nextLine();
                                            if (nifmetge.equals("")){
                                                System.out.println("No s'ha eliminat cap usuari");
                                            }
                                            else{
                                                controller.removeConsultesByMetge(nifmetge);
                                                controller.removeMetges(nifmetge);
                                                System.out.println("Usuari eliminat amb exit");
                                            }
                                            break;
                                        case 2:
                                            String nifinfermer;
                                            System.out.print("Introdueixi el NIF del Infermer que vol eliminar: ");
                                            nifinfermer = key.nextLine();
                                            if (nifinfermer.equals("")){
                                                System.out.println("No s'ha eliminat cap usuari");
                                            }else {

                                                controller.removeInfermers(nifinfermer);
                                                System.out.println("Usuari eliminat amb exit");
                                            }
                                            break;
                                        case 3:
                                            String nifpacient;
                                            System.out.print("Introdueixi el NIF del Pacient que vol eliminar: ");
                                            nifpacient = key.nextLine();
                                            if (nifpacient.equals("")){
                                                System.out.println("No s'ha eliminat cap usuari");
                                            }else{
                                                controller.removeConsultesByPacient(nifpacient);
                                                controller.removePacients(nifpacient);
                                                System.out.println("Usuari eliminat amb exit");
                                            }
                                            break;
                                        case 4:
                                            int idcon;
                                            System.out.print("Introdueixi el id de la consulta: ");
                                            idcon = key.nextInt();
                                            if (idcon== 0){
                                                System.out.println("No s'ha eliminat cap consulta");
                                            }else{
                                                controller.removeConsultes(idcon);
                                                System.out.println("Usuari eliminat amb exit");
                                            }
                                            break;
                                    }

                                    break;

                                //UPDATES
                                case 4:

                                    System.out.println("Quin tipus d'usuari o quina consulta vol modificar: \n" +
                                            "0.Sortir\n" +
                                            "1.Metges\n" +
                                            "2.Infermers\n" +
                                            "3.Pacients\n" +
                                            "4.Consultes");
                                    option5 = key.nextInt();
                                    key.nextLine();
                                    switch (option5) {
                                        case 0:
                                            System.out.println("Sortint al menu ");
                                            break;
                                        case 1:
                                            String nifmet, especialitats, correu, horari, nom, cognoms;
                                            System.out.print("Introdueixi el nif del metge que vol modificar: ");
                                            nifmet = key.nextLine();
                                            if (nifmet.isEmpty()){
                                                System.out.println("\n Introdueixi un nif valid sisplau");
                                            }else {
                                                System.out.print("Nom: ");
                                                nom = key.nextLine();
                                                System.out.print("Cognoms: ");
                                                cognoms = key.nextLine();
                                                System.out.print("Especialiat: ");
                                                especialitats = key.nextLine();
                                                System.out.print("Correu: ");
                                                correu = key.nextLine();
                                                System.out.print("Horari de feina: ");
                                                horari = key.nextLine();
                                                Metge met = new Metge(nifmet, nom, cognoms, especialitats, correu, horari);

                                                controller.updateMetges(met);

                                                System.out.println("Usuari modificat amb exit");
                                            }
                                            break;
                                        case 2:
                                            String nifinf, nomi, cognom, correuinf, horarinf, telefon;
                                            System.out.print("Introdueixi el nif del Infermer que vol modificar: ");
                                            nifinf = key.nextLine();
                                            if (nifinf.isEmpty()){
                                                System.out.println("Introdueixi un nif valid sisplau");
                                            }else {
                                                System.out.print("Nom: ");
                                                nomi = key.nextLine();
                                                System.out.print("Cognoms: ");
                                                cognom = key.nextLine();
                                                System.out.print("Correu: ");
                                                correuinf = key.nextLine();
                                                System.out.print("Horari de feina: ");
                                                horarinf = key.nextLine();
                                                System.out.print("Telefon: ");
                                                telefon = key.nextLine();
                                                Infermer infer = new Infermer(nifinf,nomi,cognom,correuinf,horarinf,telefon);

                                                controller.updateInfermers(infer);
                                                System.out.println("Usuari modificat amb exit");
                                            }
                                            break;
                                        case 3:
                                            String nifpa, nompa, cognompa, correupa, edatpa, telefonpa, sexe, tipussang, historialpa, alergies;
                                            System.out.print("Introdueixi el nif del Pacient que vol modificar: ");
                                            nifpa = key.nextLine();
                                            if (nifpa.isEmpty()){
                                                System.out.println("Introdueixi un nif valid sisplau");
                                            }else{
                                                System.out.print("Nom: ");
                                                nompa = key.nextLine();
                                                System.out.print("Cognoms: ");
                                                cognompa = key.nextLine();
                                                System.out.print("Correu: ");
                                                correupa = key.nextLine();
                                                System.out.print("Edat: ");
                                                edatpa = key.nextLine();
                                                System.out.print("Tipus Sanguini: ");
                                                tipussang = key.nextLine();
                                                System.out.print("Telefon: ");
                                                telefonpa = key.nextLine();
                                                System.out.print("Historial Clinic: ");
                                                historialpa = key.nextLine();
                                                System.out.print("Alergies: ");
                                                alergies = key.nextLine();
                                                System.out.print("Sexe: ");
                                                sexe = key.nextLine();
                                                Pacient pac =new Pacient(nifpa,nompa,cognompa,edatpa,sexe,tipussang,historialpa,telefonpa,correupa,alergies);
                                                controller.updatePacients(nifpa,nompa,cognompa,edatpa,sexe,tipussang,historialpa,telefonpa,correupa,alergies);
                                                System.out.println("Usuari modificat amb exit");
                                            }
                                            break;
                                        case 4:
                                            String dia, hora, lloc, nifmetge, nifpacient,nifinfermer;
                                            int idcon;
                                            System.out.print("Introdueixi el identificador de la consulta :");
                                            idcon = key.nextInt();
                                            if (idcon==0){
                                                System.out.println("Introdueixi un identificador correcte sisplau");
                                            }else{
                                                key.nextLine();
                                                System.out.print("Dia (aaaa-mm-dd): ");
                                                dia = key.nextLine();
                                                System.out.print("NIF metge : ");
                                                nifmetge = key.nextLine();
                                                System.out.print("LLoc: ");
                                                lloc = key.nextLine();
                                                System.out.print("Hora (00:00): ");
                                                hora = key.nextLine();
                                                System.out.print("Nif Pacient: ");
                                                nifpacient = key.nextLine();
                                                System.out.print("Nif Infermer: ");
                                                nifinfermer=key.nextLine();
                                                Consulta consul = new Consulta(idcon,dia,lloc,hora,nifmetge,nifpacient,nifinfermer);

                                                controller.updateConsultes(consul);

                                                System.out.println("Consulta modificada amb exit");
                                            }
                                            break;

                                    }
                                    break;
                            }


                        } while (option!=0);
                    }
                    else{
                    System.out.println("Contraseña incorrecta");

                }
                    break;
                case 2:


                        System.out.print("Introduexi el vostre NIF: ");
                        pacient = key.nextLine();
                    do {
                        System.out.println("--------AREÀ PERSONAL---------");
                        System.out.println("Que desitja fer?\n" +
                                "0.Sortir\n" +
                                "1.Modificar les meves dades\n" +
                                "2.Modificar les meves consultes\n" +
                                "3.Revisar el meu perfil\n" +
                                "4.Consultar les meves cites");

                        option6 = key.nextInt();
                        key.nextLine();

                        switch (option6) {
                            case 0:
                                System.out.println("Sortint del Programa... \n ");
                                break;
                            case 1:
                                String nompa2, cognompa2, correupa2, edatpa2, telefonpa2, sexe2, tipussang2, historialpa2, alergies2;
                                System.out.print("Nom: ");
                                nompa2 = key.nextLine();
                                System.out.print("Cognoms: ");
                                cognompa2 = key.nextLine();
                                System.out.print("Correu: ");
                                correupa2 = key.nextLine();
                                System.out.print("Edat: ");
                                edatpa2 = key.nextLine();
                                System.out.print("Tipus Sanguini: ");
                                tipussang2 = key.nextLine();
                                System.out.print("Telefon: ");
                                telefonpa2 = key.nextLine();
                                System.out.print("Historial Clinic: ");
                                historialpa2 = key.nextLine();
                                System.out.print("Alergies: ");
                                alergies2 = key.nextLine();
                                System.out.print("Sexe: ");
                                sexe2 = key.nextLine();
                                Pacient paci = new Pacient(pacient,nompa2,cognompa2,edatpa2,sexe2,tipussang2,historialpa2,telefonpa2,correupa2,alergies2);

                                controller.updatePacients(pacient,nompa2,cognompa2,edatpa2,sexe2,tipussang2,historialpa2,telefonpa2,correupa2,alergies2);
                                System.out.println("Usuari modificat amb exit");

                                break;
                            case 2:
                                String date, hour;
                                int id;
                                System.out.print("Introdueixi el id de la consulta: ");
                                id = key.nextInt();
                                key.nextLine();
                                System.out.print("Dia: ");
                                date = key.nextLine();
                                System.out.print("Hora: ");
                                hour = key.nextLine();

                                controller.updateConsultesByPacient(id, date, hour, pacient);
                                System.out.println("S'ha mmodificat la seva consulta");

                                break;
                            case 3:
                                Pacient pac2 = new Pacient();
                                System.out.println("Les seves dades");
                                System.out.println(getPacientsByNifString(pac2, pacient));

                                break;
                            case 4:
                                System.out.println(getConsultesByPacientString(con, pacient));

                        }
                    } while (option6 != 0);
            }


    }



    public static String getMetgesString(ArrayList<Metge> mt){
        String cadena="\n";
        for (Metge met : mt) {
            cadena+=met+"\n";
        }

        return cadena;
    }

    public static String getInfermersString(ArrayList<Infermer> inf){
        String cadena="";
        for (Infermer infer : inf) {
            cadena+=infer+"\n";
        }
        return cadena;
    }
    public static String getPacientsString(ArrayList<Pacient> pac){
        String cadena="";
        for (Pacient pa : pac) {
            cadena+=pa+"\n";
        }
        return cadena;
    }

    public static String getConsultesByMetgeString(ArrayList<Consulta> con){
        String cadena="";
        for (Consulta cons : con) {
            cadena+=cons+"\n";
        }
        return cadena;
    }

    public static String getPacientsByNifString(Pacient pa,String nif){
        pa=HospitalController.getPacientByNif(nif);
       return pa.toString();

    }

    public static String getConsultesByPacientString(ArrayList<Consulta> con,String panif){
        String cadena="";
        con=HospitalController.getConsultesByPacient(panif);
        for (Consulta cons : con) {
            cadena+=cons+"\n";
        }
        return cadena;
    }

    public static String getConsultesByInfermersString(ArrayList<Consulta> con){
        String cadena="";
        for (Consulta cons : con) {
            cadena+=cons+"\n";
        }
        return cadena;
    }


}
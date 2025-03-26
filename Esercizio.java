//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    //Creo l'oggetto in per l'input da tastiera
    public static Scanner in = new Scanner( System.in );

    // Il programma parte con una chiamata a main().
    public static void main(String args[])
    {
        while (true) {
            int numeratore=0;
            int denominatore=0;
            try {
                numeratore = 10;
                System.out.println("Dividiamo "+numeratore+" per ...");
                denominatore = Integer.parseInt( in.nextLine() );

                int risultato = numeratore / denominatore;
                System.out.println("Risultato: " + risultato);
    
            } catch( ArithmeticException e ) {
                System.out.println("Errore nella divisione fra "+numeratore+" e "+denominatore);
                System.out.println(e.getMessage());

            } catch(NumberFormatException e) {
                System.out.println("Input non valido. Reiserisci il denominatore.");
                System.out.println(e.getMessage());

            } catch( Exception e ) {
                System.out.println("Errore inaspettato");
                System.out.println(e.getMessage());
                System.out.println("StackTrace");
                e.printStackTrace();
            }

            leggiFile();

            try {
                leggiFileErroreNonGestito();
            } catch(Exception e) {
                System.out.println("Errore nella lettura del file");
            }

            int[] v = new int[10];
            v[10] = 0;


        }
    }

    //Gestione errore (caso 1)
    public static void leggiFile()  {
        try {
            FileReader fileReader = new FileReader("fileDaAprire");
        } catch (FileNotFoundException e) {
            System.out.println("Errore nella lettura del file");
        }
    }

    //Gestione errore (caso 2).
    //Dichiato la lista delle eccezioni non gestite, che devono essere gestite dal chiamante.
    //Exception è l'eccezione "base", da cui tutte le eccezioni derivano.
    public static void leggiFileErroreNonGestito() throws FileNotFoundException, Exception  {
        FileReader fileReader = new FileReader("fileDaAprire");
    }


}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Lezione sulle Eccezioni

public class EsercizioLezione {
    
    //Input da tastiera
    public static Scanner in = new Scanner(System.in);

    public static void main( String[] args ) {


        while (true) {
            int numeratore = 10;
            int denominatore = 0;
            int risultato = 0;

            System.out.println("Inserisci valore per il denominatore: ");

            try {

                denominatore = Integer.parseInt( in.nextLine() );
                risultato = numeratore / denominatore;

                System.out.println("Risultato: "+risultato);
                
            } catch(NumberFormatException e) {
                //Errore: È stato richiesto un numero, ma è stata inserita una stringa

                System.out.println("Inserisci un numero. Errore: " + e.getMessage() );
                //Visualizzo lo stack trace
                e.printStackTrace();

            } catch (ArithmeticException e) {
                //Errore: ad es. il denominatore è zero
                System.out.println("Errore nell'operazione matematica: " + e.getMessage() );

            } catch (Exception e) {
                //Gestiamo tutti gli errori non gestiti precedentemente
                System.out.println("Unexpected error: " +e.getMessage());
                e.printStackTrace();
            }

            //In questo caso chiamo una funzione che gestisce l'errore internamente, quindi non uso la try catch
            leggiFile();
            
            //In questo caso la funzione non gestisce l'errore, quindi dev'essere gestita dal chiamante
            try {
                leggiFileErroreNonGestito();
            } catch(FileNotFoundException e) {
                //gestisco errore  
                System.out.println("Error: " +e.getMessage());
            } catch(IOException e) {
                //gestisco errore
                System.out.println("Error: " +e.getMessage());
            }

            //Stesso caso precedente, ma gestisco tutti gli errori con un'unica eccezione
            try {
                leggiFileErroreNonGestito();
            } catch(Exception e) {
                //gestisco errore 
            }

        }

    }

    //Gestione errore Modo 1: gestisco gli errori completamente dentro la funzione
    public static void leggiFile() {
        try {
            Scanner in = new Scanner( new FileReader("fileDaLeggere.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Errore nella lettura del file. Errore: " +e.getMessage());
        }
    }

    //Gestione errore Modo 2: non gestisco gli errori dentro la funzione, 
    // ma delego la gestione dell'errore al mio chiamante.
    // Specifico la lista completa delle eccezioni generabili.
    public static void leggiFileErroreNonGestito() throws FileNotFoundException, IOException {
        Scanner in = new Scanner( new FileReader("fileDaLeggere.txt"));
    }

    //Gestione errore Modo 2.2: non gestisco gli errori dentro la funzione, 
    // ma delego la gestione dell'errore al mio chiamante.
    // Specifico solo l'eccezione Base (Exception)
    public static void leggiFileErroreNonGestito2() throws Exception {
        Scanner in = new Scanner( new FileReader("fileDaLeggere.txt"));
    }


}

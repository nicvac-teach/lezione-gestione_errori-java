import java.util.Scanner;

public class EsercizioLezione {
    
    //Input tastiera
    public static Scanner in = new Scanner(System.in);

    public static void main( String[] args ) {

        while (true) {
            int numeratore = 10;
            int denominatore = 0;
            int risultato = 0;

            System.out.println("Inserisci valore per il denominatore: ");
            denominatore = Integer.parseInt( in.nextLine() );
            try {
                risultato = numeratore / denominatore;
            } catch (ArithmeticException e) {
                System.out.println("Errore nell'operazione matematica: " + e.getMessage() );
            }
            System.out.println("Risultato: "+risultato);
        }

    }
    
}

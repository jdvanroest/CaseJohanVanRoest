package nl.belastingdienst.caseJohan;

import java.time.LocalDate;
import java.util.Scanner;

public class VrachtwagenFactory {

    public Vrachtwagen makenVrachtwagenMetScanner() {
        Scanner scanner = new Scanner(System.in);
        Merk m = Merk.NOTDEFINEDYET;
        System.out.println("Voer het merk van de vrachtwagen in. Kies uit SCANIA , DAF, MAN, MERCEDES, VOLVO, RENAULT");
        for (int i = 1; i <= 2; i += 1) {
            try {
                String s = scanner.nextLine();
                m = Merk.valueOf(s);
                System.out.print("Het merk is " + m);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Verkeerde invoer. Kies uit SCANIA , DAF, MAN, MERCEDES, VOLVO, RENAULT");
                i-=1;
            }
        }

        System.out.println("\n" +"Voer het kenteken van de vrachtwagen in");
        String kenteken = scanner.nextLine();
        System.out.println("Het kenteken is " + kenteken);
        System.out.println("\n" +"Voer het lediggewicht in kg van de vrachtwagen in");
        int gewicht = Integer.parseInt(scanner.nextLine());
        System.out.println("Het gewicht is " + gewicht + " kg");
        System.out.println("\n" +"Voer de kilometerstand van de vrachtwagen in");
        int kilometerstand = Integer.parseInt(scanner.nextLine());
        System.out.println("De kilometerstand is " + kilometerstand);


        Vrachtwagen vrachtwagen = new Vrachtwagen(m, kenteken, gewicht, kilometerstand, LocalDate.of(2023, 10, 17));

        return vrachtwagen;
    }
}


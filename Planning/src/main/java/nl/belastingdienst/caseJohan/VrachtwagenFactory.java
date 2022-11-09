package nl.belastingdienst.caseJohan;

import java.time.LocalDate;
import java.util.Scanner;

public class VrachtwagenFactory {

    public Vrachtwagen makenVrachtwagen() {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Voer het merk van de vrachtwagen in. Kies uit SCANIA , DAF, MAN, MERCEDES, VOLVO, RENAULT");
//        for (int i = 1; i <= 2; i += 1) {
//            try {
//                String s = scanner.nextLine();
//                Merk m = Merk.valueOf(s);
//                System.out.print(m);
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println("Verkeerde invoer. Kies uit SCANIA , DAF, MAN, MERCEDES, VOLVO, RENAULT");
//            }
//
//        }
//
//        System.out.println("Voer het kenteken van de vrachtwagen in");
//        String kenteken = scanner.next();
//        System.out.println("Het kenteken is " + kenteken);
        System.out.println("Voer het lediggewicht in kg van de vrachtwagen in");
        int gewicht = Integer.parseInt(scanner.nextLine());
        System.out.println("Het gewicht is " + gewicht + " kg");
        System.out.println("Voer de kilometerstand van de vrachtwagen in");
        int kilometerstand = Integer.parseInt(scanner.nextLine());
        System.out.println("De kilometerstand is " + kilometerstand);

        Vrachtwagen vrachtwagen = new Vrachtwagen(1, Merk.MAN, "5-LPV-53", gewicht, kilometerstand, LocalDate.of(2023, 10, 17));

        return vrachtwagen;
    }
}


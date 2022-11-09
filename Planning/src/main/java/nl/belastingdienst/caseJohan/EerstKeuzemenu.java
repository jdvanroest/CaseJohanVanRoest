package nl.belastingdienst.caseJohan;

import java.util.Scanner;
//todo keuzemenu afmaken
public class EerstKeuzemenu {

    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Vrachtwagen toevoegen/verwijderen" +
                "\n" + "(2)Chassis toevoegen/verwijderen" + "\n" + "(3)Tank toevoegen/verwijderen" + "\n" +
                "(4)Lijst APK data weergeven" + "\n" + "(5)Locatie van een chassis weergeven" + "\n" +
                "(6)Chassis achter vrachtwagen weergeven" + "\n" + "(7)Transportopdracht plannen");


        int keuze = Integer.parseInt(scanner.nextLine());
        int keuzeVrachtwagen =0;
        int keuzeChassis = 0;
        int keuzeTank =0;

        switch(keuze){
            case 1:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Vrachtwagen toevoegen" + "\n" +
                        "(2)Vrachtwagen verwijderen");
                keuzeVrachtwagen = Integer.parseInt(scanner.nextLine());
                break;
            case 2:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Chassis toevoegen" + "\n" +
                        "(2)Chassis verwijderen");
                keuzeChassis = Integer.parseInt(scanner.nextLine());
                break;
            case 3:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Tank toevoegen" + "\n" +
                        "(2)Tank verwijderen");
                keuzeTank = Integer.parseInt(scanner.nextLine());
                break;


        }

        switch(keuzeVrachtwagen){
            case 1:
                VrachtwagenFactory invoerenVrachtwagen = new VrachtwagenFactory();
                Vrachtwagen v2 = invoerenVrachtwagen.makenVrachtwagenMetScanner();
                break;
            case 2:
                System.out.println("keuze 2 gekozen");
        }

        switch (keuzeChassis){
            case 1:
                System.out.println("keuze 1 gekozen");
                break;
            case 2:
                System.out.println("keuze 2 gekozen");
        }
    }
}

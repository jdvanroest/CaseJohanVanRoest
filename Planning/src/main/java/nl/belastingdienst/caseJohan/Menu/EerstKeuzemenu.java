package nl.belastingdienst.caseJohan.Menu;

import nl.belastingdienst.caseJohan.Controllers.ChassisController;
import nl.belastingdienst.caseJohan.Controllers.CreateApkDatumLijst;
import nl.belastingdienst.caseJohan.Controllers.TankController;
import nl.belastingdienst.caseJohan.Controllers.VrachtwagenController;

import java.util.Scanner;

public class EerstKeuzemenu {
    //todo keuzemenu afmaken
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
        int keuzeApkLijst =0;

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
            case 4:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)APK lijst voor vrachtwagens"
                        + "\n" + "(2)APK lijst voor chassis" + "\n" + "(3)APK lijst vrachtwagens en chassis");
                keuzeApkLijst = Integer.parseInt(scanner.nextLine());

        }

        VrachtwagenController invoerenVrachtwagen = new VrachtwagenController();
        switch(keuzeVrachtwagen){
            case 1:
                invoerenVrachtwagen.makenVrachtwagenMetScanner();
                break;
            case 2:
                invoerenVrachtwagen.verwijderenVrachtwagenMetScanner();
                break;
        }

        ChassisController chassisController = new ChassisController();
        switch (keuzeChassis){
            case 1:
               chassisController.makenChassisMetScanner();
                break;
            case 2:
                chassisController.verwijderenChassisMetScanner();
                break;
        }

        TankController tankController = new TankController();
        switch (keuzeTank){
            case 1:
                tankController.makenTankMetScanner();
                break;
            case 2:
                tankController.verwijderenTankMetScanner();
                break;
        }

        CreateApkDatumLijst createApkDatumLijst = new CreateApkDatumLijst();
        switch (keuzeApkLijst){
            case 1:
                createApkDatumLijst.vrachtwagenApkLijstMaken();
                break;
            case 2:
                createApkDatumLijst.chassisApkLijstMaken();
                break;
            case 3:
                createApkDatumLijst.VrachtwagenEnChassisAPKLijstMaken();
                break;
        }
    }
}

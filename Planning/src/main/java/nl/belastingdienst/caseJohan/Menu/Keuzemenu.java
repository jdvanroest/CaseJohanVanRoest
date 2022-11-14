package nl.belastingdienst.caseJohan.Menu;

import nl.belastingdienst.caseJohan.Controllers.ChassisController;
import nl.belastingdienst.caseJohan.Controllers.CreateApkDatumLijst;
import nl.belastingdienst.caseJohan.Controllers.TankController;
import nl.belastingdienst.caseJohan.Controllers.VrachtwagenController;

import java.util.Scanner;

public class Keuzemenu {
    //todo keuzemenu afmaken
    Scanner scanner = new Scanner(System.in);
    int keuzeApkLijst = 0;
    int keuzeTank = 0;
    int keuzeChassis = 0;
    int keuzeVrachtwagen = 0;
    int keuze = 0;
    int keuzeChassisLocatieWeergeven= 0;
    int keuzeChassisVrachtwagenWeergeven =0;

    public void start() {
        System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Vrachtwagen toevoegen/verwijderen/locatie updaten/chassis aankoppelen" +
                "\n" + "(2)Chassis toevoegen/verwijderen" + "\n" + "(3)Tank toevoegen/verwijderen" + "\n" +
                "(4)Lijst APK data weergeven" + "\n" + "(5)Locatie van een chassis weergeven" + "\n" +
                "(6)Chassis achter vrachtwagen weergeven" + "\n" + "(7)Transportopdracht plannen");

        keuze = Integer.parseInt(scanner.nextLine());

        tweedeKeuzeMenu();
    }


    public void tweedeKeuzeMenu() {

        switch (keuze) {
            case 1:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Vrachtwagen toevoegen" + "\n" +
                        "(2)Vrachtwagen verwijderen" + "\n" + "(3)Locatie vrachtwagen updaten" + "\n" +
                        "(4)Chassis aankoppelen" + "\n" + "(5)Terug naar startmenu");
                keuzeVrachtwagen = Integer.parseInt(scanner.nextLine());
                keuzeVrachtwagen();
                break;
            case 2:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Chassis toevoegen" + "\n" +
                        "(2)Chassis verwijderen");
                keuzeChassis = Integer.parseInt(scanner.nextLine());
                keuzeChassis();
                break;
            case 3:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Tank toevoegen" + "\n" +
                        "(2)Tank verwijderen");
                keuzeTank = Integer.parseInt(scanner.nextLine());
                keuzeTank();
                break;
            case 4:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)APK lijst voor vrachtwagens"
                        + "\n" + "(2)APK lijst voor chassis" + "\n" + "(3)APK lijst vrachtwagens en chassis");
                keuzeApkLijst = Integer.parseInt(scanner.nextLine());
                keuzeApkLijst();
                break;
            case 5:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Locatie chassis weergeven"
                        + "\n" +  "(2)Terug naar startmenu");
                keuzeChassisLocatieWeergeven = Integer.parseInt(scanner.nextLine());
                keuzeChassisLocatieWeergeven();
                break;
            case 6:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Chassis achter vrachtwagen weergeven"
                        + "\n" +  "(2)Terug naar startmenu");
                keuzeChassisVrachtwagenWeergeven = Integer.parseInt(scanner.nextLine());
                keuzeChassisVrachtwagenWeergeven();
                break;
        }
    }


    public void keuzeVrachtwagen() {
        VrachtwagenController vrachtwagenController = new VrachtwagenController();
        switch (keuzeVrachtwagen) {
            case 1:
                vrachtwagenController.makenVrachtwagenMetScanner();
                keuzeVrachtwagen();
                break;
            case 2:
                vrachtwagenController.verwijderenVrachtwagenMetScanner();
                keuzeVrachtwagen();
                break;
            case 3:
                vrachtwagenController.vrachtwagenLocatieUpdaten();
                keuzeVrachtwagen();
                break;
            case 4:
                vrachtwagenController.chassisAankoppelen();
                keuzeVrachtwagen();
                break;
        }
    }

    public void keuzeChassis(){
        ChassisController chassisController = new ChassisController();
        switch (keuzeChassis) {
            case 1:
                chassisController.makenChassisMetScanner();
                keuzeChassis();
                break;
            case 2:
                chassisController.verwijderenChassisMetScanner();
                keuzeChassis();
                break;
        }
    }
    public void keuzeTank(){
        TankController tankController = new TankController();
        switch (keuzeTank) {
            case 1:
                tankController.makenTankMetScanner();
                keuzeTank();
                break;
            case 2:
                tankController.verwijderenTankMetScanner();
                keuzeTank();
                break;
        }
    }
    public void keuzeApkLijst() {
        CreateApkDatumLijst createApkDatumLijst = new CreateApkDatumLijst();
        switch (keuzeApkLijst) {
            case 1:
                createApkDatumLijst.vrachtwagenApkLijstMaken();
                keuzeApkLijst();
                break;
            case 2:
                createApkDatumLijst.chassisApkLijstMaken();
                keuzeApkLijst();
                break;
            case 3:
                createApkDatumLijst.VrachtwagenEnChassisAPKLijstMaken();
                keuzeApkLijst();
                break;
            case 4:
                start();
                break;
            }
        }
    public void keuzeChassisLocatieWeergeven() {
        ChassisController chassisController = new ChassisController();
        switch (keuzeChassisLocatieWeergeven) {
            case 1:
                chassisController.locatieChassis();
                tweedeKeuzeMenu();
                break;
            case 2:
                start();
                break;
            }
        }
     public void keuzeChassisVrachtwagenWeergeven(){
        VrachtwagenController vrachtwagenController = new VrachtwagenController();
        switch (keuzeChassisVrachtwagenWeergeven){
            case 1:
                vrachtwagenController.aangekoppeldeChassisWeergeven();
                tweedeKeuzeMenu();
            case 2:
                start();
                break;
        }
    }
}

package nl.belastingdienst.caseJohan.Controllers;


import nl.belastingdienst.caseJohan.view.ChassisView;
import nl.belastingdienst.caseJohan.view.HoofdmenuView;
import nl.belastingdienst.caseJohan.view.TankView;
import nl.belastingdienst.caseJohan.view.VrachtwagenView;

import javax.inject.Inject;
import java.util.Scanner;

public class Hoofdmenu {
    @Inject
    HoofdmenuView hoofdmenuView;
    @Inject
    VrachtwagenView vrachtwagenView;
    @Inject
    VrachtwagenController vrachtwagenController;
    @Inject
    ChassisView chassisView;
    TankView tankView = new TankView();

    Scanner scanner = new Scanner(System.in);
    int keuzeApkLijst = 0;
    int keuzeTank = 0;
    int keuzeChassis = 0;
    int keuzeVrachtwagen = 0;
    int keuze = 0;
    int keuzeChassisLocatieWeergeven= 0;
    int keuzeChassisVrachtwagenWeergeven =0;
    int keuzeTransportopdracht =0;

    public void start() {
       hoofdmenuView.showHoofdmenuOptions();
       keuze = Integer.parseInt(scanner.nextLine());
       tweedeKeuzeMenu();
    }


    public void tweedeKeuzeMenu() {

        switch (keuze) {
            case 1:
                vrachtwagenView.showVrachtwagenMenuOptions();
                keuzeVrachtwagen = Integer.parseInt(scanner.nextLine());
                keuzeVrachtwagen();
                break;
            case 2:
                chassisView.showChassisMenuOptions();
                keuzeChassis = Integer.parseInt(scanner.nextLine());
                keuzeChassis();
                break;
            case 3:
                tankView.showTankMenuOptions();
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
            case 7:
                System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Transportopdracht toevoegen"
                        + "\n" + "(2)Transportopdracht plannen" + "\n" + "(3)Transportopdracht uitvoeren" + "\n"
                        +  "(4)Terug naar startmenu");
                keuzeTransportopdracht = Integer.parseInt(scanner.nextLine());
                keuzeTransportopdracht();
                break;
            case 8:
                break;
        }
    }


    public void keuzeVrachtwagen() {

        switch (keuzeVrachtwagen) {
            case 1:
                vrachtwagenController.makenVrachtwagenMetScanner();
                start();
                break;
            case 2:
                vrachtwagenController.verwijderenVrachtwagenMetScanner();
                start();
                break;
            case 3:
                vrachtwagenController.vrachtwagenLocatieUpdaten();
                start();
                break;
            case 4:
                vrachtwagenController.chassisAankoppelen();
                start();
                break;
            case 5:
                start();
        }
    }

    public void keuzeChassis(){
        ChassisController chassisController = new ChassisController();
        switch (keuzeChassis) {
            case 1:
                chassisController.makenChassisMetScanner();
                start();
                break;
            case 2:
                chassisController.verwijderenChassisMetScanner();
                start();
                break;
            case 3:
                start();
                break;
        }
    }
    public void keuzeTank(){
        TankController tankController = new TankController();
        switch (keuzeTank) {
            case 1:
                tankController.makenTankMetScanner();
                start();
                break;
            case 2:
                tankController.verwijderenTankMetScanner();
                start();
                break;
            case 3:
                start();
                break;
        }
    }
    public void keuzeApkLijst() {
        CreateApkDatumLijst createApkDatumLijst = new CreateApkDatumLijst();
        switch (keuzeApkLijst) {
            case 1:
                createApkDatumLijst.vrachtwagenApkLijstMaken();
                start();
                break;
            case 2:
                createApkDatumLijst.chassisApkLijstMaken();
                start();
                break;
            case 3:
                createApkDatumLijst.VrachtwagenEnChassisAPKLijstMaken();
                start();
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
                start();
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
                start();
                break;
            case 2:
                start();
                break;
        }
    }
    public void keuzeTransportopdracht(){
        TransportopdrachtController transportopdrachtController = new TransportopdrachtController();
        switch(keuzeTransportopdracht){
            case 1:
                transportopdrachtController.makenTransportOpdrachtMetScanner();
                start();
                break;
            case 2:
                transportopdrachtController.transportopdrachtPlannen();
                start();
                break;
            case 3:
                transportopdrachtController.uitgevoerdeTransportopdrachtVerwerken();
                start();
                break;
            case 4:
                start();
                break;
        }
    }
}

package nl.belastingdienst.caseJohan.Controllers;


import nl.belastingdienst.caseJohan.view.*;

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
    @Inject
    TankView tankView;
    @Inject
    APKView apkView;
    @Inject
    TransportopdrachtView transportopdrachtView;
    @Inject
    TransportopdrachtController transportopdrachtController;
    @Inject
    ScannerInputValidation scannerInputValidation;
    @Inject
    Scanner scanner;

    public void start() {
       hoofdmenuView.showHoofdmenuOptions();
       int keuze = Integer.parseInt(scanner.nextLine());
       tweedeKeuzeMenu(keuze);
    }


    public void tweedeKeuzeMenu(int keuze) {
        switch (keuze) {
            case 1:
                vrachtwagenView.showVrachtwagenMenu();
                keuzeVrachtwagen(scannerInputValidation.intInputValidation(1,5,"Verkeerde invoer. Voer de gewenste keuze tussen 1 en 5 in"));
                break;
            case 2:
                chassisView.showChassisMenu();
                keuzeChassis(scannerInputValidation.intInputValidation(1,3,"Verkeerde invoer. Voer de gewenste keuze tussen 1 en 3 in"));
                break;
            case 3:
                tankView.showTankMenu();
                keuzeTank(scannerInputValidation.intInputValidation(1,3, "Verkeerde invoer. Voer de gewenste keuze tussen 1 en 3 in"));
                break;
            case 4:
                apkView.showAPKMenu();
                int keuzeApkLijst = Integer.parseInt(scanner.nextLine());
                keuzeApkLijst(keuzeApkLijst);
                break;
            case 5:
                chassisView.showChassisLocationMenu();
                int keuzeChassisLocatieWeergeven = Integer.parseInt(scanner.nextLine());
                keuzeChassisLocatieWeergeven(keuzeChassisLocatieWeergeven);
                break;
            case 6:
                vrachtwagenView.chassisAchterVrachtwagenMenuOptions();
                int keuzeChassisVrachtwagenWeergeven = Integer.parseInt(scanner.nextLine());
                keuzeChassisVrachtwagenWeergeven(keuzeChassisVrachtwagenWeergeven);
                break;
            case 7:
                transportopdrachtView.showTransportopdrachtMenu();
                int keuzeTransportopdracht = Integer.parseInt(scanner.nextLine());
                transportopdrachtController.keuzeTransportopdracht(keuzeTransportopdracht);
                break;
            case 8:
                break;
        }
    }


    public void keuzeVrachtwagen(int keuzeVrachtwagen) {
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

    public void keuzeChassis(int keuzeChassis){
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
    public void keuzeTank(int keuzeTank){
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
    public void keuzeApkLijst(int keuzeApkLijst) {
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
    public void keuzeChassisLocatieWeergeven(int keuzeChassisLocatieWeergeven) {
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
     public void keuzeChassisVrachtwagenWeergeven(int keuzeChassisVrachtwagenWeergeven){
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

}

package nl.belastingdienst.caseJohan.view;

public class VrachtwagenView {

    public void showVrachtwagenMenu(){
        System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Vrachtwagen toevoegen" + "\n" +
                "(2)Vrachtwagen verwijderen" + "\n" + "(3)Locatie vrachtwagen updaten" + "\n" +
                "(4)Chassis aankoppelen" + "\n" + "(5)Terug naar startmenu");
    }

    public void chassisAchterVrachtwagenMenuOptions(){
        System.out.println("Maak een keuze uit de volgende opties:" + "\n" + "(1)Chassis achter vrachtwagen weergeven"
                + "\n" +  "(2)Terug naar startmenu");
    }
}

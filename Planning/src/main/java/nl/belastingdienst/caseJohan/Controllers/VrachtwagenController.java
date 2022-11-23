package nl.belastingdienst.caseJohan.Controllers;

import nl.belastingdienst.caseJohan.model.Chassis;
import nl.belastingdienst.caseJohan.model.Locatie;
import nl.belastingdienst.caseJohan.model.Vrachtwagen;
import nl.belastingdienst.caseJohan.model.enums.Merk;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VrachtwagenController {
    @Inject
    Scanner scanner;
    ScannerInputValidation scannerInputValidation = new ScannerInputValidation();

    @Inject
    EntityManager em;

    public Vrachtwagen makenVrachtwagenMetScanner() {
        Merk m = Merk.NOTDEFINEDYET;
        int gewicht =0;
        LocalDate apkdatum = LocalDate.parse("01.01.2023", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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

        while(gewicht<5000 || gewicht>16000) {
            System.out.println("\n" + "Voer het lediggewicht in kg van de vrachtwagen in");
            try {
                gewicht = Integer.parseInt(scanner.nextLine());
                System.out.println("Het ingevoerde gewicht is " + gewicht + " kg");
                if (gewicht < 5000 || gewicht > 16000) {
                    System.out.println("Geen geldige invoer");
                }
            } catch (Exception e) {
                System.out.println("Geen geldige invoer.");
            }
        }


        System.out.println("\n" + "Voer de kilometerstand van de vrachtwagen in");
        int kilometerstand = scannerInputValidation.intInputValidation(0, 2147483647, "Verkeerde invoer. Voer de kilometerstand van de vrachtwagen in");
        System.out.println("De ingevoerde kilometerstand is " + kilometerstand);


        System.out.println("\n" +"Voer de apkdatum [dd.mm.yyyy] van de vrachtwagen in");
        for (int i = 1; i <= 2; i += 1) {
            try{
                String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        apkdatum = LocalDate.parse(str, dtf);
        break;
            }catch (Exception e){
                System.out.println("Verkeerde invoer. Voer de apkdatum [dd.mm.yyyy] van de vrachtwagen in");
                i-=1;
            }}

        em.getTransaction().begin();
        Vrachtwagen vrachtwagen = new Vrachtwagen(m, kenteken, gewicht, kilometerstand, apkdatum, null, em.find(Locatie.class, "parbed"));
        em.persist(vrachtwagen);
        em.getTransaction().commit();

        return vrachtwagen;
    }

    public void aangekoppeldeChassisWeergeven(){
        System.out.println("Voer het kenteken van de vrachtwagen waarvan je het chassis wilt weten in");
        // String kentekenVrachtwagen = scanner.nextLine();
        String kentekenVrachtwagen = scannerInputValidation.scannerValidation();
        em.getTransaction().begin();
        String kentekenChassisAchterVrachtwagen = em.createQuery("SELECT v from Vrachtwagen v WHERE " +
                "v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class).getSingleResult().getChassis().getKenteken();
        em.getTransaction().commit();
        System.out.println("Vrachtwagen met kenteken " + kentekenVrachtwagen + " heeft chassis met kenteken "
                + kentekenChassisAchterVrachtwagen + "\n");
    }

    public void chassisAankoppelen(){
        System.out.println("\n" + "Voer het kenteken in van de vrachtwagen die het chassis aankoppeld");
        String kentekenVrachtwagen = scanner.nextLine();
        System.out.println("Voer kenteken in van het chassis dat aangekoppeld moet worden");
        String kentekenChassis = scanner.nextLine();
        em.getTransaction().begin();
        Vrachtwagen vrachtwagenToUpdate = em.createQuery("SELECT v from Vrachtwagen v WHERE " +
               "v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class).getSingleResult();
        Chassis chassisOmAanTeKoppelen = em.createQuery("SELECT c From Chassis c WHERE " +
                "c.kenteken = '" + kentekenChassis +"'", Chassis.class).getSingleResult();
        vrachtwagenToUpdate.setChassisAchterVrachtwagen(chassisOmAanTeKoppelen);
        vrachtwagenToUpdate.setLocatieVrachtwagen(chassisOmAanTeKoppelen.getLocatie());
        em.getTransaction().commit();
    }

    public void vrachtwagenLocatieUpdaten(){
        System.out.println("Voer het kenteken van de vrachtwagen in");
        String kentekenVrachtwagen = scanner.nextLine();
        System.out.println("Voer de locatiecode van de nieuwe locatie in");
        String locatiePK = scanner.nextLine();
        em.getTransaction().begin();
        Vrachtwagen vrachtwagenToUpdate = em.createQuery("SELECT v from Vrachtwagen v WHERE v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class).getSingleResult();
        vrachtwagenToUpdate.setLocatieVrachtwagen(em.find(Locatie.class, locatiePK));
        em.getTransaction().commit();
    }

    public void verwijderenVrachtwagenMetScanner(){
        System.out.println("\n" + "Voer het kenteken van de vrachtwagen in");
        String kentekenVrachtwagen = scanner.nextLine();
        System.out.println("Het kenteken is " + kentekenVrachtwagen);
        em.getTransaction().begin();
        TypedQuery vrachtwagenToRemove = em.createQuery("SELECT v from Vrachtwagen v WHERE v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class );
        em.remove(vrachtwagenToRemove.getSingleResult());
        em.getTransaction().commit();
    }
}


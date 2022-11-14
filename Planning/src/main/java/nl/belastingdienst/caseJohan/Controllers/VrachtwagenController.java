package nl.belastingdienst.caseJohan.Controllers;

import nl.belastingdienst.caseJohan.Entities.Chassis;
import nl.belastingdienst.caseJohan.Entities.Locatie;
import nl.belastingdienst.caseJohan.Entities.Vrachtwagen;
import nl.belastingdienst.caseJohan.enums.Merk;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VrachtwagenController {
    Scanner scanner = new Scanner(System.in);
    CreateEntityManager createEntityManager = new CreateEntityManager();
    EntityManager em = createEntityManager.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    public Vrachtwagen makenVrachtwagenMetScanner() {
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

        System.out.println("\n" +"Voer de apkdatum [dd.mm.yyyy] van de vrachtwagen in");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate apkdatum = LocalDate.parse(str, dtf);

        EntityManager em = createEntityManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Vrachtwagen vrachtwagen = new Vrachtwagen(m, kenteken, gewicht, kilometerstand, apkdatum, null, em.find(Locatie.class, "parbed"));
        em.persist(vrachtwagen);
        tx.commit();

        return vrachtwagen;
    }

    public void aangekoppeldeChassisWeergeven(){
        System.out.println("Voer het kenteken van de vrachtwagen waarvan je het chassis wilt weten in");
        String kentekenVrachtwagen = scanner.nextLine();
        tx.begin();
        TypedQuery<Vrachtwagen> vrachtwagenToFind = em.createQuery("SELECT v from Vrachtwagen v WHERE " +
                "v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class );
        Vrachtwagen vrachtwagenChassis = em.find(Vrachtwagen.class, vrachtwagenToFind.getSingleResult().getId());
        System.out.println(vrachtwagenChassis.getChassis().getKenteken());
        tx.commit();
    }

    public void chassisAankoppelen(){
        System.out.println("\n" + "Voer het kenteken in van de vrachtwagen die het chassis aankoppeld");
        String kentekenVrachtwagen = scanner.nextLine();
        System.out.println("Voer kenteken in van het chassis dat aangekoppeld moet worden");
        String kentekenChassis = scanner.nextLine();
        tx.begin();
        TypedQuery<Vrachtwagen> vrachtwagenToFind = em.createQuery("SELECT v from Vrachtwagen v WHERE " +
                "v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class );
        Vrachtwagen vrachtwagenToUpdate = em.find(Vrachtwagen.class, vrachtwagenToFind.getSingleResult().getId());
        TypedQuery<Chassis> chassisToFind = em.createQuery("SELECT c From Chassis c WHERE " +
                "c.kenteken = '" + kentekenChassis +"'", Chassis.class);
        Chassis gewensteChassis = em.find(Chassis.class, chassisToFind.getSingleResult().getId());
        vrachtwagenToUpdate.setChassisAchterVrachtwagen(gewensteChassis);
        tx.commit();
    }

    public void vrachtwagenLocatieUpdaten(){
        System.out.println("Voer het kenteken van de vrachtwagen in");
        String kentekenVrachtwagen = scanner.nextLine();
        System.out.println("Voer de locatiecode van de nieuwe locatie in");
        String locatiePK = scanner.nextLine();
        tx.begin();
        TypedQuery<Vrachtwagen> vrachtwagenToFind = em.createQuery("SELECT v from Vrachtwagen v WHERE v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class );
        Vrachtwagen vrachtwagenToUpdate = em.find(Vrachtwagen.class, vrachtwagenToFind.getSingleResult().getId());
        vrachtwagenToUpdate.setLocatieVrachtwagen(em.find(Locatie.class, locatiePK));
        tx.commit();
    }

    public void verwijderenVrachtwagenMetScanner(){
        System.out.println("\n" + "Voer het kenteken van de vrachtwagen in");
        String kentekenVrachtwagen = scanner.nextLine();
        System.out.println("Het kenteken is " + kentekenVrachtwagen);
        tx.begin();
        TypedQuery vrachtwagenToRemove = em.createQuery("SELECT v from Vrachtwagen v WHERE v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class );
        em.remove(vrachtwagenToRemove.getSingleResult());
        tx.commit();
    }
}


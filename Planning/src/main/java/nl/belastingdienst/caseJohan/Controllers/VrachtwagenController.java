package nl.belastingdienst.caseJohan.Controllers;

import nl.belastingdienst.caseJohan.Entities.Vrachtwagen;
import nl.belastingdienst.caseJohan.enums.Merk;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VrachtwagenController {
    Scanner scanner = new Scanner(System.in);
    CreateEntityManager createEntityManager = new CreateEntityManager();

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
        Vrachtwagen vrachtwagen = new Vrachtwagen(m, kenteken, gewicht, kilometerstand, apkdatum);
        em.persist(vrachtwagen);
        tx.commit();

        return vrachtwagen;
    }

    public void verwijderenVrachtwagenMetScanner(){
        EntityManager em = createEntityManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        System.out.println("\n" + "Voer het kenteken van de vrachtwagen in");
        String kentekenVrachtwagen = scanner.nextLine();
        System.out.println("Het kenteken is " + kentekenVrachtwagen);
        tx.begin();
        TypedQuery vrachtwagenToRemove = em.createQuery("SELECT v from Vrachtwagen v WHERE v.kenteken = '" + kentekenVrachtwagen + "'", Vrachtwagen.class );
        em.remove(vrachtwagenToRemove.getSingleResult());
        tx.commit();
    }
}

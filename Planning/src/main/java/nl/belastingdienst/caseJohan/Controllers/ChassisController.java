package nl.belastingdienst.caseJohan.Controllers;

import nl.belastingdienst.caseJohan.model.Chassis;
import nl.belastingdienst.caseJohan.model.Locatie;
import nl.belastingdienst.caseJohan.model.enums.LengteChassis;
import nl.belastingdienst.caseJohan.services.CreateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChassisController {

    Scanner scanner = new Scanner(System.in);
    CreateEntityManager createEntityManager = new CreateEntityManager();
    EntityManager em = createEntityManager.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    public Chassis makenChassisMetScanner () {
        LengteChassis lengteChassis = LengteChassis.NOTDEFINEDYET;
        System.out.println("Voer het kenteken van het chassis in");
        String kenteken = scanner.nextLine();
        System.out.println("Het kenteken is " + kenteken);

        System.out.println("Voer het gewicht van het chassis in");
        int gewicht = Integer.parseInt(scanner.nextLine());
        System.out.println("Het gewicht is " + gewicht + " kg");

        System.out.println("Voer de lengte van het chassis in. FT20 of FT40");
        String s = scanner.nextLine();
        lengteChassis = LengteChassis.valueOf(s);
        System.out.println("De lengte is " + lengteChassis);

        System.out.println("voer de apkdatum [dd.mm.yyyy] van het chassis in ");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate apkdatum = LocalDate.parse(str, dtf);

        System.out.println("Voer de locatie van het chassis in");
        String locatie = scanner.nextLine();


        tx.begin();
        Chassis chassis = new Chassis(kenteken, gewicht, lengteChassis, apkdatum, em.find(Locatie.class, locatie));
        em.persist(chassis);
        tx.commit();
        return chassis;
    }
    public void verwijderenChassisMetScanner () {
        System.out.println("\n" + "Voer het kenteken van het chassis in");
        String kentekenChassis = scanner.nextLine();
        System.out.println("Het kenteken is " + kentekenChassis);
        tx.begin();
        TypedQuery chassisToRemove = em.createQuery("SELECT c from Chassis c WHERE c.kenteken = '" + kentekenChassis + "'", Chassis.class);
        em.remove(chassisToRemove.getSingleResult());
        tx.commit();
    }

    public void locatieChassis(){
        System.out.println("Voer het kenteken van het chassis waarvan je de locatie wil weten in");
        String kentekenChassis = scanner.nextLine();
        tx.begin();
        TypedQuery<Chassis> chassisToFindLocation = em.createQuery("SELECT c from Chassis c WHERE c.kenteken = '" + kentekenChassis + "'", Chassis.class);
        em.find(Chassis.class, chassisToFindLocation.getSingleResult().getId());
        System.out.println(kentekenChassis + " is op locatie " + chassisToFindLocation.getSingleResult().getLocatie() + "\n");
        tx.commit();
    }
}

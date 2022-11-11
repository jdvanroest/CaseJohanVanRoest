package nl.belastingdienst.caseJohan.Controllers;

import nl.belastingdienst.caseJohan.Entities.Chassis;
import nl.belastingdienst.caseJohan.enums.LengteChassis;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChassisController {
    Scanner scanner = new Scanner(System.in);
    CreateEntityManager createEntityManager = new CreateEntityManager();

    public Chassis makenChassisMetScanner(){
        LengteChassis lengteChassis = LengteChassis.NOTDEFINEDYET;
        System.out.println("Voer het kenteken van het chassis in");
        String kenteken = scanner.nextLine();
        System.out.println("Het kenteken is " + kenteken);

        System.out.println("Voer het gewicht van het chassis in");
        int gewicht = Integer.parseInt(scanner.nextLine());
        System.out.println("Het gewicht is " + gewicht + " kg");

        System.out.println("Voer de lengte van het chassis in. 20ft of 40ft");
        String s = scanner.nextLine();
        lengteChassis = LengteChassis.valueOf(s);
        System.out.println("De lengte is " + lengteChassis);

        System.out.println("voer de apkdatum [dd.mm.yyyy] van het chassis in ");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate apkdatum = LocalDate.parse(str, dtf);

        EntityManager em = createEntityManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Chassis chassis = new Chassis(kenteken, gewicht, lengteChassis, apkdatum);
        em.persist(chassis);
        tx.commit();
        return chassis;
    }

    public void verwijderenChassisMetScanner(){
        EntityManager em = createEntityManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        System.out.println("\n" + "Voer het kenteken van het chassis in");
        String kentekenChassis = scanner.nextLine();
        System.out.println("Het kenteken is " + kentekenChassis);
        tx.begin();
       TypedQuery chassisToRemove = em.createQuery("SELECT c from Chassis c WHERE c.kenteken = '" + kentekenChassis + "'", Chassis.class);
        em.remove(chassisToRemove);
        tx.commit();
    }
}

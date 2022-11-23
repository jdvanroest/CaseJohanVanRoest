package nl.belastingdienst.caseJohan.Controllers;

import nl.belastingdienst.caseJohan.model.Locatie;
import nl.belastingdienst.caseJohan.model.Tank;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class TankController {
    @Inject
    Scanner scanner;
    @Inject
    EntityManager em;
    EntityTransaction tx = em.getTransaction();


    public Tank makenTankMetScanner() {
        System.out.println("\n" + "Voer de naam van de tank in");
        String naam = scanner.nextLine();
        System.out.println("De naam is " + naam);
        System.out.println("\n" + "Voer het lediggewicht in kg van de tank in");
        int gewicht = Integer.parseInt(scanner.nextLine());
        System.out.println("Het gewicht is " + gewicht + " kg");
        System.out.println("\n" + "Voer de inhoud van de tank in liters in");
        int inhoud = Integer.parseInt(scanner.nextLine());
        System.out.println("De inhoud in liters is " + inhoud);

        tx.begin();
        Tank tank = new Tank(naam, gewicht, inhoud, em.find(Locatie.class, "boarot"));
        em.persist(tank);
        tx.commit();

        return tank;
    }

    public void verwijderenTankMetScanner(){

        System.out.println("\n" + "Voer de naam van de tank in");
        String tanknaam = scanner.nextLine();
        System.out.println("De naam is " + tanknaam);

        tx.begin();
        TypedQuery tankToRemoveQuery = em.createQuery("SELECT t from Tank t WHERE t.naam = '" + tanknaam + "'", Tank.class);
        em.remove(tankToRemoveQuery.getSingleResult());
        tx.commit();
    }
}

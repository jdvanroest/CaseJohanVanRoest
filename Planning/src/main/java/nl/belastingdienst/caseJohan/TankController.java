package nl.belastingdienst.caseJohan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Scanner;

public class TankController {

    Scanner scanner = new Scanner(System.in);
    CreateEntityManager createEntityManager = new CreateEntityManager();

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

        EntityManager em = createEntityManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Tank tank = new Tank(naam, gewicht, inhoud);
        em.persist(tank);
        tx.commit();

        return tank;
    }
}

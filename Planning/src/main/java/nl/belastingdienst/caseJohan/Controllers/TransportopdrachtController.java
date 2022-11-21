package nl.belastingdienst.caseJohan.Controllers;

import nl.belastingdienst.caseJohan.model.*;
import nl.belastingdienst.caseJohan.services.CreateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class TransportopdrachtController {

    Scanner scanner = new Scanner(System.in);
    CreateEntityManager createEntityManager = new CreateEntityManager();
    EntityManager em = createEntityManager.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void makenTransportOpdrachtMetScanner(){
        System.out.println("Voer het ID van tank die verplaats moet worden in");
        int idTeVerplaatsenTank = Integer.parseInt(scanner.nextLine());

        System.out.println("Voer de locatiecode van de eindlocatie van transportopdracht in");
        String PkEindLocatieTank = scanner.nextLine();

        tx.begin();
        Tank teVerplaatsenTank = em.find(Tank.class, idTeVerplaatsenTank);
        Locatie beginlocatie = em.find(Locatie.class, teVerplaatsenTank.getLocatieTank().getLocatiecode());
        Locatie eindlocatie = em.find(Locatie.class, PkEindLocatieTank);
        Transportopdracht transportopdracht = new Transportopdracht(teVerplaatsenTank, beginlocatie, eindlocatie);
        em.persist(transportopdracht);
        tx.commit();
        System.out.println("Transportopdracht ingevoerd met bijbehorende id nummer" + transportopdracht.getId()
            + " voor het verplaatsen van tank " + teVerplaatsenTank.getNaam() + " van " + beginlocatie.getNaam()
            + " naar " + eindlocatie.getNaam() + "\n");
    }

    public void transportopdrachtPlannen() {
        System.out.println("Voer het ID van de te plannen opdracht in");
        int pkTePlannenOpdracht = Integer.parseInt(scanner.nextLine());
        System.out.println("Voer het kenteken van de vrachtwagen die de opdracht uit moet voeren in");
        String kentekenGeplandeVrachtwagen = scanner.nextLine();

        tx.begin();
        Transportopdracht transportopdrachtToUpdate = em.find(Transportopdracht.class, pkTePlannenOpdracht);
        TypedQuery<Vrachtwagen> vrachtwagenToFind = em.createQuery("SELECT v from Vrachtwagen v WHERE " +
                "v.kenteken = '" + kentekenGeplandeVrachtwagen + "'", Vrachtwagen.class);
        Vrachtwagen geplandeVrachtwagen = em.find(Vrachtwagen.class, vrachtwagenToFind.getSingleResult().getId());
        if (geplandeVrachtwagen.getChassis() == null) {
            System.out.println("Let op, vrachtwagen heeft geen chassis bij zich" + "\n");
            Hoofdmenu hoofdmenu = new Hoofdmenu();
            hoofdmenu.start();
        } else {
            transportopdrachtToUpdate.setVrachtwagen(geplandeVrachtwagen);
            tx.commit();
            System.out.println("Rit " + pkTePlannenOpdracht + " is gepland met vrachtwagen "
                    + vrachtwagenToFind.getSingleResult().getKenteken() + "\n");
        }
    }

    public void uitgevoerdeTransportopdrachtVerwerken(){
        System.out.println("Voer het ID van de uitgevoerde opdracht in");
        int pkUitgevoerdeOpdracht = Integer.parseInt(scanner.nextLine());

        tx.begin();
        Transportopdracht uitgevoerdeTransportopdracht = em.find(Transportopdracht.class, pkUitgevoerdeOpdracht);
        uitgevoerdeTransportopdracht.setUitgevoerd(true);
        Vrachtwagen vrachtwagen = em.find(Vrachtwagen.class, uitgevoerdeTransportopdracht.getVrachtwagen().getId());
        vrachtwagen.setLocatieVrachtwagen(uitgevoerdeTransportopdracht.getEindlocatie());
        Chassis chassis = em.find(Chassis.class, uitgevoerdeTransportopdracht.getVrachtwagen().getChassis().getId());
        chassis.setLocatieChassis(uitgevoerdeTransportopdracht.getEindlocatie());
        Tank tank = em.find(Tank.class, uitgevoerdeTransportopdracht.getTank().getId());
        tank.setLocatieTank(uitgevoerdeTransportopdracht.getEindlocatie());
        tx.commit();
        System.out.println("Opdracht is uitgevoerd. Vrachtwagen, chassis en tank zijn nu op locatie "
                + uitgevoerdeTransportopdracht.getEindlocatie() + "\n");
    }
}

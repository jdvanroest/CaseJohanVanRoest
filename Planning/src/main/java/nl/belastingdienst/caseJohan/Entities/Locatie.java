package nl.belastingdienst.caseJohan.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Locatie {
    @Id
    private int naam;
}

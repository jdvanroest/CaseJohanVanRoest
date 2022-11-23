package nl.belastingdienst.caseJohan;

import nl.belastingdienst.caseJohan.Controllers.Hoofdmenu;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;

public class Main {

    public static void main(String[] args){
        //todo mockdata tabellen droppen bijwerken
//        Mockdata mockdata = new Mockdata();
//        mockdata.mockdataInvoeren();
        
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();

        Hoofdmenu hoofdmenu = cdiContainer.select(Hoofdmenu.class).get();

        hoofdmenu.start();

    }
}

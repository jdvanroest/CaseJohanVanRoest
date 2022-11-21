package nl.bld.weld.experiments;

import nl.belastingdienst.caseJohan.Controllers.Hoofdmenu;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeldTests {

    @Test
    @DisplayName("Start running Weld")
    void startContainer(){
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();

        WeldInstance<Hoofdmenu> proxy = cdiContainer.select(Hoofdmenu.class);
        Hoofdmenu hoofdmenu = proxy.get();

        hoofdmenu.start();

        cdiContainer.shutdown();



     }
}

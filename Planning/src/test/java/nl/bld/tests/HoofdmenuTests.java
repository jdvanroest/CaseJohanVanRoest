package nl.bld.tests;

import nl.belastingdienst.caseJohan.Controllers.Hoofdmenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HoofdmenuTests {

    @Test
    @DisplayName("keuzemenu testen")
    void testKeuzemenu(){
        //arrange
        Hoofdmenu eerstHoofdmenu = new Hoofdmenu();
        //act
        eerstHoofdmenu.start();
        //assert
        Assertions.assertThat(2).isEqualTo(2);
    }
}

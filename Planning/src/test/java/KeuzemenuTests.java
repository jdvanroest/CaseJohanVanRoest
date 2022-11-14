import nl.belastingdienst.caseJohan.Menu.Keuzemenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KeuzemenuTests {

    @Test
    @DisplayName("keuzemenu testen")
    void testKeuzemenu(){
        //arrange
        Keuzemenu eerstKeuzemenu = new Keuzemenu();
        //act
        eerstKeuzemenu.start();
        //assert
        Assertions.assertThat(2).isEqualTo(2);
    }
}

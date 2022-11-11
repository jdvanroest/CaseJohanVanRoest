import nl.belastingdienst.caseJohan.Menu.EerstKeuzemenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KeuzemenuTests {

    @Test
    @DisplayName("keuzemenu testen")
    void testKeuzemenu(){
        //arrange
        EerstKeuzemenu eerstKeuzemenu = new EerstKeuzemenu();
        //act
        eerstKeuzemenu.start();
        //assert
        Assertions.assertThat(2).isEqualTo(2);
    }
}

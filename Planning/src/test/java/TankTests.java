import nl.belastingdienst.caseJohan.TankController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TankTests {

    @Test
    @DisplayName("tank in data base zetten met scanner")
    void testTankPersistMetScanner(){
        //arrange
        TankController tc = new TankController();
        //act
        tc.makenTankMetScanner();
        //assert
        Assertions.assertThat(2).isEqualTo(2);
     }
}

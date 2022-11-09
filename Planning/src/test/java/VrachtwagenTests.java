import nl.belastingdienst.caseJohan.Merk;
import nl.belastingdienst.caseJohan.Vrachtwagen;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class VrachtwagenTests {


    private Vrachtwagen vrachtwagen1(){
        Vrachtwagen vrachtwagen1 = new Vrachtwagen(1, Merk.SCANIA, "5-HPD-49", 13500, 134750, LocalDate.of(2011,1,2));
        return vrachtwagen1;
    }

    @Test
    @DisplayName("class vrachtwagens met attributen merk, kenteken, gewicht, kilometerstand en apkDatum")
    void testVrachtwagen(){
        //assert
        Assertions.assertThat(Vrachtwagen.class).hasDeclaredFields("merk", "kenteken","gewicht", "kilometerstand", "apkDatum");
    }

    @Test
    @DisplayName("controle getters van vrachtwagen")
    void testGetters(){
        //arrange
        vrachtwagen1();
        //act

        //assert
        Assertions.assertThat(vrachtwagen1().getApkDatum()).isEqualTo(LocalDate.of(2011,1,2));
        Assertions.assertThat(vrachtwagen1().getGewicht()).isEqualTo(13500);
        Assertions.assertThat(vrachtwagen1().getMerk()).isEqualTo(Merk.SCANIA);

     }
}

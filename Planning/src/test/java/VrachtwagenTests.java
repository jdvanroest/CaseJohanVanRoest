import nl.belastingdienst.caseJohan.Merk;
import nl.belastingdienst.caseJohan.Vrachtwagen;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class VrachtwagenTests {


    private Vrachtwagen vrachtwagen1(){
        Vrachtwagen vrachtwagen1 = new Vrachtwagen(Merk.SCANIA, "5-HPD-49", 13500, 134750, LocalDate.of(2011,1,2));
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

     @Test
     @DisplayName("testen of id elke keer 1 hoger wordt")
     void testID(){
         //arrange
         Vrachtwagen vrachtwagen1 = new Vrachtwagen(Merk.DAF, "5-LPV-50", 15000, 143758, LocalDate.of(2022,11,21));
         Vrachtwagen vrachtwagen2 = new Vrachtwagen(Merk.DAF, "5-LPV-51", 15000, 103427, LocalDate.of(2023, 1, 2));
         Vrachtwagen vrachtwagen3 = new Vrachtwagen(Merk.SCANIA, "5-LPV-52", 15000, 96045, LocalDate.of(2022, 12, 7));
         //act


         //assert
         //todo let op eerst wegschrijven naar database, anders doet @generateValue niets
         Assertions.assertThat(vrachtwagen1.getId()).isEqualTo(0);
         Assertions.assertThat(vrachtwagen2.getId()).isEqualTo(0);
         Assertions.assertThat(vrachtwagen3.getId()).isEqualTo(0);

     }
}

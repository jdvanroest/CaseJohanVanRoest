import nl.belastingdienst.caseJohan.Menu.Keuzemenu;
import nl.belastingdienst.caseJohan.Mockdata.Mockdata;

public class Main {

    public static void main(String[] args){
//        Mockdata mockdata = new Mockdata();
//        mockdata.mockdataInvoeren();
        Keuzemenu eerstKeuzemenu = new Keuzemenu();
        eerstKeuzemenu.start();
    }
}

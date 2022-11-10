package nl.belastingdienst.caseJohan;

import nl.belastingdienst.caseJohan.enums.LengteChassis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChassisFactory {
    Scanner scanner = new Scanner(System.in);

    public Chassis makenChassisMetScanner(){
        LengteChassis lengteChassis = LengteChassis.NOTDEFINEDYET;
        System.out.println("Voer het kenteken van het chassis in");
        String kenteken = scanner.nextLine();
        System.out.println("Het kenteken is " + kenteken);

        System.out.println("Voer het gewicht van het chassis in");
        int gewicht = Integer.parseInt(scanner.nextLine());
        System.out.println("Het gewicht is " + gewicht + " kg");

        System.out.println("Voer de lengte van het chassis in. 20ft of 40ft");
        String s = scanner.nextLine();
        lengteChassis = LengteChassis.valueOf(s);
        System.out.println("De lengte is " + lengteChassis);

        System.out.println("voer de apkdatum datum [dd.mm.yyyy] van het chassis in ");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate apkdatum = LocalDate.parse(str, dtf);

        return new Chassis(kenteken, gewicht, lengteChassis, apkdatum);
    }
}

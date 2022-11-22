package nl.belastingdienst.caseJohan.Controllers;

import javax.inject.Inject;
import java.util.Scanner;

public class ScannerInputValidation {
    @Inject
    Scanner scanner;


    public String scannerValidation(){
        boolean correctInput = false;
        String s = "";
        while(correctInput == false){
            try{
                s = scanner.nextLine();
                correctInput = true;
            }catch(Exception e){
                System.out.println("Verkeerde invoer");
            }
        }
        return s;
    }

    public int kilometerstandInputValidation(int min, int max){
        int i = 0;
        while(i>=min || i <= max){
            try{
                i = Integer.parseInt(scanner.nextLine());
                break;

            }catch (Exception e){
                System.out.println("Verkeerde invoer. Voer de kilometerstand van de vrachtwagen in");
            }
        }
        return i;
    }
}

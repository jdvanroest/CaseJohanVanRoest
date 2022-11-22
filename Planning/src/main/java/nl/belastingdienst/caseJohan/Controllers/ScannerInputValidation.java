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

    public int intInputValidation(int min, int max, String message){
        int i = 0;
        do{
            try{
                i = Integer.parseInt(scanner.nextLine());

            }catch (Exception e){
                System.out.println(message);
            }
        }while(i<=min || i >= max);
        return i;
    }
}

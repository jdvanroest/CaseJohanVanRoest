package nl.belastingdienst.caseJohan.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Scanner;

@ApplicationScoped
public class ConsoleScannerProducer {

    @Produces
    public Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}

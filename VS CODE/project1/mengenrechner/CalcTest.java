package mengenrechner;

public class CalcTest {

    public static int calctest(){
        int i = 0;
        while (i == 0)
            {
            //ERZEUGUNG CALC + DIREKTE AUSGABE
            Calc c1 = new Calc();
            //System.out.println(c1 + " = c1");
            do c1.eingeben();
            while (c1.anfUber()!=1);
            // array initiieren + überprüfen
            //c1.daten[0] = c1.s1;

            // HELP System.out.println("uebertragener String im array lautet:" + c1.daten[0]);
            c1.aufteilen();  // ARRAY DURCHFORSTEN UND AUFTEILEN
            c1.erstelleIntListe(); // unique Arrays als Ergebnis
            c1.calculate();
            } 
        // do{
            
        // do c1.eingeben();
        // while (c1.anfUber()!=1);
        // // array initiieren + überprüfen
        // //c1.daten[0] = c1.s1;

        // // HELP System.out.println("uebertragener String im array lautet:" + c1.daten[0]);
        // c1.aufteilen();  // ARRAY DURCHFORSTEN UND AUFTEILEN
        // c1.erstelleIntListe(); // unique Arrays als Ergebnis
        // c1.calculate();
        // } while (c1.calculate()!=600);


        return 1;
    }    
}

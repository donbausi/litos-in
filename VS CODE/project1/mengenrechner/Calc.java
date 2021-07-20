package mengenrechner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public class Calc {

    String[] daten = { "Hallo"};
    String s1;
    int countV,countH = 0;
    char ch;

    int feld1[] = new int[1111];
    int feld2[] = new int[1111];
    int feld3[] = new int[1111];

    String s1_part1;
    String s1_part2;
    String[] array_bevore_operator;
    String[] array_after_operator;
    ArrayList<String> arrayList_bevore_operator;
    ArrayList<String> arrayList_after_operator;

    
    public int eingeben(){
    // EINLESEN + AUSGABE
        System.out.println("#############################");
        System.out.println("Bitte Rechnung eingeben:");
        s1 = In.readString();

        // beenden wenn leerzeichen eingegeben        
        if (s1.length() == 0){
            System.exit(0);
            //return 600;
        }
            
        // HELP System.out.println("eingegebener String lautet:" + s1);
        daten[0] = s1;
        // HELP System.out.println("String in Daten lautet:" + daten[0]);
        

        return 1;
    }
    public int anfUber(){
        // ANFANGSÜBERPRÜFUNG OB RICHTIGE MENGEN
        // ÜBERPRÜFUNGEN ANFANGS UND ENDZEICHEN
        if (daten[0].charAt(0)!='[')
        {
            //DATENCHECK PER syso
            //System.out.println(daten[0].charAt(0) + " gggggggggggg");
            System.out.println("Erstes Zeichen kein [");
            return 400;
        }
        if (this.daten[0].charAt(daten[0].length()-1)!=']')
        {
            System.out.println("Letztes Zeichen kein ]");
            return 400;
        }

        // pürfen ob in den Klammern ein - vorhanden ist
        
        s1_part1 = s1.substring(s1.indexOf("[") + 1,s1.indexOf("]"));
        s1_part2 = s1.substring(s1.indexOf("[",s1.indexOf("[") +1) + 1,s1.indexOf("]",s1.indexOf("]")+1)); // Substring nach 2tem [ und vor 2tem ]
        

        if (s1_part1.contains("-")||s1_part2.contains("-"))
            {
                System.out.println("keine Negativen Zahlen! Bitte erneut:");
                return 400;
            }

               
        // falsche werte rausschmeißen
        s1_part1 = s1_part1.replaceAll("\\s", "");
        s1_part1 = s1_part1.replaceAll(",,", ",");
        s1_part2 = s1_part2.replaceAll("\\s", "");
        s1_part2 = s1_part2.replaceAll(",,", ",");
        

        return 1;


    }
    
    public int aufteilen(){
        // DATENARRAY DURCHFORSTEN UND AUFTEILEN

        feld2[1] = 0; // CHECKFELD OB ZU VIELE OPERATOREN

        // kompletter String in daten[0]
        // erste Menge in feld[1]
        // operator in feld[2]
        // zweite Menge in feld[3]

        //COUNT1 FÜR [, COUNT2 FÜR ] und COUNT3 für operatoren

        for(int y=0,count1=0,count2=0,count3=0;y<daten[0].length();y++)
        {

            // DATEN WERDEN NUR GESCHRIEBEN FALLS DIE RICHTIGE ANZAHL AN KLAMMERN BESTEHT!
            // HOLE ZEICHEN und schreibe es in buffer
            ch = daten[0].charAt(y);
            // COUNT 1 +2 checken, ob Fehler in Mengen
            if (ch=='[')
            {
                count1++;
            }
            if (ch==']')
            {
                count2++;
            }
            // MIT COUNT3 OPERATOREN ZÄHLEN 
            if (ch=='+'||ch=='-'||ch=='*')
            {
                count3++;
                if (count3>1) 
                {
                    System.out.println("zu viele Operatoren!");
                    return 400;
                }
            }

            // ÜBERTRAGUNG DER WERTE
            if (count1==1&&count2==0) // falls eine öffnende und keine schließende Klammer, dann erste Menge)
            {
                feld1[y] = (int)ch;
                countV++; // ZEICHEN ZÄHLEN
                // HELP System.out.println("Feld1 Zeichen " + feld1[y]);
            }
            if (count3==1) // falls ein Operator, Operator)
            {
                feld2[0] = (int)ch;
                // HELP System.out.println("Feld2 Zeichen " + feld2[y]);
            }
            if (count3>1) // falls mehr als ein Operator, AUSGABE)
            {
                System.out.println("nicht genau EIN operator! ");
                return 0;
            }
            if (count1==2&&count2==1) // falls 2 öffnende +1 schließ., dann zweite Menge)
            {
                feld3[y] = (int)ch; // ZEICHEN ÜBERTRAGEN
                countH++; // ZEICHEN ZÄHLEN
                //System.out.println("Feld3 Zeichen " + feld3[y]);
            }

            // TESTFÄLLE
            // [5,6,7]+[3+4]
            // []+[]
            // [8,8,8]*[5,5,5]
            
            // HELP System.out.println("ch = " + ch);  
        }
        return 1;
    }
    public void erstelleIntListe(){
        // IN FELD [1/2/3] stehen int werte
        ArrayList<Integer> werte1 = new ArrayList<Integer>();
        for (int i=0;i<countV;i++)
        werte1.add(feld1[i]);
        //System.out.println("\n Werte:" + werte1);

        ArrayList<Integer> werte2 = new ArrayList<Integer>();
        for (int i=0;i<countH;i++)
        werte2.add(feld3[i]);
        //System.out.println("\n Werte:" + werte2);
        
        // Werte aus Erster Klammer        
        arrayList_bevore_operator = new ArrayList<>(Arrays.asList(s1_part1.split(",")));         // einmal als ArrayList

        Set<String> temp1 = new LinkedHashSet<String>( Arrays.asList( s1_part1.split(",") ) );
        array_bevore_operator = temp1.toArray( new String[temp1.size()] );                 // einmal als unique Array
       
        // Werte aus Zweiter Klammer        
        arrayList_after_operator = new ArrayList<>(Arrays.asList(s1_part2.split(",")));          // einmal als ArrayList

        Set<String> temp2 = new LinkedHashSet<String>( Arrays.asList( s1_part2.split(",") ) );      // einmal als unique Array
        array_after_operator = temp2.toArray( new String[temp2.size()] );
       

        
        // System.out.println("----- erstes");
        // System.out.println(Arrays.toString(array_bevore_operator));
        // System.out.println(array_bevore_operator.length==1);
        // System.out.println(array_bevore_operator[0]==null);
        // System.out.println(array_bevore_operator[0]=="");

        // System.out.println("----- zweites");        
        // System.out.println(Arrays.toString(array_after_operator));
        // System.out.println(array_after_operator[0]);
        // System.out.println(array_after_operator.length==1);
        // System.out.println(array_after_operator[0]==null);
        // System.out.println(array_after_operator[0]=="");
        
        
    }

    public int calculate(){
        System.out.println("Ergebniss:");
        String operator = s1.substring(s1.indexOf("]") + 1,        s1.indexOf(      "[",   s1.indexOf("[") + 1));                       // Substring nach erstem [ und vor erstem ]

        switch(operator) {
            case "+": // vereinigung
                System.out.println("vereinigung");

                if(array_bevore_operator.length==1 && array_bevore_operator[0]==null){
                    System.out.println(Arrays.toString(array_after_operator));
                } 
                else if(array_after_operator.length==1 && array_after_operator[0]==null){
                    System.out.println(Arrays.toString(array_bevore_operator));

                }
                else {
                    List list = new ArrayList(Arrays.asList(array_bevore_operator)); // List aus ersterm Array erstellen ändern
                    list.addAll(Arrays.asList(array_after_operator));                // 2tes Array hinzufügen
                
                    //Object[] c = list.toArray();                                   // Liste wieder zu Array, erstmal nicht notwendig

                    // Liste Unique machen und ausgeben                                
                    Set<String> liste_1 = new HashSet<>(list);
                    List<String> liste_2 = new ArrayList<>(liste_1);

                    System.out.println(liste_2);
                }   
                
                break;
            case "-": // differenz
                System.out.println("differenz");
                
                ArrayList<String> result_list = new ArrayList<String>();

                // doppelte for schleife zum vergleich der 2 Arrays
                for (int i=0;i<array_bevore_operator.length;i++){
                    boolean isIn = false;

                    for (int j=0;j<array_after_operator.length;j++){
                        
                        if (array_bevore_operator[i].equals(array_after_operator[j])) {
                            isIn = true;
                            break;
                        }
                        
                    }
                    if (isIn==false)
                    result_list.add(array_bevore_operator[i]);

                }
                
                System.out.println(result_list);

                break;

            case "*": // durchschnitt
                System.out.println("durchschnitt");
                
                ArrayList<String> result_list_2 = new ArrayList<String>();

                // doppelte for schleife zum vergleich der 2 Arrays
                for (int i=0;i<array_bevore_operator.length;i++){
                    boolean isIn = false;

                    for (int j=0;j<array_after_operator.length;j++){                        
                        if (array_bevore_operator[i].equals(array_after_operator[j])) {
                            isIn = true;
                            break;
                        }                        
                    }
                    if (isIn==true)
                    result_list_2.add(array_bevore_operator[i]);

                }
                
                System.out.println(result_list_2);

                break;
        }
    return 1;    
        
    }
}

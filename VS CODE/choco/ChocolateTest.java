package choco;

public class ChocolateTest{

    public static void chocotest(){

        int n,m,anzSpi = 0;

    Chocolate choco = new Chocolate();
    //choco.createBoard();

    System.out.println(choco + " ---------------------###################---------------");

    // INPUTS FUER SCHOKOLADENGROESSE UND SPIELER
    System.out.println("Bitte Zeilen/Hoehe eingeben:");
    n = In.readInt();
    System.out.println("Bitte Spalten/Breite eingeben:");
    m = In.readInt();

    System.out.println("Bitte Anzahl der Spieler eingeben:");
    anzSpi = In.readInt();

    // ERSTELLUNG BOARD
    choco.createNewBoard(n,m);

    //ERSTELLUNG SESSION EINZELSPIELER
    if (anzSpi == 1)
    {
        while (choco.spielenESP()==0)
        choco.spielen();

    }
    //ERSTELLUNG SESSION MEHRSPIELER
    while (choco.spielen()==0)
    choco.spielen();
    }
}
package choco;

public class Chocolate {

    private int height;
    private int width;
    private boolean win = false;

    //SPIELVARIABLEN
    private int count = 1 % 2;
    private char c = '0';
    private int anzStu = 0;
    
    public Chocolate(int height,int width) {
        setHeight(height);
        setWidth(width);
    }

    public Chocolate() {
        setHeight(3);
        setWidth(3);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean getWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    
    public void createBoard() {
        System.out.print("*");
        for(int i = 0; i < this.width -1 ; i ++) {
            System.out.print("O");
        }
        for(int i = 0; i < this.height - 1; i++) {
            System.out.println("");
            for(int j = 0; j < this.width; j++) {
                System.out.print("O");
            }
        }
    }
    
    public void createNewBoard(int height, int width) {
        System.out.print("*");
        this.setHeight(height);
        this.setWidth(width);

        for(int i = 0; i < width -1 ; i ++) {
            System.out.print("O");
        }
        for(int i = 0; i < height - 1; i++) {
            System.out.println("");
            for(int j = 0; j < width; j++) {
                System.out.print("O");
            }
        }
    }
    
    public void sliceHorizontal(int row) {
        this.createNewBoard(this.height - row, this.width);
        if (this.height < 1) 
        {
           this.height = 1;
         System.out.println("height < 1");
        }
    }
    
    public void sliceVertical(int row) {
        this.createNewBoard(this.height, this.width - row);
        if (this.width < 1)
        {
            this.width = 1;
        }
    }
    
    public boolean checkWin() {
        if(this.width == 1 && this.height == 1) {
            return true;
        }else {
            return false;
        }
    }

    public int spielen(){

        //ABFRAGE DER INPUTS
        //System.out.println(this.getHeight() + " " + this.getWidth());
        System.out.println("\nSpieler " + count + " wo lang schneiden?");
        c = In.readChar();

        if (c=='h'||c=='H') {
            System.out.println("\nSpieler " + count + " wie viele Stücken? zwischen 0 und " + (this.getHeight()));
            anzStu = In.readInt(); 
            //System.out.println("\n anzStu = "+anzStu + "getHeight(): " +this.getHeight());
            
            if (anzStu > this.getHeight())
            {
                System.out.println("\nZu gross! ich passe auf die Hoehe an...");
                anzStu = this.getHeight()-1;
            }
            
            
        }
    
        if (c=='v'||c=='V') {
            System.out.println("\nSpieler " + count + " wie viele Stücken? zwischen 0 und " + (this.getWidth()));
            anzStu = In.readInt(); 
            //System.out.println("\n anzStu = "+anzStu + "getWidth(): " +this.getWidth());

            if (anzStu > this.getWidth());
            {
                System.out.println("\nZu gross! ich passe auf die Weite an...");
                anzStu = this.getWidth()-1;
            }
            
        }

        //EIGENTLICHES ABSCHLITZEN -- nur per h und v, sonst recall
        if (c=='H'||c=='h') {
            this.sliceHorizontal(anzStu);
        }
        
        if (c=='V'||c=='v') {
            this.sliceVertical(anzStu);
        } else {
          //  System.out.println("\n\nFalsche Eingabe\n\n"); //----BUGGT AUCH NOCH
        }
    
        if(this.checkWin())
        {
            System.out.println("Spieler " + count + " hat gewonnen");
            return 1;
    
        } else {
            System.out.println("\nweiterspielen...");
        }
    
        count++;
        count = (count % 2);

        return 0;
    }

    public int spielenESP(){

        //ABFRAGE DER INPUTS
        //System.out.println(this.getHeight() + " " + this.getWidth());
        System.out.println("\neinzelner Spieler " + count + " wo lang schneiden?");
        c = In.readChar();

        if (c=='h'||c=='H') {
            System.out.println("\nSpieler " + count + " wie viele Stücken? zwischen 0 und " + (this.getHeight()));
            anzStu = In.readInt(); 
            //System.out.println("\n anzStu = "+anzStu + "getHeight(): " +this.getHeight());
            
            if (anzStu > this.getHeight())
            {
                System.out.println("\nZu gross! ich passe auf die Hoehe an...");
                anzStu = this.getHeight()-1;
            }
            
            
        }
    
        //ABFRAGE nach welchem Input getrennt werdensoll
        if (c=='v'||c=='V') {
            System.out.println("\nSpieler " + count + " wie viele Stücken? zwischen 0 und " + (this.getWidth()));
            anzStu = In.readInt(); 
            //System.out.println("\n anzStu = "+anzStu + "getWidth(): " +this.getWidth());

            // FALLS ZU GROSS, dANN ANPASsEN
            if (anzStu > this.getWidth());
            {
                System.out.println("\nZu gross! ich passe auf die Weite an...");
                anzStu = this.getWidth()-1;
            }
            
        }

        //EIGENTLICHES ABSCHLITZEN -- nur per h und v, sonst recall
        if (c=='H'||c=='h') {
            this.sliceHorizontal(anzStu);
        }
        
        if (c=='V'||c=='v') {
            this.sliceVertical(anzStu);
        } else {
          //  System.out.println("\n\nFalsche Eingabe\n\n"); //----BUGGT AUCH NOCH
        }
    
        if(this.checkWin())
        {
            System.out.println("Spieler " + count + " hat gewonnen");
            return 1;
    
        } else {
            System.out.println("\n Der Gegner ist am Zug!");
        }

        // EINFÜHREN DER ESP SEQUENZ damit einfacher LOOP bleibt

        //einfaches Halbieren -> sorgt für 2x2

        count++;
        count = (count % 2);

        //if (this.getHeight()>1) {
            this.sliceHorizontal(this.getHeight()/2);
        //}
        if (this.getWidth()>1){
            this.sliceVertical(this.getWidth()/2);
        } else {

        }
        //DOPPELTES CHECKEN
        if(this.checkWin())
        {
            System.out.println("Spieler " + count + " hat gewonnen");
            return 1;
    
        } else {
            System.out.println("\nweiterspielen...");
        }

        //WEITERZÄHLEN
        count++;
        count = (count % 2);

        return 0;
    }
}
package mengenrechner;

public class Maintest {
    
    public static void main(String [] args){

        try{
            CalcTest.calctest();   
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        
    }
}

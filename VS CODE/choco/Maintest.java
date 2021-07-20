package choco;

public class Maintest {
    
    public static void main(String [] args){

        try{
            ChocolateTest.chocotest();   
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        
    }
}

package op03Exercises;

public class AccountExample1 {
    public static void main(String[] args) {
        Account1 acc = null;
        //Account1 acc2 = new Account1(123, 500);// diese Option muss in einer Try catch anweisung
        //acc2.info();

        try { //hier wird eine exception geprüft
            acc = new Account1(1234567, 777);//Aufruf aus dem Konstr. damit es geprüft wird
            acc.einzahl(2);
            acc.auszahl(800);
            //acc.setBalance(-2);
            //acc.info();
        }
        catch (AccountException1 e){
            //System.out.println(e); //op03Exercises.AccountException1: setBalance < 0
            System.out.println(e.getMessage()); //setBalance < 0
            e.printStackTrace();// diese Methode sagt einem wo im QuellCode die Exception ist
        }
        catch (ArithmeticException e2){
            e2.printStackTrace();
        }

        //acc.info(); // die Ausgabe muss in einer if Anweisung geprüft werden, sosnt direkt eine Exception
        if(acc != null){
            acc.info();
        }
    }

}

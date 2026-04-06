package op03Exercises;

public class Account1 {
    private int accNumber;
    private double balance;

    //konst
    public Account1() {
    }

    public Account1 (int number){
        this.accNumber = number;
    }

    public Account1 (int num, double bal) throws AccountException1 {
        if(bal < 0) throw new AccountException1("neg. Balance");
        this.accNumber = num;
        this.balance = bal;
    }

    //getter setter
    public int getAccNumber(){
        return accNumber;
    }
    public void setAccNumber(int num){
        accNumber = num;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double bal) throws AccountException1{
        if(bal < 0) throw new AccountException1("setBalance < 0");
        this.balance = bal;
    }
    
    //methods
    public void einzahl(double auszahlBetrag) throws AccountException1{
        if (auszahlBetrag < 0) throw new AccountException1("einzahlBetrag < 0");
        
        balance += auszahlBetrag;
    }

    public void auszahl(double auszahlBetrag) throws AccountException1{
        if(auszahlBetrag < 0) throw new AccountException1("auszahlBetrag < 0");
        if (balance < auszahlBetrag) throw new AccountException1("überziehung");
        balance -= auszahlBetrag;
    }

    public void info(){
        System.out.println("accNumber: " + accNumber + " \nBalance: " + balance);
    }




}

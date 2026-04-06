package op02.constructors;

public class AccountExampleJuego {
    //attribute
    //private int numeroCuenta;
    private static int numeroCuenta = 1000;
    private double balanceCuenta;
    private double monto;
    
    //Statische Methode zur inkremmentieren
    private static int nextNumeroCuenta (){
        numeroCuenta++;
        return numeroCuenta;
    }

    //getters and Setters
    public static int getNumeroCuenta() {
        return numeroCuenta;
    }
    //public int getNumeroCuenta() {
    //    return numeroCuenta;
    //}

    public static void setNumeroCuenta(int numeroCuenta) {
        AccountExampleJuego.numeroCuenta = numeroCuenta;
    }
    //public void setNumeroCuenta(int numeroCuenta) {
    //    this.numeroCuenta = numeroCuenta;
    //}

    public double getBalanceCuenta() {
        return balanceCuenta;
    }

    public void setBalanceCuenta(double balanceCuenta) {
        this.balanceCuenta = balanceCuenta;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    //constructor
    public AccountExampleJuego(){ 
        //numeroCuenta = nextNumeroCuenta();
        //this.numeroCuenta = numeroCuenta;
        //this.balanceCuenta = balanceCuenta;
    }
    public AccountExampleJuego(int numeroCuenta){ 
        numeroCuenta = nextNumeroCuenta();
        //this.numeroCuenta = numeroCuenta;
        //this.balanceCuenta = balanceCuenta;
    }
    public AccountExampleJuego(int numeroCuenta, double balanceCuenta){ 
        numeroCuenta = nextNumeroCuenta();
        //this.numeroCuenta = numeroCuenta;
        this.balanceCuenta = balanceCuenta;
    }

    //Methoden
    public void meterDinero(double monto){
        balanceCuenta = balanceCuenta + monto;
    }
   
    public void sacarDinero(double monto){
        balanceCuenta = balanceCuenta - monto;
    }

    //information about this Acc 
    public void info(){
        System.out.println("numero de cuenta: " + numeroCuenta + " und balance de cuenta: " + balanceCuenta);
    }

    //main de la cuenta
    public static void main (String[] args){
        System.out.println("*************************");
        System.out.println("nueva cuenta creada: ");
        
        //cuenta1 von AccountExample2 nur mit numeroCuenta und calanceCuenta
        //AccountExample2 cuenta1 = new AccountExample2(1234567, 10000);
        System.out.println("informacion de cuenta1 sin limitecuenta!!! ");
        AccountExampleJuego cuenta1 = new AccountExampleJuego();
        cuenta1.info();
        System.out.println("meter dinero: ");
        //System.out.println(cuenta1.meterDinero(500)); das geht nicht!!!
        cuenta1.meterDinero(80500.00);
        System.out.println(cuenta1.getBalanceCuenta());
        cuenta1.sacarDinero(80000.00);
        //System.out.println("nuemero de cuenta1: " + AccountExample2.getNumeroCuenta());
        System.out.println("balance de cuenta1: " + cuenta1.getBalanceCuenta());
        //System.out.println(cuenta1.getBalanceCuenta());

        //using attribut limitecuenta
        //AccountExample2 cuenta2 = new AccountExample2(9876543, 777, )
        System.out.println("");
        System.out.println("informacion de cuenta2: ");
        //CuentaNueva cuenta2 = new CuentaNueva();
        AccountExampleJuego cuenta2 = new AccountExampleJuego();
        //System.out.println("numero de cuenta: " + nextNumeroCuenta.getNumeroCuenta());
        AccountExampleJuego.getNumeroCuenta();
        cuenta2.meterDinero(800);
        cuenta2.sacarDinero(100);
        //System.out.println("Cuentalimite: " + cuenta2.getLimiteCuenta());
        System.out.println("balance de la Cuenta: " + cuenta2.getBalanceCuenta());
        
        //cuenta3
        System.out.println("");
        System.out.println("informacion de cuenta3 : ");
        CuentaNueva cuenta3 = new CuentaNueva(1177711, 77777, 100000);
        cuenta3.meterDinero(1); 
        cuenta3.sacarDinero(2);
        //System.out.println("numero de cuenta: " + cuenta3.getNumeroCuenta());
        System.out.println("balance de cuenta3: " + cuenta3.getBalanceCuenta());
    }



}

/*
 * STRUKTUR???
 * attribute
 * constructor
 * getter und setter
 * methoden
 * info()
 * main 
 * 
 *  STRUKTUR EXTENDS???
 * additional attribute
 * constructor mit super(attribute vom oberklasse) + constructor von additional attribute 
 * getter und setter von additional attribute
 * 
 * 
 */
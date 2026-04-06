package op02.constructors;

public class CuentaNueva extends AccountExampleJuego{
    //Atributte
    private double limiteCuenta;
    
    //constructor
    
    public CuentaNueva (int numeroCuenta, double balanceCuenta, double limiteCuenta) {
        super(numeroCuenta, balanceCuenta);
        this.limiteCuenta = limiteCuenta;
    }
    
    public CuentaNueva(double limiteCuenta) {
        this.limiteCuenta = limiteCuenta;
    }

    public CuentaNueva(int numeroCuenta, double limiteCuenta) {
        super(numeroCuenta);
        this.limiteCuenta = limiteCuenta;
    }
    public CuentaNueva() {
    }

    //Getter and setters
    public double getLimiteCuenta() {
        return limiteCuenta;
    }
    //only Setter and not necesary Getter for the limitCuenta
       public void setLimiteCuenta(double limiteCuenta) {
        if(limiteCuenta > 0.0) 
        {
            this.limiteCuenta = limiteCuenta;
        }
        else
        {
            this.limiteCuenta = 0.0;
        }
    }
    
    //methoden
    @Override
    public void sacarDinero(double monto) {
        double balanceCuenta = getBalanceCuenta();
        if (balanceCuenta - monto >= -limiteCuenta){
            balanceCuenta -= monto;
            setBalanceCuenta(balanceCuenta);
        }
    }
    @Override
    public void info() {
        super.info();

    }
    
}

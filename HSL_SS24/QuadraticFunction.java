package HSL_SS24;

public class QuadraticFunction extends Function{ // Anforderung 5
    //Attrib
    private double[] a = new double[3]; //Anforderung 6
    
    // Anforderung 7: Konstruktor
    public QuadraticFunction(double a2, double a1, double a0){
        this.a[2] = a2;
        this.a[1] = a1;
        this.a[0] = a0;
    }

    //Anforderung 8 
    public double getCoefficient(int index){
        return a[index];
    }

    //Anforderung 9 funktion
    @Override //@Override, da von der anderen FKT aufgerufen wird?
    public double f(double x){
        return a[2]*Math.pow(x,2) + a[1]*x + a[0];
    }

    //Anforderung 10 Ableitung df
    @Override
    public double df(double x){
        return 2*a[2]*x + a[1]; 
    }

    //  FORMELSAMMLUNG!!!
    //Anforderung 11  Addition eines weiteren Polynoms
    public void add(QuadraticFunction f){
        this.a[0] = this.a[0] + f.getCoefficient(0);
        this.a[1] = this.a[1] + f.getCoefficient(1);
        this.a[2] += f.getCoefficient(2);
    }

    //Anforderung 12
    public void multiply(double k){
        this.a[0] = this.a[0] * k;
        this.a[1] = this.a[1] * k;
        this.a[2] *= k;
    }

    //Anforderung 13
    public double[] ZeroCrossing(){
        //variablen in anderen Temp-Var speichern
        double a2 = a[2];   
        double a1 = a[1];
        double a0 = a[0];

        //discriminat berechnen
        double discriminant = Math.pow((a1 / 2*a2), 2) - a0 / a2;
        //falls discriminan < 0 ...
        if(discriminant < 0){
            System.out.println("keine reellen NST");
            return null;
        }
        //part1 
        double part1 = -a1 / (2*a2);
        double part2 = Math.sqrt(discriminant);

        return new double[] {part1 - part2, part1 + part2};
    }

}

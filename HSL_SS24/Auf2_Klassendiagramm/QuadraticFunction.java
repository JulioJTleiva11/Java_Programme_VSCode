package HSL_SS24.Auf2_Klassendiagramm;

public class QuadraticFunction extends Function{
    //Attr
    private double [] a = new double [3]; //Anf 6

    //constr  Anf 7
    public QuadraticFunction (double a2, double a1, double a0){
        this.a[2] = a2;
        this.a[1] = a1;
        this.a[0] = a0;
    }

    public double getCoefficient(int index){
        return a[index];    // Anf 8
    }

    @Override   //Anf 9
    public double f(double x) {
        return a[2]*x*x + a[1]*x + a[0];

    }
    
    @Override  //Anf 10
    public double df(double x) {
        return 2*a[2]*x + a[1];
    }

    public void add(QuadraticFunction f){  //Anf 11
        this.a[0] = a[0] + f.getCoefficient(0);
        this.a[1] = a[1] + f.getCoefficient(1);
        this.a[2] = a[2] + f.getCoefficient(2);
    }

    public void multiply(double k){  //Anf  12
        this.a[0] = a[0]*k;
        this.a[1] = a[1]*k;
        this.a[2] = a[2]*k;
    }

    public double [] ZeroCrossings(){  //Anf 13
        double x_n1 = -a[1]/2*a[2] - Math.sqrt((a[1]*a[1]/4*a[2]*a[2]) - a[0]/a[2]);
        double x_n2 = -a[1]/2*a[2] + Math.sqrt((a[1]*a[1]/4*a[2]*a[2]) - a[0]/a[2]);
        
        if(((a[1]*a[1]/4*a[2]*a[2]) - a[0]/a[2]) < 0) {
            System.out.println("keine reellen NST");
            return null;
        }
                
        double [] wurzeln = new double[2];
        wurzeln [0]= x_n1;
        wurzeln [1] = x_n2;
        return wurzeln;  
    }

}

package HSL_SS24.Auf2_Klassendiagramm;

public abstract class Function implements Differentiable{
    
    public abstract double f(double x);

    public double zeroCrossings(double xStart, double epsilon, int maxInterations){
        double x = xStart;
        for(int i = 0; i <= maxInterations; i++){
            double fx = f(x);
            if(Math.abs(fx) <= epsilon){
                return x;
            }
            x = x - (fx / df(x));
        }
        return x;
    }

        
}

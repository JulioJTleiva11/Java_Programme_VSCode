package HSL_SS24;


//Basisklasse Function
public abstract class Function implements Differentiable{
    public abstract double f(double x); //Anforderung 3: abstrac. Meth. für den Fktwert f(x)

    //Anforderung 4: Newtonverfahren zur Nullstellenannäherung !!!!!!!!!!!!!
    public double ZeroCrossing (double xStart, double epsilon, int maxiIterations){
        double xn = xStart;

        for (int i = 0; i < maxiIterations; i++){
            //AbbruchBed: Betrag des Fkt-wertes ist klein genug
            if (Math.abs(f(xn)) <= epsilon){
                break;
            } 

            //Newton-Schritt: x_n+1 = x_n - f(x_n) / f'(x_n)
            xn = xn - (f(xn) / df(xn));
        }

        return xn; //Rückgabe des letzten x-Wertes x_n+1
        
    }
    

}

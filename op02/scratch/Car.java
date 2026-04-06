package op02.scratch;

public class Car {

	// Complex numbers consists of two 
	// real values ("re" and "im")

	private double re;
	private double im;

	// Getter and Setter

	public double getRe() {
		return re;
	}

	public void setRe(double re) {
		this.re = re;
	}

	public double getIm() {
		return im;
	}

	public void setIm(double im) {
		this.im = im;
	}
	
	// Do the work HERE
	public void doStrangeOperation() {
		// first step: store imaginary part of "this" in local var
		double tmp = this.getIm();// [ 1 line of code ]
		// second step: set real part to (value*7)
		setRe(tmp*7);// [ 1 line of code ]
		
	}
	
	// The program starts here
	public static void main(String[] args) {

		// create a complex number first
		Car c = new Car();
		c.setRe(2.0);
		c.setIm(1.0);

		// print this number
		System.out.println("We have a complex number with re=" +c.getRe()+" and im="+c.getIm()); //  re=2 & im=1
		c.doStrangeOperation();
		System.out.println("We have a complex number with re=" +c.getRe()+" and im="+c.getIm());//re=im*7 & im=1
	}
}


package op02.scratch;

public class car2 {
    //attribute
    private String color;
    private int wheels;
    private double horsePower;

    // getter and setter
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getWheels() {
        return wheels;
    }
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
    public double getHorsePower() {
        return horsePower;
    }
    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }
     //konstruktor
    public car2(String color, int wheels, double horsePower) {
        this.color = color;
        this.wheels = wheels;
        this.horsePower = horsePower;
    }
    
}

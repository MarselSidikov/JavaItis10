package aopalliance;

public class Human {
    private double height;
    private double weight;
    private String name;

    public Human(double height, String name, double weight) {
        this.height = height;
        this.name = name;
        this.weight = weight;
    }

    public void grow(double height) {
        this.height += height;
    }

    public void sayName() {
        System.out.println(name);
    }

    public String toString() {
        return this.name + " " + this.height;
    }

    public double getIndex() {
        if (Double.compare(this.height, 0.0) == 0) {
            throw new IllegalArgumentException("Неверный рост");
        }
        return  this.weight / (this.height * this.height);
    }


}

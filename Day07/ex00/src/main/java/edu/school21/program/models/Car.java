package edu.school21.program.models;

import edu.school21.program.PrivateClass;

public class Car implements PrivateClass {
    private String brand;
    private String color;
    private Integer speed;

    public Car(){}

    public Car(String brand, String color, Integer speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }

    @Override
    public int increment(int i) {
        speed += i;
        return speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }


}

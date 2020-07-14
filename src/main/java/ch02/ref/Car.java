package com.test1.ch02.ref;

public class Car {

    private String label;
    private Double price;

    public Car() {
        System.out.println("Car()");
    }

    public Car(String label, Double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "label='" + label + '\'' +
                ", price=" + price +
                '}';
    }
}

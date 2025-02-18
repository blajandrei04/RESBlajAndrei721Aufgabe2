package model;

import java.io.Serializable;

public class Produkt implements Comparable{
    String name;
    int price;
    String universum;
    public Produkt(String name, int price, String universum) {
        this.name = name;
        this.price = price;
        this.universum = universum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUniversum() {
        return universum;
    }

    public void setUniversum(String universum) {
        this.universum = universum;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", universum='" + universum + '\'' +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        return this.getPrice() - ((Produkt) o).getPrice();
    }
}


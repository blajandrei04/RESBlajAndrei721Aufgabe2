package model;

import java.util.List;

public class Charaktere {
    int id;
    String name;
    String region;
    List<Produkt> produktList;
    public Charaktere(int id, String name, String region, List<Produkt> produktList) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.produktList = produktList;
    }
    public Charaktere(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Produkt> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<Produkt> produktList) {
        this.produktList = produktList;
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", produktList=" + produktList +
                '}';
    }
    public boolean richtigeUniversum(String universum){
        for (Produkt p : this.produktList) {
            if (p.getUniversum().equals(universum)) {
                return true;
            }
        }
        return false;
    }
}

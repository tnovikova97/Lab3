package Beans;

public class Rings {

    private int id;
    private String name;
    private String brand;
    private String metal;
    private String vstavka;
    private int proba;
    private float size;
    private int price;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getVstavka() {
        return vstavka;
    }

    public void setVstavka(String vstavka) {
        this.vstavka = vstavka;
    }

    public int getProba() {
        return proba;
    }

    public void setProba(int proba) {
        this.proba = proba;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ring [id = " + id + ", name = " + name + ", brand = "
                + brand + ", metal = " + metal + ", vstavka = " + vstavka
                + ", proba = " + proba + ", size = " + size + ", price = "
                + price + "]";
    }
}

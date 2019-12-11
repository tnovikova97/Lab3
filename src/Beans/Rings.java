package Beans;

public class Rings {

    private int id;
    private String title;
    private String brand;
    private String metal;
    private String vstavka;
    private int proba;
    private float size;
    private int prise;

    public Rings() {}

    public Rings (String title, String brand, String metal, String vstavka, int proba, float size, int prise) {
        super();
        this.title = title;
        this.brand = brand;
        this.metal = metal;
        this.vstavka = vstavka;
        this.proba = proba;
        this.size = size;
        this.prise = prise;
    }

    public Rings(int id, String title, String brand, String metal, String vstavka, int proba, float size, int prise) {
        super();
        this.id = id;
        this.title = title;
        this.brand = brand;
        this.metal = metal;
        this.vstavka = vstavka;
        this.proba = proba;
        this.size = size;
        this.prise = prise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
//        if (prise >= 0) {
//            this.prise = prise;
//        } else {
//            System.out.println("Ошибка! Цена не может быть отрицательным числом!");
//        }
    }

    @Override
    public String toString() {
        return "Ring [id = " + id + ", title = " + title + ", brand = "
                + brand + ", metal = " + metal + ", vstavka = " + vstavka
                + ", proba = " + proba + ", size = " + size + ", price = "
                + prise + "]";
    }
}

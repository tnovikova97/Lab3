package Beans;

public class WatchsBean {
    private int id;
    private String title;
    private String type;
    private String gender;
    private int price;

    public WatchsBean() {
    }

    public WatchsBean(int id) {
        this.id = id;
    }

    public WatchsBean(int id, String title, String type, String gender, int price) {
        this(title, type, gender, price);
        this.id = id;
    }

    public WatchsBean(String title, String type, String gender, int price) {
        this.title = title;
        this.type = type;
        this.gender = gender;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

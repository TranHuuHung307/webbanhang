
package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private String img;
    private int category_id;
    private String description;
    private int status;
    private String detail;

    public Product(int id, String name, float price, String img, int category_id, String description, int status, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.category_id = category_id;
        this.description = description;
        this.status = status;
        this.detail = detail;
    }

    public Product(String name, float price, String img, int category_id, String description, int status, String detail) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.category_id = category_id;
        this.description = description;
        this.status = status;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    

    public Product(String name, float price, String img, int category_id, String description, int status) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.category_id = category_id;
        this.description = description;
        this.status = status;
    }

    public Product(int id, String name, float price, String img, int category_id, String description, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.category_id = category_id;
        this.description = description;
        this.status = status;
    }

    public Product() {
    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
}

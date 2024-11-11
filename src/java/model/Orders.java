
package model;

public class Orders {
    private int id;
    private int account_id;
    private int product_id;
    private float price;
    private String created_at;
    private int status;

    public Orders() {
    }

    public Orders(int id, int account_id, int product_id, float price, String created_at, int status) {
        this.id = id;
        this.account_id = account_id;
        this.product_id = product_id;
        this.price = price;
        this.created_at = created_at;
        this.status = status;
    }

    public Orders(int account_id, int product_id, float price, String created_at, int status) {
        this.account_id = account_id;
        this.product_id = product_id;
        this.price = price;
        this.created_at = created_at;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}

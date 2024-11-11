package model;

public class OrderandProductandAccount {
    private int id;
    private String fullName;
    private String nameProduct;
    private String img;
    private float prive;
    private String phone;
    private String email;
    private int status;

    public OrderandProductandAccount() {
    }

    public OrderandProductandAccount(int id, String fullName, String nameProduct, String img, float prive, String phone, String email, int status) {
        this.id = id;
        this.fullName = fullName;
        this.nameProduct = nameProduct;
        this.img = img;
        this.prive = prive;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getPrive() {
        return prive;
    }

    public void setPrive(float prive) {
        this.prive = prive;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
}

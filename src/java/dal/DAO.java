/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.OrderandProductandAccount;
import java.util.ArrayList;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Account;
import model.Categories;
import model.Detailed;
import model.Orders;
import model.OrderandProductandAccount;

/**
 *
 * @author Administrator
 */
public class DAO extends DBContext {
    public int getTotalProductCount() {
        int count = 0;
        try (
                 PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM products");  ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public List<Product> getProductsToManage(int page, int pageSize) {
        List<Product> products = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        try (
                 PreparedStatement stmt = connection.prepareStatement("SELECT p.id, p.name, p.price, p.image, c.name AS category, p.description, p.status\n"
                        + "FROM products p\n"
                        + "JOIN categories c ON p.category_id = c.id\n"
                        + "ORDER BY p.id\n"
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;")) {
            stmt.setInt(1, offset);
            stmt.setInt(2, pageSize);
            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getFloat("price"));
                    product.setName(rs.getString("category"));
                    product.setImg(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStatus(rs.getInt("status"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select *from products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertAccount(String username, String password, String fullname, String email, String phone, String address, int status, int role) {
        try {
            String sql = "insert into accounts(username,password,fullname,email,phone,address,Status,role)\n"
                    + "  values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, address);
            ps.setInt(7, status);
            ps.setInt(8, role);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println("loi o insertAccount");
        }
    }

    public Account getAccount(String username, String password) {
        try {
            String sql = "select *from accounts where username=? and password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
            System.out.println("Loi o check Account");
        }
        return null;
    }

    public ArrayList<Account> getAllAcount() {
        ArrayList<Account> list = new ArrayList<>();
        try {
            String sql = "select *from accounts";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
            System.out.println("Loi o getAllAcount");
        }
        return list;
    }

    public ArrayList<Categories> getAllCategories() {
        ArrayList<Categories> list = new ArrayList<>();
        try {
            String sql = "select *from categories";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Categories(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getAllProductByCateboryId(int CategoryID) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select *from products where category_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, CategoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Categories getCatrgoriesByCategoriesID(int CategoryID) {
        try {
            String sql = "select *from categories where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, CategoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Categories(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Loi o getCatrgoriesByCategoriesID");
        }
        return null;

    }

    public ArrayList<Product> getAllProductArrange(String a) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Thêm khoảng trắng giữa * và from
            String sql = "select * from products ";
            // Thêm cách sắp xếp vào câu lệnh SQL, sử dụng ASC hoặc DESC trực tiếp
            sql += "order by price " + a;

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println("Loi o xap xep");
            e.printStackTrace(); // In ra lỗi để debug
        }
        return list;
    }

    public ArrayList<Product> getTop5Product() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT top(5) *from products\n"
                    + "order by id desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> search(String name) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select * from products where name like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductById(int product_id) {
        try {
            String sql = "  select *from products where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, product_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account getAccountById(int id) {
        try {
            String sql = "select *from accounts where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void insertOrder(int account_id,int product_id,float price,String time,int status){
        try {
            String sql="insert into orders(account_id,product_id,price,created_at,status)\n" +
"values(?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            ps.setInt(2,product_id);
            ps.setFloat(3, price);
            ps.setString(4,time);
            ps.setInt(5, status);
            ps.execute();
            ps.close();
        } catch (Exception e) {
        }
    }
    public ArrayList<Categories> getAll(){
        ArrayList<Categories> list=new ArrayList<>();
        try {
            String sql="select *from categories";
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Categories(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void deleteProduct(int productId) {
    try {
        String sql = "DELETE FROM products WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, productId);
        ps.executeUpdate(); // Sử dụng executeUpdate() để đảm bảo thực hiện lệnh DELETE
        ps.close();
    } catch (Exception e) {
        e.printStackTrace(); // In ngoại lệ ra để dễ debug nếu có lỗi
    }
}

    public void deleteAccount(int accountId) {
        try {
            String sql="delete from accounts where id=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("loi o delteAccount");
        }
}   
    public ArrayList<Orders> getAllOrder(){
        ArrayList<Orders> list=new ArrayList<>();
        try {
            String sql="  select *from orders\n" +
"  order by id desc";
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int getTotalProduct(){
        try {
            String sql="select count(*) from products";
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public ArrayList<OrderandProductandAccount> getOPA(){
        ArrayList<OrderandProductandAccount> list=new ArrayList<>();
        try {
            String sql=" select o.id,a.fullname,p.name,p.image,p.price,a.phone,a.email,o.status from orders as o\n" +
"  join accounts as a on a.id=o.account_id\n" +
"  join products as p on o.product_id=p.id\n" +
"  order by id desc";
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new OrderandProductandAccount(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));

            }
        } catch (Exception e) {
            System.out.println("Loi o OrderandProductandAccount");
        }
        return list;
    }
    public void updateOrder(int id){
        try {
            String sql="update orders set status=1\n" +
"  where id=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Loi o ham update");
        }
    }
    public void updateAccount(String username,String password,String fullname,String email,String phone,String address,int id){
            try {
                String sql="update accounts set username=?,password=?,fullname=?,phone=?,address=?,Status=1,role=0\n" +
"  where id=?";
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, fullname);
                ps.setString(4, phone);
                ps.setString(5, address);
                ps.setInt(6, id);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("Loi o update account");
            }
    }
    public ArrayList<Product> getProductTotal(int index){
        ArrayList<Product> list=new ArrayList();
        try {
            String sql="  select *from products\n" +
"  order by id\n" +
"  offset ? row fetch next 7 row only";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, (index-1)*5);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public model.Detailed getAllDetailed(int id){
        ArrayList<model.Detailed> list=new ArrayList();
        try {
            String sql="select d.detailed from products as p \n" +
"  inner join describe as d on p.describeid=d.describeid\n" +
"  where p.id=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new model.Detailed(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public Product getX(int id){
        try {
            String sql="select *from products\n" +
"where id=?;";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public ArrayList<OrderandProductandAccount> getOderByUsernameID(int id){
        ArrayList<OrderandProductandAccount> list=new ArrayList<>();
        try {
            String sql="select o.id,a.fullname,p.name,p.image,p.price,a.phone,a.email,o.status from orders as o\n" +
"  join accounts as a on a.id=o.account_id\n" +
"  join products as p on o.product_id=p.id\n" +
"  where a.id=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new OrderandProductandAccount(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));

            }
        } catch (SQLException e) {
            System.out.println("Loi o OrderandProductandAccount");
        }
        return list;
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        ArrayList<OrderandProductandAccount> list=dao.getOderByUsernameID(2);
        for (OrderandProductandAccount orderandProductandAccount : list) {
            System.out.println(orderandProductandAccount.getNameProduct());
        }
    }

}

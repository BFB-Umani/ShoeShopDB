package ShoeShop;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Database {

    private Shopper shopper;

    Properties p = new Properties();
    public List<Shoes> shoes = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();
    public List<Order> orders = new ArrayList<>();
    public List<NotInStock> stockList = new ArrayList<>();
    public List<Wants> wantsList = new ArrayList<>();


    public void connectToAndQueryShoeShop() throws IOException, ClassNotFoundException {
        shoes.clear();
        customers.clear();
        stockList.clear();



        p.load(new FileInputStream("src/ShoeShop/Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("användarnamn"), p.getProperty("lösenord"));) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT shoes.id as shoeId, size, price, colour.name as colour, brand.name as brand, amountInStock FROM shoes " +
                    "inner join brand on brand.id = shoes.brandId " +
                    "inner join colour on colour.id = shoes.colourId order by shoeId asc");

            while (rs.next()) {
                Shoes temp = new Shoes();
                temp.setBrand(rs.getString("brand"));
                temp.setColour(rs.getString("colour"));
                temp.setPrice(rs.getInt("price"));
                temp.setSize(rs.getInt("size"));
                temp.setAmountInStock(rs.getInt("amountInStock"));
                shoes.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("användarnamn"), p.getProperty("lösenord"));) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, password, area FROM customer ");

            while (rs.next()) {
                Customer temp = new Customer();
                temp.setID(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setPassword(rs.getString("password"));
                temp.setArea(rs.getString("area"));
                customers.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("användarnamn"), p.getProperty("lösenord"));) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT shoesId FROM notInStock ");

            while (rs.next()) {
                NotInStock temp = new NotInStock();
                temp.setShoeId(rs.getInt("shoesId"));
                stockList.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getOrder(Shopper shopper) throws ClassNotFoundException, IOException {
        orders.clear();
        p.load(new FileInputStream("src/ShoeShop/Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("användarnamn"), p.getProperty("lösenord"));) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, datum, customerId FROM customerOrder ");

            while (rs.next()) {
                Order temp = new Order();
                temp.setID(rs.getInt("id"));
                temp.setDatum(rs.getString("datum"));
                temp.setCustomerId(rs.getInt("customerId"));
                orders.add(temp);
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getDatum().equals(df.format(currentDate)) && orders.get(i).getCustomerId() == shopper.getID()) {
                    shopper.setOrderId(orders.get(i).getID());
                    break;
                } else {
                    shopper.setOrderId(orders.size() + 1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callAddCustomer(Shopper shopper) throws IOException, ClassNotFoundException {
        p.load(new FileInputStream("src/ShoeShop/Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("användarnamn"), p.getProperty("lösenord"));) {
            CallableStatement stmt = con.prepareCall("CALL AddCustomer (?,?,?)");
            stmt.setString(1, shopper.getName());
            stmt.setString(2, shopper.getPassword());
            stmt.setString(3, shopper.getArea());
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callAddToCart(Shopper shopper, int shoeId) throws IOException, ClassNotFoundException {
        p.load(new FileInputStream("src/ShoeShop/Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("användarnamn"), p.getProperty("lösenord"));) {
            CallableStatement stmt = con.prepareCall("CALL AddtoCart (?,?,?,?)");
            stmt.setInt(1, shopper.getID());
            stmt.setInt(2, shopper.getOrderId());
            stmt.setInt(3, shoeId);
            stmt.setString(4, shopper.getArea());
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showOrderSpecs() throws Exception {
        wantsList.clear();
        p.load(new FileInputStream("src/ShoeShop/Settings.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("användarnamn"), p.getProperty("lösenord"));) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT shoesId, orderId FROM wants");

            while (rs.next()) {
                Wants temp = new Wants();
                temp.setShoesId(rs.getInt("shoesId"));
                temp.setOrderId(rs.getInt("orderId"));
                wantsList.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

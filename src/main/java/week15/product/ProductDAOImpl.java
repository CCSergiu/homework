package week15.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl {

    public static void main(String[] args) {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        System.out.println("Read all products with ProductLine Planes:");
        productDAO.findAll()
                .stream()
                .filter(s -> s.getProductLine().equals("Planes"))
                .forEach(System.out::println);

        System.out.println("Read product with quantity in stock equals 1956:");
        productDAO.findAllByProductName(1956)
                .stream()
                .forEach(System.out::println);

        productDAO.create(Product.builder()
                .productCode("S00_0004")
                .productName("The Boeing4")
                .productLine("Planes")
                .productScale("1:500")
                .productVendor("Motor City")
                .productDescription("Macheta Noua")
                .quantityInStock(1956)
                .buyPrice(50.00)
                .MSRP(50.00)
                .build());

        productDAO.delete("S00_0002");

    }

    void create(Product product) {

        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO products (productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductLine());
            preparedStatement.setString(4, product.getProductScale());
            preparedStatement.setString(5, product.getProductVendor());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setInt(7, product.getQuantityInStock());
            preparedStatement.setDouble(8, product.getBuyPrice());
            preparedStatement.setDouble(9, product.getMSRP());

            int numberOfModifedRows = preparedStatement.executeUpdate();
            if (numberOfModifedRows == 1) {
                System.out.println("Produs adaugat cu success!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(String productCode) {

        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM products where productCode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productCode);

            int numberOfModifedRows = preparedStatement.executeUpdate();
            if (numberOfModifedRows == 1) {
                System.out.println("Produsul a fost sters cu success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM products";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductCode(resultSet.getString("productCode"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductLine(resultSet.getString("productLine"));
                product.setProductScale(resultSet.getString("productScale"));
                product.setProductVendor(resultSet.getString("productVendor"));
                product.setProductDescription(resultSet.getString("productDescription"));
                product.setQuantityInStock(resultSet.getInt("quantityInStock"));
                product.setBuyPrice(resultSet.getDouble("buyPrice"));
                product.setMSRP(resultSet.getDouble("MSRP"));
                products.add(product);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    List<Product> findAllByProductName(int quantityInStock) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM products WHERE quantityInStock = ?";
            String sqlInjectabil = "SELECT * FROM products WHERE quantityInStock = " + quantityInStock;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Statement statement = connection.createStatement();
            statement.executeQuery(sqlInjectabil);

            preparedStatement.setInt(1, quantityInStock);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductCode(resultSet.getString("productCode"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductLine(resultSet.getString("productLine"));
                product.setProductScale(resultSet.getString("productScale"));
                product.setProductVendor(resultSet.getString("productVendor"));
                product.setProductDescription(resultSet.getString("productDescription"));
                product.setQuantityInStock(resultSet.getInt("quantityInStock"));
                product.setBuyPrice(resultSet.getDouble("buyPrice"));
                product.setMSRP(resultSet.getDouble("MSRP"));
                products.add(product);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    void update(String productCode, Product product) {

    }

    private Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels?useSSL=true&serverTimezone=EET",
                    "root",
                    "parolam3a");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

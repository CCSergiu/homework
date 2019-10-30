package week15.order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    public static void main(String[] args) {
        OrderDAOImpl orderDAO = new OrderDAOImpl();

        System.out.println("Read all orders with status New Order:");
        orderDAO.findAll()
                .stream()
                .filter(s -> s.getStatus().equals("New Order"))
                .forEach(System.out::println);

        System.out.println("Read order number 10425: ");
        orderDAO.findAllByOrderNumber(10425)
                .stream()
                .forEach(System.out::println);

        orderDAO.create(Order.builder()
                .orderNumber(10005)
                .orderDate(LocalDate.of(1992, 10, 12))
                .requiredDate(LocalDate.of(1992, 10, 12))
                .shippedDate(LocalDate.of(1992, 10, 12))
                .status("New Order")
                .comments("New Order")
                .customerNumber(334)
                .build());

        orderDAO.delete(10009);

    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM orders";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderNumber(resultSet.getInt("orderNumber"));
                order.setOrderDate(resultSet.getDate("orderDate").toLocalDate());
                order.setRequiredDate(resultSet.getDate("requiredDate").toLocalDate());
                order.setShippedDate(resultSet.getDate("requiredDate").toLocalDate());
                order.setStatus(resultSet.getString("status"));
                order.setComments(resultSet.getString("comments"));
                order.setCustomerNumber(resultSet.getInt("customerNumber"));
                orders.add(order);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public List<Order> findAllByOrderNumber(int orderNumber) {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM orders WHERE orderNumber = ?";
            String sqlInjectabil = "SELECT * FROM orders WHERE orderNumber = " + orderNumber;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Statement statement = connection.createStatement();
            statement.executeQuery(sqlInjectabil);

            preparedStatement.setInt(1, orderNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderNumber(resultSet.getInt("orderNumber"));
                order.setOrderDate(resultSet.getDate("orderDate").toLocalDate());
                order.setRequiredDate(resultSet.getDate("requiredDate").toLocalDate());
                order.setShippedDate(resultSet.getDate("requiredDate").toLocalDate());
                order.setStatus(resultSet.getString("status"));
                order.setComments(resultSet.getString("comments"));
                order.setCustomerNumber(resultSet.getInt("customerNumber"));
                orders.add(order);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public void create(Order order) {

        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO orders (orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getOrderNumber());
            preparedStatement.setDate(2, Date.valueOf(order.getOrderDate()));
            preparedStatement.setDate(3, Date.valueOf(order.getRequiredDate()));
            preparedStatement.setDate(4, Date.valueOf(order.getShippedDate()));
            preparedStatement.setString(5, order.getStatus());
            preparedStatement.setString(6, order.getComments());
            preparedStatement.setInt(7, order.getCustomerNumber());
            int numberOfModifedRows = preparedStatement.executeUpdate();
            if (numberOfModifedRows == 1) {
                System.out.println("Comanda adaugata cu success!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int orderNumber) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM orders where orderNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (int) orderNumber);

            int numberOfModifedRows = preparedStatement.executeUpdate();
            if (numberOfModifedRows == 1) {
                System.out.println("Comanda a fost stearsa cu success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int orderNumber, Order order) {

    }

    private Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels?useSSL=true&serverTimezone=EET",
                    "root",
                    "parolam3a");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("eroare");
            return null;
        }
    }
}


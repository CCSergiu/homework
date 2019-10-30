package week15.order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    public static void main(String[] args) {
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        orderDAO.findAll()
                .stream()
                .filter(s -> s.getStatus().equals("Shipped"))
                .forEach(System.out::println);

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
        return null;
    }

    @Override
    public void create(Order order) {

    }

    @Override
    public void delete(int orderNumber) {

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


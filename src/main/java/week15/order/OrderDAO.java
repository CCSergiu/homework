package week15.order;

import java.util.List;

public interface OrderDAO {

    void create(Order order);

    void delete(int orderNumber);

    List<Order> findAll();

    List<Order> findAllByOrderNumber(int orderNumber);

    void update(int orderNumber, Order order);

}

package anemicsample.repositories;

import anemicsample.domain.model.Order;

public interface OrderRepository {

   Order getOrder(String orderId);

   Long saveOrderPayment(Order order);
}

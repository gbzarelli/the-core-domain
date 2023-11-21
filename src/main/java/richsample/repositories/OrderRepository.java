package richsample.repositories;

import richsample.domain.model.Order;
import richsample.domain.model.Payment;
import richsample.domain.model.vo.OrderId;

public interface OrderRepository {

   Order getOrder(OrderId orderId);

   Payment saveOrderPayment(Order order);
}

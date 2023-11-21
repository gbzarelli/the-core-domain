package richsample.services;

import lombok.AllArgsConstructor;
import richsample.domain.model.Payment;
import richsample.domain.model.vo.OrderId;
import richsample.repositories.OrderRepository;

@AllArgsConstructor
public class OrderService {

   private final OrderRepository orderRepository;

   public Payment payOrder(final OrderId orderId, final Payment payment){
      final var currentOrder = orderRepository.getOrder(orderId);
      final var orderPaid = currentOrder.addPayment(payment);
      return orderRepository.saveOrderPayment(orderPaid);
   }

}

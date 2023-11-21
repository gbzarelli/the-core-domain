package anemicsample.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import anemicsample.domain.model.Payment;
import anemicsample.repositories.OrderRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService {

   private final OrderRepository orderRepository;

   public Long payOrder(String orderId, BigDecimal amount, LocalDateTime paymentDate){
      if(paymentDate.isAfter(LocalDateTime.now())){
         throw new IllegalArgumentException("The payment date can't be after now!");
      }

      final var order = orderRepository.getOrder(orderId);

      if(order.getPayment() != null){
         throw new IllegalArgumentException("Order already paid");
      }

      if(order.getOrderAmount().compareTo(amount)!=0) {
         throw new IllegalArgumentException("The order value is different from the received");
      }

      final var payment = Payment
            .builder()
            .paymentDateTime(paymentDate)
            .amount(amount)
            .build();

      order.setPayment(payment);
      return orderRepository.saveOrderPayment(order);
   }

}

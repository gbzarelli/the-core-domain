package richsample.domain.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.Getter;
import richsample.domain.exception.AlreadyOrderPaymentException;
import richsample.domain.model.vo.OrderId;

// Remoção nas notações globais do Lombook, deixando-as específicas e garantindo mais imutablidade para o domínio
public class Order {

   // Considere a criação de objetos usando static factory

   //Static factory para a criação de uma nova Order:
   public static Order create(final OrderId orderId, final List<Product> items, final BigDecimal orderAmount) {
      return new Order(orderId, items, null, orderAmount);
   }

   //Static factory para a criação de uma Order com pagamento:
   public static Order from(final Order order, final Payment payment) {
      return new Order(order.id, order.items, payment, order.orderAmount);
   }

   @Getter
   private final OrderId id;

   private final List<Product> items;

   private final Payment payment;

   @Getter
   private final BigDecimal orderAmount;

   // Contrutor privado, restringindo a construção via static factory, e validando as entradas.
   private Order(final OrderId id, final List<Product> items, final Payment payment, final BigDecimal orderAmount) {
      this.id = Objects.requireNonNull(id, "OrderId can't be null");
      if (items == null || items.isEmpty()) {
         throw new IllegalArgumentException("Items can't be empty or null");
      } else {
         this.items = items;
      }
      this.payment = payment;
      if (orderAmount == null || orderAmount.compareTo(BigDecimal.ZERO) <= 0) {
         throw new IllegalArgumentException("Order cannot have a value less than or equal to zero");
      }
      this.orderAmount = orderAmount;
   }

   // Adicionando um pagamento e mantendo a imutabilidade:
   public Order addPayment(final Payment payment){
      if(isAlreadyPaid()){
         throw new AlreadyOrderPaymentException("Payment already exists in order");
      }
      return Order.from(this, payment);
   }

   public boolean isAlreadyPaid() {
      return getPayment().isPresent() && payment.getAmount().compareTo(orderAmount) == 0;
   }

   public Optional<Payment> getPayment() {
      return Optional.ofNullable(payment);
   }

   public List<Product> getItems() {
      //Para evitar a modificação fora do domínio.
      return Collections.unmodifiableList(items);
   }
}

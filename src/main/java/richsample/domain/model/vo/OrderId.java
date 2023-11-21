package richsample.domain.model.vo;

import java.util.Objects;

import lombok.Getter;

@Getter
public class OrderId {
   public static OrderId valueOf(final String orderId) {
      return new OrderId(orderId);
   }

   private final String value;

   private OrderId(final String value) {
      this.value = Objects.requireNonNull(value);
      if(value.length() < 10 || value.length() > 20){
         // O que define um orderId? Podemos ter regras e validações específicas de negócio.
         throw new IllegalArgumentException("Invalid orderId");
      }
   }
}

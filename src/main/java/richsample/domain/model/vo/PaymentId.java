package richsample.domain.model.vo;

import lombok.Getter;

@Getter
public class PaymentId {

   public static PaymentId valueOf(final Long paymentId) {
      return new PaymentId(paymentId);
   }

   public static final PaymentId NOT_REGISTERED = new PaymentId(0L);

   private final Long value;

   private PaymentId(final Long value) {
      this.value = value;
   }
}

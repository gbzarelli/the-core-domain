package richsample.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import richsample.domain.model.vo.PaymentId;

public class Payment {

   public static Payment create(final PaymentId paymentId, final BigDecimal amount, final LocalDateTime paymentDateTime) {
      return new Payment(paymentId, amount, paymentDateTime);
   }

   public static Payment create(final BigDecimal amount, final LocalDateTime paymentDateTime) {
      return new Payment(PaymentId.NOT_REGISTERED, amount, paymentDateTime);
   }

   @Getter
   private final PaymentId paymentId;

   @Getter
   private final BigDecimal amount;

   @Getter
   private final LocalDateTime paymentDateTime;

   private Payment(final PaymentId paymentId, final BigDecimal amount, final LocalDateTime paymentDateTime) {
      this.paymentId = paymentId;
      if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
         throw new IllegalArgumentException("Payment cannot have a value less than or equal to zero");
      }
      this.amount = amount;
      if (paymentDateTime == null || paymentDateTime.isAfter(LocalDateTime.now())) {
         throw new IllegalArgumentException("The payment date can't be after now or null");
      }
      this.paymentDateTime = paymentDateTime;
   }

}

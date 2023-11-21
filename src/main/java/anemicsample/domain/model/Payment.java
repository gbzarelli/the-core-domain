package anemicsample.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Payment {

   private Long paymentId;

   private BigDecimal amount;

   private LocalDateTime paymentDateTime;
}

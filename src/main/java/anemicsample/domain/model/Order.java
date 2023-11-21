package anemicsample.domain.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {

   private String id;

   private List<Product> items;

   private Payment payment;

   private BigDecimal orderAmount;

}

package richsample.domain.exception;

public class AlreadyOrderPaymentException extends RuntimeException {

   public AlreadyOrderPaymentException(String message) {
      super(message);
   }
}

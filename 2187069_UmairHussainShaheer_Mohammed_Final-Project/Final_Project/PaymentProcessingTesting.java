package Final_Project;



import org.junit.Test;

import static org.junit.Assert.*;



public class PaymentProcessingTesting {

	
 @Test

 public void testProcessPaymentSuccess() {

 PaymentProcessor PaymentProcessor = new PaymentProcessor();

 double Amount = 100.0;

 String PaymentMethod = "Debit Card";

 assertTrue(PaymentProcessor.processPayment(Amount, PaymentMethod));

 }


 @Test

 public void testProcessPaymentInvalidAmount() {

 PaymentProcessor PaymentProcessor = new PaymentProcessor();

 double InvalidAmount = -50.0;

 String PaymentMethod = "Debit Card";

 assertFalse(PaymentProcessor.processPayment(InvalidAmount, PaymentMethod));

 }


 @Test

 public void testProcessPaymentInvalidMethod() {

 PaymentProcessor PaymentProcessor = new PaymentProcessor();

 double Amount = 50.0;

 String InvalidMethod = "Invalid Method";

 assertFalse(PaymentProcessor.processPayment(Amount, InvalidMethod));

 }

}

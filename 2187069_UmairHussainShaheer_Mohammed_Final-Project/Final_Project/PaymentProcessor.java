package Final_Project;



class PaymentProcessor {

 public boolean processPayment(double Amount, String PaymentMethod) {


	
 if (isValidPaymentMethod(PaymentMethod)) {

 if (Amount > 0) {

 System.out.println("Processing payment of $" + Amount + " via " + PaymentMethod);

 System.out.println("Yay !! Payment successful.");

 return true;

 } else {

 System.out.println("Invalid payment amount.");

 }

 } else {

 System.out.println("Invalid payment method.");

 }

 System.out.println("Payment processing failed.");

 return false;

 }

 private boolean isValidPaymentMethod(String PaymentMethod) {


 return !"Invalid Method".equals(PaymentMethod);

 }

}

package Final_Project;


class OrderProcessing {

 private User User;

 private ShoppingCart Cart;

 private String OrderStatus;



 public OrderProcessing(User user, ShoppingCart cart) {

	
 this.User = user;

 this.Cart = cart;

 this.OrderStatus = "OrderProcessing is Pending";

 }

 
 public void placeOrder() {

 if (OrderStatus.equals("OrderProcessing is Pending")) {


 System.out.println("Placing the order for the User: " + User.getUsername());


 System.out.println("OrderProcessing Details:");

 for (Product product : Cart.getItems()) {

 System.out.println(product.getName() + " - $" + product.getPrice());

 }


 System.out.println("Total Amount is : $" + Cart.getTotalAmount() + "Only");


 this.OrderStatus = "OrderProcessing Placed";



 System.out.println("Great!! Your OrderProcessing is Sucessfully Placed.");

 } else {

 System.out.println("OrderProcessing has already been placed.");

 }

 }


 public User getUser() {

	 System.out.println("Hello!! " + getUser());

 return User;

 }

 public ShoppingCart getCart() {

 return Cart;

 }

 public String getOrderStatus() {

 return OrderStatus;

 }

}

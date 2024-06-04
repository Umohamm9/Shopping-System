package Final_Project;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

public class ShoppingCartTest {

	
 @Test

 public void testGetTotalAmount() {


 List<Product> products = ProductLoader.loadProducts();



 ShoppingCart Cart = new ShoppingCart();



 Cart.addItem(products.get(0)); // TV

 Cart.addItem(products.get(2)); // Smartwatch

 Cart.addItem(products.get(4)); // Printer

 Cart.addItem(products.get(6)); // T-Shirt


 double ExpectedTotalAmount = products.get(0).getPrice() + products.get(2).getPrice()

 + products.get(4).getPrice() + products.get(6).getPrice();



 assertEquals(ExpectedTotalAmount, Cart.getTotalAmount(), 0.01);

 }


 @Test

 public void testAddItem() {


 List<Product> products = ProductLoader.loadProducts();



 ShoppingCart Cart = new ShoppingCart();


 

 Cart.addItem(products.get(3)); // SmartPhone

 

 assertEquals(1, Cart.getItems().size());

 assertEquals(products.get(3), Cart.getItems().get(0));

 }


 @Test

 public void testRemoveItem() {


 List<Product> products = ProductLoader.loadProducts();


 ShoppingCart Cart = new ShoppingCart();

 Product product = products.get(5);

 Cart.addItem(product);

 Cart.removeItem(product);

 assertEquals(0, Cart.getItems().size());

 }
}


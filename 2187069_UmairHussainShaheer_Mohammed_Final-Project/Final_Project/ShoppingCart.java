package Final_Project;



import java.util.ArrayList;

import java.util.List;



class ShoppingCart {

 private List<Product> Products = new ArrayList<>();



 public void addItem(Product product) {

 Products.add(product);

 }


 public void removeItem(Product product) {

 Products.remove(product);

 }


 public List<Product> getItems() {

 return Products;

 }


 public double getTotalAmount() {

 double total = 0.0;

 for (Product item : Products) {

 total += item.getPrice();

 }

 return total;

 }

	public void addToCart(Product product1) {

	

	}



	public void removeFromCart(Product product1) {
	}

}

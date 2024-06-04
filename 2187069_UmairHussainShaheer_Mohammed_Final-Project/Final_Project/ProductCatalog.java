package Final_Project;

import java.util.ArrayList;

import java.util.List;

public class ProductCatalog {

 private List<Product> products = new ArrayList<>();

 public void addProduct(Product product) {

     products.add(product);

 }

 public Product getProductByName(String name) {

     for (Product product : products) {

         if (product.getName().equalsIgnoreCase(name)) {

             return product;

         }

     }

     return null;

 }

 public List<Product> getAllProducts() {
	 System.out.println("Please choose '4. Add to Cart' to purchase from the following Products:");
     return products;

 }

 public void addProducts(List<Product> newProducts) {
	 
     products.addAll(newProducts);

 }

}

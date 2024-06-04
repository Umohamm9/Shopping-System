package Final_Project;



import java.util.ArrayList;

import java.util.List;

public class ProductLoader {

 public static List<Product> loadProducts() {

 List<Product> products = new ArrayList<>();


 ElectronicFactory TV = new ElectronicFactory("TV", 1200.0, "Smart TV with OLED 4K Display", 10);

 ElectronicFactory DSLR = new ElectronicFactory("DSLR", 99.99, "Digital Camera with 4K Quality", 20);

 ElectronicFactory Smartwatch = new ElectronicFactory("Smartwatch", 199.99, "Fitness and health tracker", 15);
 
 ElectronicFactory Smartphone = new ElectronicFactory("Smartphone", 799.99, "Flagship smartphone with advanced features", 12);

 ElectronicFactory Printer = new ElectronicFactory("Printer", 499.99, "2-Dimensional Scanner & Printer ", 8);

 ClothingFactory Jeans = new ClothingFactory("Jeans", 39.99, "Slim-fit blue jeans", 30);
 
 ClothingFactory TShirt = new ClothingFactory("T-Shirt", 25.0, "Comfortable cotton T-shirt", 50);

 ClothingFactory Sneakers = new ClothingFactory("Sneakers", 59.99, "Casual sneakers for everyday wear", 25);

 ClothingFactory SweatShirt = new ClothingFactory("SweatShirt", 79.99, "Elegant evening dress", 15);

 ClothingFactory Hoodie = new ClothingFactory("Hoodie", 29.99, "Comfortable fleece hoodie", 40);

 
 
 
 
 
 
 products.add(TV);
 
 products.add(DSLR);

 products.add(Smartwatch);

 products.add(Smartphone);

 products.add(Printer);

 products.add(TShirt);

 products.add(Jeans);

 products.add(Sneakers);

 products.add(SweatShirt);

 products.add(Hoodie);

 return products;

 }

}


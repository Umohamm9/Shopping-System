package Final_Project;

import java.util.Scanner;

import java.util.List;

import java.util.regex.Pattern; 





public class MainClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User currentUser = null;

        UserAuthentication userAuthentication = new UserAuthentication();

        ShoppingCart shoppingCart = new ShoppingCart();

        ProductCatalog productCatalog = new ProductCatalog();


        List<Product> products = ProductLoader.loadProducts();

        productCatalog.addProducts(products);

        

        while (true) {

            System.out.println("1. Login");

            System.out.println("2. Register");

            System.out.println("3. Browse Products");

            System.out.println("4. View Cart ");

            System.out.println("5. Add Products to Cart ");

            System.out.println("6. Place OrderProcessing");

            System.out.println("7. Exit");

           
            if (currentUser != null) {

                System.out.println("Logged in as: " + currentUser.getUsername());

            }
            
            System.out.print("Select an option: ");  
         
            int Select = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (Select) {
                case 1: // Login
                    if (currentUser != null) {
                        System.out.println("You are already logged in.");
                    } else {
                        System.out.print("Enter Username: ");
                        String loginUsername = scanner.nextLine();
                        
                        System.out.print("Enter Password: ");
                        String loginPassword = scanner.nextLine();
                        
                        currentUser = userAuthentication.login(loginUsername, loginPassword);
                        
                        if (currentUser != null) {
                        	
                            Logging.Log("User logged in: " + currentUser.getUsername());
                            
                            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
                            
                            
                        } else {
                            Logging.Log("Login failed for user: " + loginUsername);
                            
                            System.out.println("Login failed. Please check your credentials.");
                        }
                    }
                    break;
                    
                    
                case 2: // Register
                	
                    System.out.print("Enter Username: ");
                    
                    String Username = scanner.nextLine();
                    
                    
                    System.out.print("Enter Password: ");
                    
                    String password = scanner.nextLine();
                    
                    System.out.print("Enter Name: ");
                    
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Email: ");
                    
                    String email = scanner.nextLine();
                    
                    // Validate input
                    if (!isValidUsername(Username)) {
                    	
                        System.out.println("Username must not contain any other Special characters and Numbers  other Alphabets, $ and @");
                        
                    } else if (!isValidPassword(password)) {
                    	
                        System.out.println("Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");
                        
                    } else if (!isValidName(name)) {
                    	
                        System.out.println("Name must be in the format 'First- Last' with the first letter of each word capitalized.");
                        
                    } else if (!isValidEmail(email)) {
                    	
                        System.out.println("Email must contain the @ symbol.");
                        
                    } else {
                    	
                        userAuthentication.registerUser(Username, password, name, email);
                        
                        Logging.Log("User registered: " + Username);
                        
                        System.out.println("User registered successfully!");
                        
                    }
                    break;
                    
                default:
                	
                    System.out.println("Invalid selection.");
                    
                    break;
            


                case 3: // Browse Products (Unimplemented - ProductCatalog of Products)

                    



                    displayProductList(productCatalog.getAllProducts());

                    break;

                case 4: // View Cart

                    if (currentUser != null) {

                        List<Product> items = shoppingCart.getItems();

                        System.out.println("Cart for " + currentUser.getUsername() + ":");

                        for (Product item : items) {

                            System.out.println(item.getName());

                        }



                        double totalPrice = calculateTotalPrice(shoppingCart);

                        System.out.println("Total Price: $" + totalPrice);

                    } else {

                        System.out.println("You need to log in to view your cart.");

                    }

                    break;


                    
                case 5: // Add Products to Cart
                	
                    if (currentUser != null) {
                    	
                        // Display available products
                    	
                        System.out.println("Available Products:");
                        
                        List<Product> allProducts = productCatalog.getAllProducts();
                        
                        for (int i = 0; i < allProducts.size(); i++) {
                        	
                            System.out.println((i + 1) + ". " + allProducts.get(i).getName());
                        }
                        

                        System.out.print("Enter the number corresponding to the product to add to the cart: ");
                        
                        int ProductChoice = scanner.nextInt();
                        
                        scanner.nextLine(); // Consume the newline character
                        
                      
                        if (ProductChoice >= 1 && ProductChoice <= allProducts.size()) {
                           
                        	Product SelectedProduct = allProducts.get(ProductChoice - 1);
                            
                            shoppingCart.addItem(SelectedProduct);
                           
                           System.out.println("Product added to the cart.");
                           
                        } else {
                        	
                            System.out.println("Invalid product choice.");
                            
                        }
                    } else {
                    	
                        System.out.println("You need to log in to add products to the cart.");
                        
                    }
                    break;


             

                case 6: 

                    if (currentUser != null) {

                        System.out.println("Placing an order...");
                        

                        double TotalPrice = calculateTotalPrice(shoppingCart);

                        boolean PaymentSuccess = new PaymentProcessor().processPayment(TotalPrice, "Debit Card");


                        if (PaymentSuccess) {

                            Logging.Log("OrderProcessing placed for the User: " + currentUser.getUsername());

                            System.out.println("Great !! OrderProcessing placed successfully.");
                            System.out.println("Thank you for Shopping.");


                        } else {

                            Logging.Log("Payment failed for the User: " + currentUser.getUsername());

                            System.out.println("Sorry !! Payment failed. Please try again.");

                        }

                    } else {

                        System.out.println("You need to log in to place an order.");

                    }

                    break;

                case 7: // Exit

                    System.out.println("Thank You for Visiting !! Program has Ended.");

                    scanner.close();

                    System.exit(0);

            

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }

    

    private static boolean isValidUsername(String Username) {

        return Pattern.matches("^[A-Z][a-z]+$", Username);

    }



    private static boolean isValidPassword(String Password) {

        return Pattern.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$", Password);

    }



    private static boolean isValidName(String Name) {


        return Pattern.matches("^[A-Z][a-z]* [A-Z][a-z]*$", Name);
        
    }



    private static boolean isValidEmail(String email) {


        return email.contains("@");

    }



    private static void displayProductList(List<Product> ProductList) {

        System.out.println("List of Products :");

        for (int i = 0; i < ProductList.size(); i++) {

            Product product = ProductList.get(i);

            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());

            System.out.println("   Description: " + product.getDescription());

            System.out.println("   Quantity in Stock: " + product.getQuantityInStock());

        }

    }


@SuppressWarnings("unused")
private static Product findProductByName(List<Product> CatalogProducts, String ProductName) {

    for (Product product : CatalogProducts) {

        if (product.getName().equalsIgnoreCase(ProductName)) {

            return product;

        }

    }

    return null;

}


private static double calculateTotalPrice(ShoppingCart shoppingCart) {

    double total = 0.0;

    for (Product product : shoppingCart.getItems()) {

        total += product.getPrice();

    }
    System.out.println("Please Pay $" + total);
    
    return total;

}

}

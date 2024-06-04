package Final_Project;



import javax.swing.*;



import java.awt.FlowLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.List;





public class MainClassGUI extends JFrame {

	private static final long serialVersionUID = 1L;

 private User CurrentUser;

 private UserAuthentication UserAuthentication;

 private ShoppingCart ShoppingCart;

 private ProductCatalog Catalog;
 



 public MainClassGUI() {

 super("Online Shopping System");

 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 setSize(400, 300);

 setLocationRelativeTo(null);

 
 UserAuthentication = new UserAuthentication();

 ShoppingCart = new ShoppingCart();

 Catalog = new ProductCatalog();


 Catalog.addProducts(ProductLoader.loadProducts());



 createGUIComponents();



 setVisible(true);

 }


private void createGUIComponents() {

 JPanel panel = new JPanel(new FlowLayout());


 JButton loginButton = new JButton("Login");

 loginButton.setBounds(160, 20, 120, 30);

 loginButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showLoginDialog();

 }

 });

 panel.add(loginButton);


 
 JButton registerButton = new JButton("Register");

 registerButton.setBounds(20, 20, 120, 30);

 registerButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showRegistrationDialog();

 }

 });

 panel.add(registerButton);



 JButton browseProductsButton = new JButton("Browse Products");

 browseProductsButton.setBounds(20, 70, 260, 30);

 browseProductsButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showProductList();

 }

 });

 panel.add(browseProductsButton);


 JButton viewCartButton = new JButton("View Cart");

 viewCartButton.setBounds(160, 120, 120, 30);

 viewCartButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showCart();

 }

 });

 panel.add(viewCartButton);



 JButton addToCartButton = new JButton("Add to Cart");

 addToCartButton.setBounds(20, 120, 120, 30);

 addToCartButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showAddToCartDialog();

 }

 });

 panel.add(addToCartButton);


 JButton placeOrderButton = new JButton("Place OrderProcessing");

 placeOrderButton.setBounds(20, 170, 260, 30);

 placeOrderButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 placeOrder();

 }

 });

 panel.add(placeOrderButton);

 add(panel);

 JButton removeFromCartButton = new JButton("Remove from Cart");

 removeFromCartButton.setBounds(160, 170, 120, 30);

 removeFromCartButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 removeFromCartDialog();

 }

 });

 panel.add(removeFromCartButton);

add(panel);
}

private void showRegistrationDialog() {

 JTextField usernameField = new JTextField();

 JPasswordField passwordField = new JPasswordField();

 JTextField nameField = new JTextField();

 JTextField emailField = new JTextField();



 Object[] message = {

 "Username:", usernameField,

 "Password:", passwordField,

 "Name:", nameField,

 "Email:", emailField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Registration", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String Username = usernameField.getText();

 String Password = new String(passwordField.getPassword());

 String Name = nameField.getText();

 String Email = emailField.getText();


 
 

 // Validate input

 if (!isValidUsername(Username)) {

 JOptionPane.showMessageDialog(null, "Username must not contain any other Special characters and Numbers  other Alphabets, $ and @.");

 } else if (!isValidPassword(Password)) {

 JOptionPane.showMessageDialog(null, "Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");

 } else if (!isValidName(Name)) {

 JOptionPane.showMessageDialog(null, "Name must be in the format 'First Last' with the first letter of each word capitalized.");

 } else if (!isValidEmail(Email)) {

 JOptionPane.showMessageDialog(null, "Email must contain the @ symbol.");

 } else {

 UserAuthentication.registerUser(Username, Password, Name, Email);

 Logging.Log("User registered: " + Username);

 JOptionPane.showMessageDialog(null, "User registered successfully!");

 }

 }

 }


 private void showLoginDialog() {

 JTextField usernameField = new JTextField();

 JPasswordField passwordField = new JPasswordField();



 Object[] message = {

 "Username:", usernameField,

 "Password:", passwordField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String loginUsername = usernameField.getText();

 String loginPassword = new String(passwordField.getPassword());



 if (CurrentUser != null) {

 JOptionPane.showMessageDialog(null, "You are already logged in.");

 } else {

 CurrentUser = UserAuthentication.login(loginUsername, loginPassword);



 if (CurrentUser != null) {

 Logging.Log("User logged in: " + CurrentUser.getUsername());

 JOptionPane.showMessageDialog(null, "Login successful. Welcome, " + CurrentUser.getUsername() + "!");

 } else {

 Logging.Log("Login failed for user: " + loginUsername);

 JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");

 }

 }

 }

 }



 private void showProductList() {

 List<Product> productList = Catalog.getAllProducts();



 if (!productList.isEmpty()) {

 DefaultListModel<String> listModel = new DefaultListModel<>();

 

 for (Product product : productList) {

 String productInfo = product.getName() + " - $" + product.getPrice()

 + "\n Description: " + product.getDescription()

 + "\n Quantity in Stock: " + product.getQuantityInStock() + "\n";

 listModel.addElement(productInfo);

 }



 JList<String> productListJList = new JList<>(listModel);

 JScrollPane scrollPane = new JScrollPane(productListJList);



 JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.PLAIN_MESSAGE);

 } else {

 JOptionPane.showMessageDialog(null, "No products available in the catalog.", "Product List", JOptionPane.INFORMATION_MESSAGE);

 }

 }

 private void showAddToCartDialog() {

 if (CurrentUser != null) {

 JTextField productNameField = new JTextField();



 Object[] message = {

 "Enter the product name to add to the cart:", productNameField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Add to Cart", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String productName = productNameField.getText();

 Product selectedProduct = findProductByName(Catalog.getAllProducts(), productName);



 if (selectedProduct != null) {

 ShoppingCart.addItem(selectedProduct);

 JOptionPane.showMessageDialog(null, "Product added to the cart.");

 } else {

 JOptionPane.showMessageDialog(null, "Product not found in the catalog.");

 }

 }

 } else {

 JOptionPane.showMessageDialog(null, "You need to log in to add products to the cart.");

 }

 }


 private void removeFromCartDialog() {

 if (CurrentUser != null) {

 List<Product> cartItems = ShoppingCart.getItems();



 if (!cartItems.isEmpty()) {

 JTextField productNameField = new JTextField();



 Object[] message = {

 "Enter the product name to remove from the cart:", productNameField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Remove from Cart", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String productName = productNameField.getText();

 Product productToRemove = findProductByName(cartItems, productName);



 if (productToRemove != null) {

 ShoppingCart.removeItem(productToRemove);

 JOptionPane.showMessageDialog(null, "Product removed from the cart.");

 } else {

 JOptionPane.showMessageDialog(null, "Product not found in the cart.");

 }

 }

 } else {

 JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Remove from Cart", JOptionPane.INFORMATION_MESSAGE);

 }

 } else {

 JOptionPane.showMessageDialog(null, "You need to log in to remove products from the cart.");

 }

 }

 private Product findProductByName(List<Product> products, String productName) {

 for (Product product : products) {

 if (product.getName().equalsIgnoreCase(productName)) {

 return product;

 }

 }

 return null;

 }


	private void showCart() {

 java.util.List<Product> cartItems = ShoppingCart.getItems();



 if (!cartItems.isEmpty()) {

 DefaultListModel<String> listModel = new DefaultListModel<>();



 for (Product item : cartItems) {

 String itemInfo = item.getName() + " - $" + item.getPrice();

 listModel.addElement(itemInfo);

 }



 JList<String> cartItemList = new JList<>(listModel);

 JScrollPane scrollPane = new JScrollPane(cartItemList);



 double totalPrice = calculateTotalPrice(ShoppingCart);

 String totalPriceMessage = "Total Price: $" + totalPrice;



 JOptionPane.showMessageDialog(null, new Object[]{scrollPane, totalPriceMessage}, "Shopping Cart", JOptionPane.PLAIN_MESSAGE);

 } else {

 JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);

 }

 }

	

	private void placeOrder() {

	if (CurrentUser != null) {

	System.out.println("Placing an order...");



	// Placeholder for calculating total price

	double totalPrice = calculateTotalPrice(ShoppingCart);



	// Placeholder for processing payment (replace with your payment processing logic)

	boolean paymentSuccess = new PaymentProcessor().processPayment(totalPrice, "Credit Card");



	if (paymentSuccess) {

	Logging.Log("OrderProcessing placed for user: " + CurrentUser.getUsername());

	JOptionPane.showMessageDialog(null, "OrderProcessing placed successfully. Payment received.");

	// Clear the cart after successful payment

	} else {

	Logging.Log("Payment failed for user: " + CurrentUser.getUsername());

	JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");

	}

	} else {

	JOptionPane.showMessageDialog(null, "You need to log in to place an order.");

	}

	}


	private double calculateTotalPrice(ShoppingCart shoppingCart) {

 double total = 0.0;

 for (Product product : shoppingCart.getItems()) {

 total += product.getPrice();

 }

 return total;

 }

	private boolean isValidUsername(String username) {

	// Username must not contain any other Special characters and Numbers  other Alphabets, $ and @

	return username.matches("^[A-Z][a-z]+$");

	}

	private boolean isValidPassword(String password) {

	// Password must contain one uppercase letter, one special character, one number, and at least 8 characters.

	return password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$");

	}



	private boolean isValidName(String name) {

	return name.matches("^[A-Z][a-z]*\\s[A-Z][a-z]*$");

	}



	private boolean isValidEmail(String email) {

	return email.contains("@");

	}


 public static void main(String[] args) {

 SwingUtilities.invokeLater(new Runnable() {

 @Override

 public void run() {

 new MainClassGUI();

 }

 });

 }

}


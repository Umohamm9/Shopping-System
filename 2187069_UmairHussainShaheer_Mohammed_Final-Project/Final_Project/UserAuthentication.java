package Final_Project;



import java.util.ArrayList;

import java.util.List;



public class UserAuthentication {

 private List<User> users;


 public UserAuthentication() {

 this.users = new ArrayList<>();

 }

 public void registerUser(String Username, String Password, String Name, String Email) {

 // Checks if the Username is already in use

 if (isUsernameTaken(Username)) {

 System.out.println("Username is already taken. Please Register using another Username.");

 return;

 }



 // Create a new user and add them to the list of users

 User newUser = new User(Username, Password, Name, Email);

 users.add(newUser);

 System.out.println("User is Sucessfully Registeresd!");

 }



 public User login(String username, String password) {

 for (User user : users) {

 if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
System.out.println("Hello "+ user);
 return user; // User found, return the user object

 }

 }

 return null; // User not found

 }


 private boolean isUsernameTaken(String username) {

 for (User user : users) {

 if (user.getUsername().equals(username)) {

 return true; // Username is already in use

 }

 }

 return false; // Username is available

 }

	public boolean isValidPassword(String password) {

	return false;

	}

	public boolean isValidUsername(String username) {

	return false;

	}

}

// Nicolas Wise Binary Node
// 10 April 2023
// WSXNIC001

import java.util.*;
import java.io.*; 
/***
 * @author wsxnic001
 */
public class TokTik{

   static Scanner scan = new Scanner(System.in);
   static BinarySearchTree bt = new BinarySearchTree();
   
   /**
 * @param args
 * @throws FileNotFoundException
 */
	public static void main(String [] args)  throws java.io.FileNotFoundException{
		
		System.out.print("Choose an action from the menu: \n 1. Find the profile description for a given account \n 2. List all accounts \n 3. Create an account \n 4. Delete an account \n 5. Display all posts for a given user \n 6. Add a post for an account \n 7. Load a file of actions from disk and process this \n 8. Quit \n Enter your choice: ");
		String choice = scan.nextLine();
		while(!choice.equals("8")){
			if (choice.equals("1")){
				findDescription();
			}
			else if (choice.equals("2")){
				listAccounts();;
			}
			else if (choice.equals("3")){
				createAccount();
			}
			else if (choice.equals("4")){
				deleteAccount();
			}
			else if (choice.equals("5")){
				displayAllPosts();
			}
			else if (choice.equals("6")){
				addNewPost();
			}
			else if (choice.equals("7")){
				String file = "dataset.txt";
      		try (BufferedReader nic = new BufferedReader(new FileReader(file))){
      			String line;
      			while ((line = nic.readLine())!=null){
      				//each line to an array of strings
      				String [] strings = line.split(" ");
      			
      				//switch statement. Create - add user/Add - add post
      				switch(strings[0]){
      					case "Create":
      						line = line.substring(line.indexOf(" ")+1, line.length());
      						String description =line.substring(line.indexOf(" ") + 1, line.length());
      						String name = strings[1];
      						bt.insert(name, description);
      				
      					case "Add":
      						String accountName = strings[1];
      						String fileName = strings[2];
      						String likes = strings[3];
      						String postDescription = String.join(" ", Arrays.copyOfRange(strings, 4, strings.length));
      						bt.insertPost(accountName, fileName, postDescription, likes);
      				}
      			}
      		}
      	catch (IOException e){
      		System.err.println("Error: "+e.getMessage());
      	}
		}
		else if (choice.equals("8")){
			System.out.println("Bye");
		}
		System.out.println();
		System.out.print("Choose an action from the menu: \n 1. Find the profile description for a given account \n 2. List all accounts \n 3. Create an account \n 4. Delete an account \n 5. Display all posts for a given user \n 6. Add a post for an account \n 7. Load a file of actions from disk and process this \n 8. Quit \n Enter your choice: ");
		choice = scan.nextLine();
		System.out.println();
	}
	System.out.println("Bye!");
	scan.close();
}
	
      
    /**
     * method for finding description of a particular account
     */
    private static void findDescription(){
      	System.out.println("Enter the account name: ");
      	String username = scan.nextLine();
      	//finish find method
      	Node account = bt.findAccount(username);
      	if (account!=null){
      		System.out.println(account.getName() + "'s description is: " + account.getDescription());
      	}
      	else{
      		System.out.println("Account not found");
      	}
      }

	  /**
	 * method to list all accounts
	 */
	private static void listAccounts(){
		System.out.println("Accounts: ");
		if (bt.root == null){
			System.out.println("There are no accounts");
		}else{
			bt.inOrder();
		}
	  }
      
      /**
     * method to create an account
     */
    private static void createAccount(){
      	System.out.println("Enter the account name: ");
      	String username = scan.nextLine();
      	
      	Node account = bt.findAccount(username);
      	if (account != null){
      		System.out.println("Account already exists.");
      	}
      	else{
      	System.out.println("Enter "+ username +"'s description: ");
      	String description = scan.nextLine();
      	
      	
      	bt.insert(username, description);
      	System.out.println(username + "'s account has been created");
		}
      }
      
      /**
     * method to delete an account
     */
    private static void deleteAccount(){
      	System.out.println("Enter the account name: ");
      	String username = scan.nextLine();
      	
      	Node account = bt.findAccount(username);
      	if (account == null){
      		System.out.println("Account not found");
      		return;
      	}
      	bt.delete(username);
      	System.out.println(username + "'s account deleted");
      } 
      
      /**
     * method to display the posts of a particular user
     */
    private static void displayAllPosts(){
      	System.out.println("Enter the account name: ");
      	String accountName = scan.nextLine();
      	
      	Node account = bt.findAccount(accountName);
      	if (account == null){
      		System.out.println("Account not found");
      		return;
      	}
      	System.out.println("Posts: ");
      	System.out.println(bt.printAccountPosts(accountName));
      }
      
      /**
     * method to add a new post to a particular user
     */
    private static void addNewPost(){
      	System.out.println("Enter the account name: ");
      	String accountName = scan.nextLine();
      	Node account = bt.findAccount(accountName);
      	if(account == null){
      		System.out.println("Account not found");
      		return;
      	}
      	System.out.println("Enter post file name: ");
      	String fileName = scan.nextLine();
      	
		System.out.println("Enter the post's description");
		String description = scan.nextLine();

		Post pst = new Post(accountName, fileName, description, null);
      	account.addPost(pst);
      	System.out.println("Post entered");
      }
}



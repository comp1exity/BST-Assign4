// Nicolas Wise Binary Node
// 10 April 2023
// WSXNIC001
import java.util.ArrayList;
/***
 * @author wsxnic001
 */
public class BinarySearchTree
{
   public Node root;
   
   public BinarySearchTree ()
   {
      root = null;
   }

   
   /** recursive insert fucntion
    * @param accountName
    * @param description
    */
   public void insert(String accountName, String description){
   	root = insertNode(root, accountName, description);
   }
   //
   /**recursive insert into Binary Search Tree.
    * @param node
    * @param accountName
    * @param description
    * @return node that has been inserted.
    */
   public Node insertNode(Node node, String accountName, String description){
      //if node is empty, recursive call of insert method
   	if (node == null){
   		node = new Node(accountName, description);
   	}
      //boolean used to compare account names
   	int cmp = accountName.compareTo(node.getName());
      //recursively move through left sub tree
   	if (cmp < 0){
   		node.left = insertNode(node.left, accountName, description);
   	}
      //recusively move through right sub tree
   	else if (cmp > 0){
   		node.right = insertNode(node.right, accountName, description);
   	}
      //once recursive calls are finished and cmp = 0, it will return the node that has been inserted
   	return node;
   }
   
   
   /**find account method, uses find node
    * @param username
    * @return the account we want to find
    */
   public Node findAccount(String username){
      //if the sting inputted by the user is not empty, recursive call to findNode
   	if (username != null){
   		return findNode(root, username);
   	}
   	else{
   		return null;
   	}
   }

   
   /**find function, provides functionality in seperate methods
    * @param accountName
    * @return node we want to find
    */
   public Node findNode(Node node,String accountName){
      if (node == null) {
         return null;
     }

     // use compareTo to return a boolean value, used to decipher wether to run through left or right sub trees.
     int cmp = accountName.compareTo(node.accountName);

     // use compareTo
     if (cmp < 0) {
     // recursivly run through left sub tree
         return findNode(node.left, accountName);

     // recursivly run through right sub tree
     } else if (cmp > 0) {
         return findNode(node.right, accountName);
      
     // node is returned once recursive iteration is completed and cmp = 0, i.e., it has found the correct node
     } else {
         return node;
     }
 }
 
/** insert post function to particular user 
 * @param accountName
 * @param fileName
 * @param description
 * @param likes
*/
public void insertPost(String accountName, String fileName, String description, String likes){
	Node account = findAccount(accountName);
	Post post = new Post(accountName, fileName, description, likes);
	account.posts.add(post);
}

/** used to access the posts of particular user, this is used in other functionalities. 
 * @param name
 * @return the posts of a particular user
 */
public ArrayList<Post> getPosts(String name){
   // find the account, using findAccount() method, that we want to add the post to
   Node account = findAccount(name);
   //i found that a continous error would be an issue, so use a try,catch statement to return the posts of that account
   try{
      return account.posts;
   }catch (Exception e){
      System.out.println("User not found "+e);
      return new ArrayList<Post>();
   }
}

/** can be used to replace displayPost, of Node.
 * prints out all the posts of a given account, using getPosts() function
 * @param accountName
 * @return posts of an account
 */
public String printAccountPosts(String accountName){
   //make a new array list of the posts of the particular user.
   ArrayList<Post> posts = getPosts(accountName);
   //new string to concatenate the filename to
   String postList = "";
        for (int i = 0; i <= posts.size()-1; i++) {
            postList += posts.get(i).getFileName() + "\n";
        }

        return postList;
}


/** 
 * @param accountName
 * @return String
 */
public String printPostDescription(String accountName){
   //make a new array list of the posts of the particular user.
   ArrayList<Post> posts = getPosts(accountName);
   //new string to concatenate the filename to
   String postList = "";
        for (int i = 0; i <= posts.size()-1; i++) {
            postList += posts.get(i).getDescription() + "\n";
        }

        return postList;
}


   
/** recursive delete method
 * @param name
 */
public void delete(String name){
      if (name != null){
         root = delete(root, name);
      }
  }

  /** recursvie delete method, using findMin().
 * @param node
 * @param name
 * @return the node that has been deleted
 */
private Node delete(Node node, String name){
      if (node == null){
         return null;
      }
      // boolean value used to compare string names.
      int cmp = name.compareTo(node.getName());
      //recursivly run through left tree
      if (cmp < 0){
         node.left = delete(node.left, name);
      }
      //run through right tree
      else if (cmp > 0){
         node.right = delete(node.right, name);
      }
      //node has been found
      else {
         //do they have any children
         if (node.left != null && node.right!=null){
         node = node.left;
         }
         
         else if(node.left == null){
            node = node.right;
         }
         else if(node.right ==null){
            node = node.left;
         }
         else{
            Node minimum = findMin(node.right);
            node.accountName = minimum.accountName;
            node.profileDescription = minimum.profileDescription;
            node.right = delete(node.right, minimum.accountName);
         }
      }

      return node;
  }

  /** used to find the left most child
 * @param node
 * @return the left most child
 */
public Node findMin(Node node){
      while(node.left != null){
         node = node.left;
      }
      return node;
  }


 /**
 * @return getHeight() recursive method
 */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   /**
    * @param node
    * @return height of tree
    */
   public int getHeight ( Node node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   /**
    * @return method of getSize() of tree
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   /**
    * @param node
    * @return size of tree
    */
   public int getSize ( Node node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
    * @param node
    */
   public void visit (Node node)
   {
      System.out.println(node.getName());
   }
   /**
    * 
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   /**
    * @param node
    */
   public void preOrder (Node node)
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   /**
    * 
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   /**
    * @param node
    */
   public void postOrder (Node node)
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   /**
    * 
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   /**
    * @param node
    */
   public void inOrder (Node node)
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
}

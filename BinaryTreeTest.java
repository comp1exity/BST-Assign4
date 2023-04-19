// Nicolas Wise
// 17 April 2023
// WSXNIC001
import java.util.*;

/***
 * @author wsxnic001
 */

public class BinaryTreeTest
{
  static Scanner scan = new Scanner(System.in);
  static BinarySearchTree bt = new BinarySearchTree();

   public static void main ( String [] args )
   {
    System.out.println("-----Insert Account Test-----");
    TestTreeInsertion();
    System.out.println("Accounts have been inserted");

    System.out.println("-----Find Account Test-----");
    TestFindAccountDescription();

    System.out.println("-----Post Insertion Test-----");
    TestPostInsertion();

    System.out.println("-----Height & Size Test-----");
    System.out.println ("Height : " + bt.getHeight ());
    System.out.println ("Size : " + bt.getSize ());

    System.out.println("-----Traversal Testing-----");
    System.out.println("-----InOrder Testing-----");
    bt.inOrder ();

    System.out.println("-----PreOrder Testing-----");
    bt.preOrder ();

    System.out.println("-----PostOrder Testing-----");
    bt.postOrder ();
    
    System.out.println("-----Deletion Test-----");
    TestDeletion();
    System.out.println("-----Traversal Testing After Deletion-----");
    System.out.println("-----InOrder Testing-----");
    bt.inOrder ();

    System.out.println("-----PreOrder Testing-----");
    bt.preOrder ();

    System.out.println("-----PostOrder Testing-----");
    bt.postOrder ();


   }

 
   /**test account insertion  
    * 
    */ 
   private static void TestTreeInsertion(){
    bt.insert("Nic", "is a top g");
    System.out.println(bt.findAccount("Nic").accountName + "'s account added");
    bt.insert("Sam", "is a bottom g");
    System.out.println(bt.findAccount("Sam").accountName + "'s account added");
    bt.insert("Sarah", "like dominos");
    System.out.println(bt.findAccount("Sarah").accountName + "'s account added");
    bt.insert("Gareth", "is a sailor");
    System.out.println(bt.findAccount("Gareth").accountName + "'s account added");
    bt.insert("Matthew", "attends university");
    System.out.println(bt.findAccount("Matthew").accountName + "'s account added");
  }
  
  /**printing out the name and description for each profile.  
    * null is printed in the case that an account can't be found
    */
  private static void TestFindAccountDescription(){
    System.out.println(bt.findAccount("Nic").accountName + " " + bt.findAccount("Nic").profileDescription);
    System.out.println(bt.findAccount("Sam").accountName + " " + bt.findAccount("Sam").profileDescription);
    System.out.println(bt.findAccount("Sarah").accountName + " " + bt.findAccount("Sarah").profileDescription);
    System.out.println(bt.findAccount("Gareth").accountName + " " + bt.findAccount("Gareth").profileDescription);
    System.out.println(bt.findAccount("Matthew").accountName + " " + bt.findAccount("Matthew").profileDescription);
    System.out.println(bt.findAccount("Joshua"));
  }

  /**
   * deletion method testing
   */
  private static void TestDeletion(){
    bt.delete("Sarah");
    bt.delete("Nic");
    
    System.out.println(" ");
    System.out.println("Accounts deleted");
  }

  /** testing the insertion of a post, also tests printAccountPosts() & getPosts()
   * 
   */
  private static void TestPostInsertion(){
    //nic has one post
    System.out.println("Nic's Posts: ");
    bt.insertPost("Nic", "video1.mpg", "nic's graduation", "100");
    System.out.println(bt.printAccountPosts("Nic"));

    //sam has more than one post
    System.out.println("Sam's Posts: ");
    bt.insertPost("Sam", "video2.mpg", "five a side footy festival", "1");
    bt.insertPost("Sam", "video3.mpg", "surfing at Llundudno", "55");
    System.out.println(bt.printAccountPosts("Sam"));

    System.out.println("Sarah's Posts: ");
    bt.insertPost("Sarah", "video44.mpg", "sarah's first day at school", "1");
    bt.insertPost("Sarah", "video66.mpg", "a day at the dair", "55");
    System.out.println(bt.printAccountPosts("Sarah"));
  }
}

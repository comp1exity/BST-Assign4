//Nicolas Wise
//10 April 2023
//WSXNIC001
//each node is an account

import java.util.ArrayList;
/***
 * @author wsxnic001
 */
public class Node{
	
    public String accountName;
    public String profileDescription;

    public ArrayList<Post> posts = new ArrayList<Post>();

    public Node left;
    public Node right;
 
 
    public Node(String n, String d){
         this.accountName = n;
         this.profileDescription = d;
         this.posts = new ArrayList<Post>();
    }

    /**
     * 
     */
    public void displayPost(){
        for (int i = this.posts.size() -1; i>=0; i--){
            System.out.println(this.posts.get(i).toString());
        }
    }
    /**
     * @return name of account
     */
    public String getName(){
        return accountName;
    }
    /**
     * @return description of account
     */
    public String getDescription(){
        return profileDescription;
    }
    /**
     * @return node to the left
     */
    public Node getLeft(){
        return left;
    }
    /**
     * @return node to the right
     */
    public Node getRight(){
        return right;
    }
    //add post
    /**
     * @param posts
     */
    public void addPost(Post posts){
        this.posts.add(posts);
    }
    
    /**
     * 
     */
    @Override
    public String toString(){
        String string = "";
        for (Post post : posts){
            string = post.getFileName() + "\n";
        }

        return string;
    }
}
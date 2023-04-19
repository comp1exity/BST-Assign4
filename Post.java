//Nicolas Wise
//10 April 2023
//WSXNIC001

/***
 * @author wsxnic001
 */
public class Post{
	
	private String accountName;
	private String fileName;
	private String description;
	private String likes;
	
	/**
	 * @param accountName
	 * @param fileName
	 * @param description
	 * @param likes
	 */
	public Post(String accountName,String fileName, String description, String likes){
		this.accountName = accountName;
		this.description = description;
		this.fileName = fileName;
		this.likes = likes;
	}
	/**account name getter method
	 * @return account name
	 */
	public String getAccountName(){
		return accountName;
	}
	/**file name getter method
	 * @return file name
	 */
	public String getFileName(){
		return fileName;
	}
	/** description getter method
	 * @return video description
	 */
	public String getDescription(){
		return description;
	}
	/**likes getter method
	 * @return number of likes
	 */
	public String getNumberOfLikes(){
		return likes;
	}

	
}

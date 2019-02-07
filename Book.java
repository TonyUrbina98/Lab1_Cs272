package Lab1;
/**
 * 
 * @author Tony Urbina
 * @since 1/25/19
 *  
 */

public class Book implements Cloneable{

//instance variables
   private String BookTitle;
   private int NumberOfAuthors;
   private String [] Authors = new String[3];
   private String ISBN;

/**
 * @param none
 * @return none
 * @note: the non argument constructor of the function book   
 */
   
   public Book (){
   BookTitle = null;
   ISBN = null;
   NumberOfAuthors = 0;
   Authors = new String[3];
   }//end of constructor

   
 /**
  * @param _Title
  * @return none
  * @note this is a constructor with an argument
  */
   public Book(String _Title){
   BookTitle = _Title;
   ISBN = null;
   NumberOfAuthors = 0;
   Authors = new String[3];
   }//end of constructor 2

   
 /**
  * @param obj
  * @return none
  * @note this is a copy constructor 
  */
   public Book(Object obj){
	   if(obj != null) {
		   if(obj instanceof Book) {
			   Book ref = (Book)obj;
			   BookTitle = ref.getTitle();
			   ISBN = ref.getISBN();
			   NumberOfAuthors = ref.getAuthorNumber();
			   for(int i = 0; i < ref.getAuthorNumber(); i++) {
				   Authors[i]= ref.Authors[i];
			   }//end for loop
		   }//end if
	   }//end if
   }//end of copy constructor

/**
 * @param none
 * @return BookTitle 
 * @note this is an accessor method
 */
   
   public String getTitle(){
      return BookTitle;
   }

/**
 * @param none
 * @return NumberOfAuthor
 * @Note this is the accessor method
 */
   public int getAuthorNumber(){
	   return NumberOfAuthors;
   }
 
 /**
  * @param none
  * @return ISBN
  * @Note this is an accessor method
  */
   public String getISBN(){
	   return ISBN;
   }
   
 /**
  * @param _title
  * @return none
  * @note this is a mutator that sets BookTitle to _title
  */
   public void setTitle(String _title){
	   BookTitle = _title;
   }
   
 /**
  * @param _isbn
  * @return none
  * @note this is a mutator that sets ISBN to _isbn
  */
   public void setISBN(String _isbn){
	   ISBN = _isbn;
   }
   
 /**
  * @param _author
  * @return A Boolean  
  * @note This is supposed to check if there's enough space to add an author and increase the author number
  */
   public boolean addAuthor(String _author){
	   int count= 0;
	   for(int i = 0; i < 3; i++) {
		   if(Authors[i] != null) {
			   count++;
		   }//end if
	   }// end of for loop
		  if(count < 3) {
			  Authors[count] = _author;
			  NumberOfAuthors = count + 1;
			  return true;
		  }//end if
		  else {
	      return false;
      }//end else
   }//end of method
  
	
 /**
  * @param obj
  * @return A boolean
  * @note This is to check if the book's ISBN is equal to each other.
  */
   public boolean equals(Object obj){
	   if(obj instanceof Book){
	   Book canidate = (Book) obj;
	   return (canidate.getISBN() == ISBN);
	   }//end if
	   else
	      return false;
   }//end of equals method
	
   
 /**
  * 
  * @param b1
  * @param b2
  * @return String array
  * @note this is supposed to go through the array of both books
  *       and get the different authors on each book
  */
   public static String[] getALLAuthors(Book b1, Book b2){
	   
	   String ListOfAuthors[] = new String [6];
	   
	   if(b1 == null || b2 == null) {
		   throw new NullPointerException("Error b1 Or b2 are null");
	   }//end of exception
	   
	   for(int i = 0; i < b1.getAuthorNumber(); i++) {
	          for(int x = 0; x < b2.getAuthorNumber(); x++) {
		         if (b1.Authors[i].equals(b2.Authors[i])){
			     ListOfAuthors[x] = b1.Authors[x];
		         }//end if
		         else {
		        	 ListOfAuthors[i] = b1.Authors[i];
		        	 ListOfAuthors[ListOfAuthors.length - x - 1] = b2.Authors[x];
		         }//end else
	          }//end for loop x
	      }//end for loop i
	   return ListOfAuthors;
   }//end of getAllAuthors method

   
 /**
  *@param None
  *@return a String of data
  *@note this is a toString method that formats the data.
  */
   public String toString(){
       String temp = "";
       temp = Authors[0] + ", " + Authors[1] + ", " + Authors[2];
	   return "Title: " + BookTitle + "," + " ISBN: " + ISBN + "," + 
	          " Number of authors: " + NumberOfAuthors + "," + 
	          " list of authors: " + temp;
   }//end of toString method
	
   
 /**
  * @note this is the main where
  * we test the function methods
  */
public static void main(String [] args) {
	//Instantiate a new book object
	Book Book1 = new Book("Lab1 Cs272");
	
	//setting the ISBN
	Book1.setISBN("272");
	
	//testing the addAuthor method
	Book1.addAuthor("Tony");
	Book1.addAuthor("Jackson");
    Book1.addAuthor("Madison");

    //printing the author number
	System.out.println("There are " + Book1.getAuthorNumber() + " Authors.");
	
	System.out.println();//blank line
	
	//copy constructor test using Book2 object
	Book Book2 = new Book(Book1);
	
	System.out.println();//blank line
	
	//test the equals method
	System.out.println("If Book1 and Book2 are equal: " + Book1.equals(Book2));
	
	System.out.println();//blank line
	
	//test the toString method
	System.out.println(Book1.toString() + "\n" + Book2.toString());
	
	System.out.println();//blank line
	
	//testing the getAuthors method using an array to deploy all the elements
	for(int q = 0; q < 6; q++) {
	System.out.println(getALLAuthors(Book1, Book2)[q]);
	}//end for
	
	//Test with new Book Object using a default constructor
	Book Book3 = new Book();
	
	//setting the title for Book3
	Book3.setTitle("This is a Test");
	
	//setting the ISBN for Book3
	Book3.setISBN("278");
	
	System.out.println();//blank line
	
	//Adding the Authors to Book3
	Book3.addAuthor("Joe");
	Book3.addAuthor("Kenny");
	Book3.addAuthor("Cheng");
	
	System.out.println();//blank line
	
	//Getting the number of authors in Book3
	System.out.println("There are " + Book3.getAuthorNumber() + " Authors.");
	
	System.out.println();//blank line
	
	//Testing the equals method for Book1 and Book3
	System.out.println("Is Book1 equal to Book3: " + Book1.equals(Book3));
	
	System.out.println();//blank line
	
	//Testing the toString method
	System.out.println(Book1.toString() + "\n" + Book3.toString());
	
	System.out.println();// blank line
	
	//testing the getAuthors method using a string to deploy all the elements in the array
	for(int j = 0; j < 6; j++) {
	System.out.println(getALLAuthors(Book1, Book3)[j]);
	}//end of for
	
   }//end main
}//end class

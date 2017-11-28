public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    //Field Variable for LibraryBook
    public String callNumber;
    
    //Constructor for LibraryBook
    public LibraryBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN);
	this.callNumber = callNumber;
    }

    //Getters for LibraryBook
    public String getCallNumber(){
	return callNumber;
    }

    //Setters for LibraryBook
    public void setCallNumber(String newCallNumber){
	callNumber = newCallNumber;
    }
    
    public abstract void checkout(String patron, String due);

    public abstract void returned();

    public abstract String circulationStatus();

    //compareTo method for Comparable Interface
    public int compareTo(LibraryBook other){
	return this.getCallNumber().compareTo(other.getCallNumber());
    }

    //toString method
    public String toString(){
	return super.toString() + "\nCall Number: " + callNumber;
    }
}

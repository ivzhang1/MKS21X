public class Book{

    //Field Variables for Book
    public String author, title, ISBN;

    //Constructors for Book
    public Book(){

    }
    public Book(String author, String title, String ISBN){
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    //Getters for Book
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }

    //Setters for Book
    public void setAuthor(String author){
	this.author = author;
    }
    public void setTitle(String title){
	this.title = title;
    }
    public void setISBN(String ISBN){
	this.ISBN = ISBN;
    }

    //toString method
    public String toString(){
	return "Author: " + author + "\nTitle: " + title + "\nISBN: " + ISBN;
    }
}

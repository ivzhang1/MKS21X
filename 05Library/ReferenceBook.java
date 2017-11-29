public class ReferenceBook extends LibraryBook{

  //Field Variables for ReferenceBook
  private String collection;

  //Constructor for ReferenceBook
  public ReferenceBook(String author, String title, String ISBN, String callNumber, String collection){
    super(author, title, ISBN, callNumber);
    this.collection = collection;
  }

  //Getter for ReferenceBook
  public String getCollection(){
    return collection;
  }

  //Setter for ReferenceBook
  public void setCollection(String collection){
    this.collection = collection;
  }

  //Methods
  public void checkout(String patron, String due){
    throw new UnsupportedOperationException(patron + ", cannot check out a reference book");
  }

  public void returned(){
    throw new IllegalStateException("Impossible");
  }

  public String circulationStatus(){
    return "non-circulating reference book";
  }

  public String toString(){
    return super.toString() + "\nCollection Info: " + collection;
  }

}

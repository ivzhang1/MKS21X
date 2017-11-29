public class CirculatingBook extends LibraryBook{
  //Field Variables of CirculatingBook
  public String currentHolder, dueDate;

  //Constructor
  public CirculatingBook(String author, String title, String ISBN, String callNumber){
    super(author, title, ISBN, callNumber);
  }

  //Getters
  public String getCurrentHolder(){
    return currentHolder;
  }
  public String getDueDate(){
    return dueDate;
  }

  //Setters
  public void setCurrentHolder(String newHolder){
    currentHolder = newHolder;
  }
  public void setDueDate(String newDate){
    dueDate = newDate;
  }

  //Methods
  public void checkout(String patron, String due){
    this.setCurrentHolder(patron);
    this.setDueDate(due);
  }

  public void returned(){
    this.setCurrentHolder(null);
    this.setDueDate(null);
  }

  public String circulationStatus(){
    if (currentHolder != null || dueDate != null){
      return "Book is held by " + currentHolder + " due on " + dueDate;
    }
    return "Book is available on the shelves";
  }

  public String toString(){
    return super.toString() + "\nCurrent Holder: " + currentHolder + "\nDue Date: " + dueDate;
  }

}

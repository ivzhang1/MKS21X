import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.lang.Math.*; //Random

public class WordSearch{
  public static void main(String[] args){
    int row = 0;
    int col = 0;
    int randSeed = (int)(Math.random() * 1000000);
    boolean key = false;
    WordSearch WordGrid;
    if (args.length > 2){
      try{
        row = Integer.parseInt(args[0]);
        col = Integer.parseInt(args[1]);       
      }catch(NumberFormatException e){
        System.out.println("Please enter the first two parameters (" + args[0] + ", " + args[1] + ") as Integers");
        System.exit(1);
      }
      if (row < 0 || col < 0) {
        System.out.println("Enter a non-negative row (" + row + ") or column (" + col + ") number!");
        System.exit(1);
      }
      if (args.length > 3){
        
        try {
          randSeed = Integer.parseInt(args[3]);
        } catch(NumberFormatException e){
          System.out.println("Random Seed (" + args[3] + ") should be an Integer");
          System.exit(1);
        }

        if (args.length == 5){
          if (args[4].equals("key")){
            key = true;
          }
        }
        if (args.length > 5){
          System.out.println("WOAH SLOW DOWN THERE BUDDY TOO MANY ARGUMENTS (Row, Col, File Name, Seed, Answers)");
          System.exit(1);
        }
        
        WordGrid = new WordSearch(row, col, args[2], randSeed);
      }
      else {
        WordGrid = new WordSearch(row, col, args[2]);
      }
      System.out.println("Le Puzzle: \n" + WordGrid.viewPuzzle() + "Your seed is: " + WordGrid.viewSeed() + "Find these Words: \n" + WordGrid.viewList());
      if (key){
        System.out.println(WordGrid.viewKey());
      }
    }
    
    else{
      System.out.println("In order to run WordSeach please enter the parameters in the following format: \n" +
                         "* java Driver [rows cols filename [randomSeed [answers]]]");
    }


  }
  private char[][]data;
  
  //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
  private ArrayList<String> wordsToAdd;

  //all words that were successfully added get moved into wordsAdded.
  private ArrayList<String> wordsAdded;

  //a random Object to unify your random calls
  private Random randgen;
  private int seed;
  private char[][] key;

  /**Initialize the grid to the size specified 

   *fill all of the positions with '_'
   *@param row is the starting height of the WordSearch
   *@param col is the starting width of the WordSearch
   */
  private WordSearch(int rows,int cols){
    data = new char[rows][cols];
    for (int r = 0; r < rows; r++){
	    for (int c = 0; c < cols; c++){
        data[r][c] = '_';
	    }
    }
  }

  public WordSearch( int rows, int cols, String fileName){
    this(rows, cols, fileName, (int)(Math.random() * 1000000000));


    
  }

  public WordSearch( int rows, int cols, String fileName, int randSeed){
    this(rows,cols);
    
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    randgen = new Random(randSeed);
    seed = randSeed;
    
    try{
      Scanner words = new Scanner(new File(fileName));
      while(words.hasNext()){
        wordsToAdd.add(words.next().toUpperCase());
      }
    }catch(FileNotFoundException e){
      System.out.println("File Not Found");
      System.exit(1);
    }
    this.addAllWords();
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear(){
    for (int r = 0; r < data.length; r++){
	    for (int c = 0; c < data[r].length; c++){
        data[r][c] = '_';
	    }
    }	
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from left to right, must fit on the WordGrid, and must
   *have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical location of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   * or there are overlapping letters that do not match, then false is returned 

   * and the board is NOT modified.

   */
  public boolean addWordHorizontal(String word,int row, int col){
    int indexStr = 0;
    char[] newLine = new char[data[row].length];
	
    if (col < 0 || row < 0 || col >= data[row].length || row >= data.length || Math.abs(data[row].length - col) <  word.length()){
	    return false;
    }
    
    for (int c = 0; c < data[row].length; c++){
      if (c >= col && c < col + word.length()){
        if (data[row][c] == '_' || data[row][c] == word.charAt(indexStr)){
          newLine[c] = word.charAt(indexStr);
          indexStr++;
        }
        else{
          return false;
        }
      }
	    else{
        newLine[c] = data[row][c];
      }
    }
    data[row] = newLine;
    return true;
  }


  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from top to bottom, must fit on the WordGrid, and must
   *have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   *or there are overlapping letters that do not match, then false is returned.
   *and the board is NOT modified.

   */
  public boolean addWordVertical(String word,int row, int col){
    int indexStr = 0;
    char[][] newData = data;
	
    if (col < 0 || row < 0 || col >= data[row].length || row >= data.length ||  data.length - row <  word.length()){
	    return false;
    }

    for (int r = 0; r < data.length; r++){
      if (r >= row && r < row + word.length()){
        if (data[r][col] == '_' || data[r][col] == word.charAt(indexStr)){
          newData[r][col] = word.charAt(indexStr);
          indexStr++;
        }
        else{
          return false;
        }
      }
    }
    data = newData;
    return true;
  }
  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from top left to bottom right, must fit on the WordGrid,
   *and must have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   *or there are overlapping letters that do not match, then false is returned.
   */
  public boolean addWordDiagonal(String word,int row, int col){
    if (col < 0 || row < 0 || col >= data[row].length || row >= data.length ||  data.length - row <  word.length() ||  data[row].length - col <  word.length()){
	    return false;
    }
    char[][] newData = data;
    int indexStr = 0;
    int column = col;
    
    for (int r = 0; r < data.length; r++){
      if (r >= row && r < row + word.length() && column >= col && column < col + word.length()){

        if (data[r][column] == '_' || data[r][column] == word.charAt(indexStr)){
          newData[r][column] = word.charAt(indexStr);
          indexStr++;
          column++;
        }
        else{
          return false;
        }
      }
    }
    data = newData;
    return true;
  }

  private static char[][] copy(char[][] ary1){
    char[][] newData = new char[ary1.length][ary1[0].length];
    for (int r = 0; r < ary1.length; r ++){
      for (int c = 0; c < ary1[r].length; c++){
        newData[r][c] = ary1[r][c];
      }
    }
    return newData;
  }
  private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement){
    char[][] newData = copy(data);
    int indexStr = 0;
    
    if (rowIncrement == colIncrement && rowIncrement == 0){
      return false;
    }
    
    else{
      if (this.checkCases(r, c, rowIncrement, colIncrement, word)){
        while (indexStr != word.length()){

          if (r < 0 || c < 0 || r >= data.length || c >= data[0].length){
            return false;
          } else if (data[r][c] == '_' || data[r][c] == word.charAt(indexStr)){
            newData[r][c] = word.charAt(indexStr);
            r += colIncrement;
            c += rowIncrement;
            indexStr++;
          }     
          else{

            return false;
          }
        }
        data = newData;
        wordsAdded.add(word);
        wordsToAdd.remove(word);
        return true;
        }
      else{
        return false;
      }
    }
  }

  private boolean checkCases(int row, int col, int rowIncrement, int colIncrement, String word){
    if (rowIncrement == 0){
      return checkCol(row, col, word);
    } else if (colIncrement == 0){
      return checkRow(row, col, word);
    }
    else {

      return checkRow(row, col, word) && checkCol(row,col,word);
    }
  }
  
  private boolean checkRow(int row, int col, String word){
    if (col < 0 || row < 0 || col >= data[row].length || row >= data.length || (data[row].length - col <  word.length() && col < word.length() - 1 )){
	    return false;
    }
    return true;
  }
  private boolean checkCol(int row, int col, String word){
    if (col < 0 || row < 0 || col >= data[row].length || row >= data.length || (data.length - row <  word.length() && row < word.length() - 1 )){
	    return false;
    }
    return true;
  }



  private void addRandomLetters(){
    char[][] newData = copy(data);

    for (int r = 0; r < newData.length; r++){
      for (int c = 0; c < newData[r].length; c ++){
        if (newData[r][c] == '_'){
          newData[r][c] = (char) (65 + randgen.nextInt(26));
        }
      }
    }
    data = newData;
  }
  
  private boolean addAllWords(){
    if (data.length == 0 || data[0].length == 0){
      return true;
    } 
    ArrayList<String> oldWords  = new ArrayList<String>(wordsToAdd);
    String word = "";
    int randomRow = randgen.nextInt(data.length);
    int randomCol = randgen.nextInt(data[0].length);
    int randRowInc = randgen.nextInt(3) - 1;
    int randColInc = randgen.nextInt(3) - 1;
    int times = 0;

    for (int i = 0; i < oldWords.size(); i ++){

      times = 0;
      word = wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));      

      
      if (word.length() <= data.length || word.length() <= data[0].length){
        while ((!this.addWord(randomRow, randomCol, word, randRowInc, randColInc)) && times < 10000){
          randomRow = randgen.nextInt(data.length);
          randomCol = randgen.nextInt(data[0].length);

          randRowInc = randgen.nextInt(3) - 1;
          randColInc = randgen.nextInt(3) - 1;
          times++;
        }
      }
    }
    key = data;
    this.addRandomLetters();
    return true;
  }


  /**The proper formatting for a WordGrid is created in the toString.
   *@return a String with each character separated by spaces, and rows
   *separated by newlines.
   */
  public String toString(){
    String grid = "";
    for (int r = 0; r < data.length; r++){
	    for (int c = 0; c < data[r].length; c++){
        grid += " " + data[r][c];
	    }
	    grid += "\n";
    }
    return grid + "\n" + "Your seed is: " + seed;
  }

  public String viewPuzzle(){
    String grid = "";
    for (int r = 0; r < data.length; r++){
	    for (int c = 0; c < data[r].length; c++){
        grid += " " + data[r][c];
	    }
	    grid += "\n";
    }
    return grid + "\n";   
  }

  public String viewList(){
    String words = "";
    int count = 0;
    
    for (int i = 0; i < wordsAdded.size(); i++){
      if (count == 3){
        words += "\n";
        count = 0;
      }
      count++;
      words += wordsAdded.get(i) + "\t";
    }
    return words + "\n";
  }

  public String viewKey(){
    String grid = "The Key to the Future: \n";
    for (int r = 0; r < key.length; r++){
	    for (int c = 0; c < key[r].length; c++){
        grid += " " + key[r][c];
	    }
	    grid += "\n";
    }
    return grid + "\n";
  }

  public String viewSeed(){
    return "" + seed + "\n";
  }
}
  

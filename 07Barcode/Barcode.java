import java.util.*;
public class Barcode implements Comparable<Barcode>{

  //Field Variables for Barcode
  private String _zip;

  //Constructor for Barcode
  /**Constructs a Barcode Object
   *@param ZIP is the String of the ZIP code made for the barcode
   */
  public Barcode(String ZIP){
    checkZIP(ZIP);
   _zip = ZIP;
  }

  //Checker
  /**Checks to make sure the ZIP code is valid and return it if valid
   *@param ZIP is the ZIP code to be checked
   */
  public static void checkZIP(String ZIP){
    if (ZIP.length() != 5){
      throw new IllegalArgumentException();
    }
    try{
      Integer.parseInt(ZIP);
    }catch(NumberFormatException e){
      throw new IllegalArgumentException();
    }
  }

  //Getters
  /**Gets the ZIP*/
  public String getZip(){
    return _zip;
  }

  /**Gets the Barcode*/
  public String getCode(){
    return this.toCode(_zip);
  }

  //Other Methods
  /**Returns true if the two Barcodes are equal, else false
   *@param otherBarcode is the Barcode that is compared with
   */
  public boolean equals(Barcode otherBarcode){
    return this.getCode().equals(otherBarcode.getCode());
  }

  //compareTo for the Comparable Interface
  /**Returns a negative number if the Barcode being compared is less than the Barcode it is compared to
   *@param otherBarcode is the other Barcode that is compared
   */
  public int compareTo(Barcode otherBarcode){
    return this.getZip().compareTo(otherBarcode.getZip());
  }

  //To make the Barcode
  /**Returns the barcode representation give the digit(0-9)
   *@param digit is the char of the digit to be converted to barcode
   */
  private static String digitToCode(char digit){
    int number = digit - 48; //Converts the char (i.e. '1') to its decimal representation

    String[] codes = {"||:::", //0
                      ":::||", //1
                      "::|:|", //2
                      "::||:", //3
                      ":|::|", //4
                      ":|:|:", //5
                      ":||::", //6
                      "|:::|", //7
                      "|::|:", //8
                      "|:|::" }; //9
    return codes[number];
  }

  /**Returns the entire Barcode
   *@param ZIP is the String ZIP code to be converted to Barcode
   */
  public static String toCode(String ZIP){
    String completeBarcode = "|";
    int sum = 0;
    char charNum = 0;
    checkZIP(ZIP);
    for (int i = 0; i < ZIP.length(); i++){
      charNum = ZIP.charAt(i);
      completeBarcode += digitToCode(charNum);
      sum +=  charNum - 48;
    }
    completeBarcode += "" + digitToCode( (char) (sum % 10 + 48)) + "|";
    return completeBarcode;
  }

  /**Finds the value of the code
   *@param code is the 5 part code value
   */
  public static int findValue(String code){
    String[] codes = {"||:::", //0
                      ":::||", //1
                      "::|:|", //2
                      "::||:", //3
                      ":|::|", //4
                      ":|:|:", //5
                      ":||::", //6
                      "|:::|", //7
                      "|::|:", //8
                      "|:|::" }; //9
    for (int i = 0; i < codes.length; i++){
      if (codes[i].equals(code)){
        return i;
      }
    }
    return -1;
  }

  /**Returns the ZIP code
   *@param code to be converted
   */
  public static String toZip(String code){
    //Checks the length of the code
    if(code.length() != 32 || (code.charAt(0) != '|' || code.charAt(code.length()-1) != '|')){
      throw new IllegalArgumentException();
    }
    int sum = 0;

    String barcode = code.substring(1,code.length()-1); //removes ending two |
    String portion = "";
    String zip = "";
    int value;

    for (int i = 0; i < 6; i++){
      portion = barcode.substring(i * 5, i * 5 + 5);

      value = findValue(portion);
      if (i == 5){
        if (value != sum % 10){ //Checks for check sum
          throw new IllegalArgumentException();
        }
      }
      else{
        if (value == -1){ //Only when non-barcode chars are used, digit seq not a valid number
          throw new IllegalArgumentException();
        }
        else{
          zip += "" + value;
          sum += value;
          value = 0;
        }

      }
    }
    return zip;
  }



  /**Returns a String in the form "BARCODE (ZIP CODE)"*/
  public String toString(){
    return this.getCode() + " " + "(" + this.getZip() + ")";
  }
}

public class Barcode implements Comparable<Barcode>{
  //Main testing method
  public static void main(String[] args){
    //Barcode a = new Barcode("11245");
    //Barcode b = new Barcode("38760");
    //Barcode c = new Barcode("11245");
    //Barcode d = new Barcode("00294");
    //System.out.println(a.getZIP());//11245
    //System.out.println(d.getZIP());//00234
    //System.out.println(a.getBarcode());// |:::||:::||::|:|:|::|:|:|:::||:|
    //System.out.println(a.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    //System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
    //System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    //System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
    //System.out.println(a.compareTo(b));// negative
    //System.out.println(a.compareTo(c));// 0
    //System.out.println(a.compareTo(d));// positive
    //System.out.println(a.equals(b));// false
    //System.out.println(a.equals(c));// true
    //System.out.println(a.equals(d));// false
  }

  //Field Variables for Barcode
  private String ZIP;

  //Constructor for Barcode
  /**Constructs a Barcode Object
   *@param ZIP is the String of the ZIP code made for the barcode
   */
  public Barcode(String ZIP){
    this.ZIP = ZIP;
  }

  //Getters
  /**Gets the ZIP*/
  public String getZIP(){
    return ZIP;
  }

  /**Gets the Barcode*/
  public String getBarcode(){
    return this.zipToCode(ZIP);
  }

  //Other Methods
  /**Returns true if the two Barcodes are equal, else false
   *@param otherBarcode is the Barcode that is compared with
   */
  public boolean equals(Barcode otherBarcode){
    return this.getBarcode().equals(otherBarcode.getBarcode());
  }

  //compareTo for the Comparable Interface
  /**Returns a negative number if the Barcode being compared is less than the Barcode it is compared to
   *@param otherBarcode is the other Barcode that is compared
   */
  public int compareTo(Barcode otherBarcode){
    return this.getZIP().compareTo(otherBarcode.getZIP());
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
  private String zipToCode(String ZIP){
    String completeBarcode = "|";
    int sum = 0;
    char charNum = 0;
    for (int i = 0; i < ZIP.length(); i++){
      charNum = ZIP.charAt(i);
      completeBarcode += digitToCode(charNum);
      sum +=  charNum - 48;
    }
    completeBarcode += "" + digitToCode( (char) (sum % 10 + 48)) + "|";
    return completeBarcode;
  }



  /**Returns a String in the form "BARCODE (ZIP CODE)"*/
  public String toString(){
    return this.getBarcode() + " " + "(" + this.getZIP() + ")";
  }
}

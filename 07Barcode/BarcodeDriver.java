public class BarcodeDriver{
  //Main testing method
  public static void main(String[] args){
    Barcode a = new Barcode("11245");
    Barcode b = new Barcode("38760");
    Barcode c = new Barcode("11245");
    Barcode d = new Barcode("00294");
    Barcode ref = new Barcode("92010");

    Barcode stuy = new Barcode("10282");
    Barcode btech = new Barcode("11217");
    Barcode stech = new Barcode("10306");

    Barcode[] listOfBarcodes = {stuy, btech, stech};

    for (int i = 0; i < listOfBarcodes.length; i++){
      Barcode current = listOfBarcodes[i];
      System.out.println(current + "\ntoZip result: "
                         + Barcode.toZip(current.getCode())
                         +"\nCorrect? "
                         + Barcode.toZip(current.getCode()).equals(current.getZip())
                         );
    }

    System.out.println(ref);

    System.out.println(a.getZip());//11245
    System.out.println(d.getZip());//00234
    System.out.println(a.getCode());// |:::||:::||::|:|:|::|:|:|:::||:|
    System.out.println(a.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
    System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
    System.out.println(a.compareTo(b));// negative
    System.out.println(a.compareTo(c));// 0
    System.out.println(a.compareTo(d));// positive
    System.out.println(a.equals(b));// false
    System.out.println(a.equals(c));// true
    System.out.println(a.equals(d));// false

    Barcode e = new Barcode("asdfd"); //Contains non-barcode characters, should throw IllegalArgumentException
    Barcode f = new Barcode("1234"); //Invalid length, should throw IllegalArgumentException

    //System.out.println(Barcode.toCode("00294")); // |||:::||:::::|:||:|:::|::|:|:|:|
    //System.out.println(Barcode.toCode("asdfd")); //Contains non-barcode characters, should throw IllegalArgumentException
    //System.out.println(Barcode.toCode("1234")); //Invalid length, should throw IllegalArgumentException

    //System.out.println(Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|:|")); //Should return 00294
    //System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||:")); //Invalid length, should throw IllegalArgumentException
    //System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||||")); //Incorrect checksum, should throw IllegalArgumentException
    //System.out.println(Barcode.toZip("|a::||:::||::|:|:|::|:|:|:::||:|")); //Contains non-barcode characters, should throw IllegalArgumentException
    //System.out.println(Barcode.toZip("::::||:::||::|:|:|::|:|:|:::||:|")); //First character is not '|', should throw IllegalArgumentException
    //System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||::")); //Last character is not '|', should throw IllegalArgumentException
    //System.out.println(Barcode.toZip("|::::::::||::|:|:|::|:|:|:::||:|")); //Invalid character sequence, should throw IllegalArgumentException

    // Barcode e = new Barcode("12sa1"); //Should throw an error, sa not valid nums
    // Barcode f = new Barcode("12312312"); //Should throw an error, too many nums
    // Barcode.toCode("131"); //Should throw an error, too little nums
    // Barcode.toCode("123dasda"); //Should throw an error, dasda are not valid #s
    // Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, Way too long
    // Barcode.toZip(":||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, should not end with :
    // Barcode.toZip(":||:::||:::::|:||:|:::|::|:||:::|"); //Should throw an error, checkSum incorrect
    // Barcode.toZip("|::::::|:::::|:||:|:::|::|:|:|::|"); //Should throw an error, ::::: found
  }
}

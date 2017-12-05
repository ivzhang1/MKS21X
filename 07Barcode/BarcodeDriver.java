public class BarcodeDriver{
  //Main testing method
  public static void main(String[] args){
    Barcode a = new Barcode("11245");
    Barcode b = new Barcode("38760");
    Barcode c = new Barcode("11245");
    Barcode d = new Barcode("00294");
    System.out.println(a.getZIP());//11245
    System.out.println(d.getZIP());//00234
    System.out.println(a.getBarcode());// |:::||:::||::|:|:|::|:|:|:::||:|
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
  }
}

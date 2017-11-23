public class ReverseCharSequenceDriver{
  
  public static void main(String[] args){
    ReverseCharSequence test = new ReverseCharSequence("ABCD");
    System.out.println(test);
    System.out.println(test.charAt(0));
    // System.out.println(test.charAt(-1));
    //System.out.println(test.charAt(4));
    System.out.println(test.length());
    System.out.println(test.subSequence(0,3));
    
  }
  
}

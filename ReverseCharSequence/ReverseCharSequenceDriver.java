public class ReverseCharSequenceDriver{
  
  public static void main(String[] args){   
    ReversedCharSequence a = new ReversedCharSequence("hello");
    System.out.println(a);
    System.out.println(a.length());
    System.out.println(a.charAt(3));
    System.out.println(a.subSequence(0,3));
  }
  
}

public class ReversedCharSequence implements CharSequence{

  private String charSequence;
  private String reverse;
    
  public ReversedCharSequence(String charSequence){
    this.charSequence = charSequence;
    reverse = "";
    for (int i = charSequence.length() - 1; i > -1; i--){
	    reverse += charSequence.charAt(i);
    }
  }

  public ReversedCharSequence(ReversedCharSequence other){
    this(other.toString());
  }

  private String toReverse(String reverseThis){
    String reversed = "";
    for (int i = reverseThis.length() - 1; i > -1; i--){
	    reversed += reverseThis.charAt(i);
    }
    return reversed;
  }
  public char charAt(int index){
    return reverse.charAt(index);
  }

  public int length(){
    return reverse.length();
  }

  public CharSequence subSequence(int start, int end){
    CharSequence sub = new ReversedCharSequence(this.toReverse(reverse.substring(start,end)));
    return sub;
  }

  public String toString(){
    return reverse;
  }
}

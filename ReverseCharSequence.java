public class ReverseCharSequence implements CharSequence{

    private String charSequence;
    private String reverse;
    
    public ReverseCharSequence(String charSequence){
	this.charSequence = charSequence;
	reverse = "";
	for (int i = charSequence.length() - 1; i > -1; i--){
	    reverse += charSequence.charAt(i);
	}
    }

    public char charAt(int index){
	return reverse.charAt(index);
    }

    public int length(){
	return reverse.length();
    }

    public CharSequence subSequence(int start, int end){
	CharSequence sub = new ReverseCharSequence(reverse.substring(start, end));
	return sub;
    }

    public String toString(){
	return reverse;
    }
}

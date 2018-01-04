public class OrderedSuperArray extends SuperArray{

    /*constructor initializes an empty List*/

    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int startingCapacity){
	super(startingCapacity);
    }
    public OrderedSuperArray(String[] ary){
	this(ary.length);
	for (int i = 0; i < ary.length ; i ++){
	    this.add(ary[i]);
	}
    }

    private String[] returnData(){
	String[] info = new String[size()];
	for (int i = 0; i < size(); i ++){
	    info[i] = this.get(i);
	}
	return info;
    }	
	
    /*call the proper add.*/
    public void add(int index, String value){
	add(value);
    }

    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
	String[] currentData = this.returnData();

	if (this.size() == 0){
	    super.add(0, value);
	}
	else{
	    //System.out.println(this.findIndexBinary(value));
	    super.add(this.findIndexBinary(value), value);
	}
	return  true;
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }
	

    private int indexOfBinary (String str){
	int start = 0;
	int end = size();
	String[] search = this.returnData();
	if (end == 1){
	    if (str.equals(search[0])){
		return 0;
	    }
	    else {
		return -1;
	    }
	}
	while (start != end){
	    if (str.equals(search[(start + end) / 2])){
		end = (start + end)/2;
		if (end != 0 && search[end - 1].equals(str)){
		    start = end - 1;
		}
		else{
		    return start;
		}
	    } else if (str.compareTo(search[(start + end) / 2]) > 0){
		start = (start + end) / 2;
	    }
	    else{
		end = (start + end)/2;
	    }

	}
	return -1;

    }


    public int lastIndexOf (String str){
	int start = 0;
	int end = size();
	String[] search = this.returnData();
      
	if (end == 1){
	    if (str.equals(search[0])){
		return 0;
	    }
	    else {
		return -1;
	    }
	}
      
	while (start != end){
	    if (end - start == 1){
		if (str.compareTo(search[start]) == 0){
		    return start;
		}
		else{
		    return -1;
		}
	    }
	    if (str.compareTo(search[(start + end) / 2]) >= 0){
		start = (start + end) / 2;
	    }
	    else{
		end = (start + end)/2;
	    }

	}
	return -1;
    }
    private int findIndex(String str){
	String[] currentData = this.returnData();
	for (int i = 0; i < this.size(); i ++){
	    if (str.compareTo(currentData[i]) < 0 ){

		return i;
	    }
	}
	return this.size();
    }
    private int findIndexBinary(String str){
	String[] search = this.returnData();
	int start = 0;
	int end = this.size();

	while (start != end){
	    if (str.compareTo(search[(start + end) / 2]) > 0){
		start = (start + end) / 2;
		if (end-start == 1){
		    start = end;
		}
	    }else if(str.compareTo(search[(start + end) / 2]) == 0){
		end = ((start + end) / 2) + 1;
		start = end;
	    }
	    else{
		end = (start + end)/2;
	    }

	}
	return end;
    }


}

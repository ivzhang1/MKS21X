import java.util.Iterator;

public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;

  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  //Defines SuperArray iterator() method
  public Iterator<String> iterator(){
    return new superArrayIterator(this);
  }
  
  //Defines superArrayIterator class
  private class superArrayIterator implements Iterator<String>{
    int current;
    SuperArray array;

    public superArrayIterator(SuperArray inputArray){
      array = inputArray;
    }
    
    public String next(){
      return array.get(current++);
    }
    
    public boolean hasNext(){
      return current < array.size();
    }

    public void remove(){
      throw new UnsupportedOperationException();
    }
  }


 
  public String[] getData(){
    return data;
  }

  public int size(){
    return size;
  }

  public void clear(){
    data = new String[size];
    size = 0;
  }

  public boolean add(String element){
      
    if (size == data.length){
      this.resize();
    }
      
    data[size] = element;
    size += 1;
    return true;
  }

  private void resize(){
    String[] newArray;
    if (size == 0){
      newArray = new String[size + 1];
    }
    else{
      newArray = new String[size * 2];
    }
    for (int i = 0; i < size; i++){
      newArray[i] = data[i];
    }
    data = newArray;
  }

  private void resize(int times){
    for (int i = 0; i < times; i++){
      resize();
    }
  }
  
  public boolean isEmpty(){
    return size() == 0;
  }
  
  public String get(int index){
    if (index >= size() || index < 0){
      System.out.println("INDEX OUT OF RANGE");
      return null;
    }
    else{
      return data[index];
    }
  }

  public String set(int index, String element){
    if (index >= size() || index < 0){
      System.out.println("INDEX OUT OF RANGE");
      return null;
    }
      
    else{
      String oldElement = data[index];
      data[index] = element;
      return oldElement;
    }
  }

  public boolean contains(String element){
    for (int i = 0; i < size; i++){
      if (data[i].equals(element)){
        return true;
      }
    }
    return false;
  }

  public void add(int index, String element){
    if (index > size || index < 0){
      System.out.println("INDEX OUT OF RANGE");
    }
    else{
      if (size == data.length){
        this.resize();
      }
      for (int i = size - 1; i >= index; i -= 1){
        data[i + 1] = data[i];
      }
      data[index] = element;
      size ++;
    }
  }

  public int indexOf(String element){

    for (int i = 0 ; i < size; i ++){
      if (data[i].equals(element)){
        return i;
      }
    }
    return -1;
      
  }

  public int lastIndexOf(String element){
    for (int i = size - 1; i > 0; i -= 1){
      if (data[i].equals(element)){
        return i;
      }
    }
    return -1;
  }

  public String remove(int index){
    if (index >= size || index < 0){
      System.out.println("INDEX OUT OF RANGE");
      return null;
    }
    else{
      String removed = data[index];
          
      for (int i = index; i < size; i++){
        data[i] = data[i+1];
      }
      size -= 1;
        
      return removed;
    }
  }

  public boolean remove(String element){
    if (this.contains(element)){
      int found = this.indexOf(element);
      this.remove(found);
      return true;
    }
    else{
      return false;
    }
  }

  public String toString(){
    String finished = "[";
    if (size == 0){
      return finished + "]";
    }
    for (int i = 0; i < size - 1; i++){
      finished += data[i] + ", ";
    }

    return finished += data[size - 1] + "]";
  }
  
}

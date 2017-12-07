import java.util.Arrays;

public class Sorts{

  public static void main(String[]artie){
    int[] randish = new int[15];
    for(int i = 0 ; i < randish.length; i++){
      randish[i] =(int)(Math.random()*100);
    }

    System.out.println(Arrays.toString(randish));
    //Sorts Tests Here:
    //bogoSort(randish);

    System.out.println("selectionSort: \n");
    selectionSort(randish);

    System.out.println(Arrays.toString(randish));

  }

  public static String name(){
    return "09.Zhang.Ivan";
  }

  /**Selection sort of an int array.
   *Upon completion, the elements of the array will be in increasing order.
   *@param data  the elements to be sorted.
   */
  public static void selectionSort(int[] data){
    int temp = 0;
    int smallest = 0;
    int index = 0;
    for (int x = 0; x < data.length; x++){
      temp = data[x];
      smallest = data[x];
      for (int y = x; y < data.length; y++){
        if (smallest > data[y]){
          smallest = data[y];
          index = y;
        }
      }
      data[x] = smallest;
      data[index] = temp;
    }

  }

}
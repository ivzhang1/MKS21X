import java.util.Arrays;

public class Sorts{

  public static void main(String[]artie){
    long startTime = System.currentTimeMillis();
    int[] randish = new int[1000];
    //int[] randish = new int[0];
    //int[] randish = new int[1];
    //int[] randish = new int[2];
    //int[] randish = new int[3];
    //int[] randish = new int[100000];

    for(int i = 0 ; i < randish.length; i++){ //PURELY RANDOM
      randish[i] = (int)(Math.random()*100);
    }

    //for(int i = 0 ; i < randish.length; i++){ //ALL THE SAME NUMBER OR YOU CAN JUST RUN MAIN WITHOUT ANY FOR LOOPS
    //  randish[i] = 1;
    //}

    //for(int i = 0 ; i < randish.length; i++){ //BIGGEST TO SMALLEST
    //  randish[i] = randish.length - i;
    //}

    //for(int i = 0 ; i < randish.length; i++){ //SMALLEST TO BIGGEST
    //  randish[i] = i;
    //}

    System.out.println(Arrays.toString(randish));

    //Sorts Tests Here:

    //System.out.println("selectionSort:");
    //selectionSort(randish);

    //System.out.println("insertionSort:");
    //insertionSort(randish);

    System.out.println("bubbleSort:");
    bubbleSort(randish);

    System.out.println(Arrays.toString(randish));

    System.out.println("Runtime: " +
                       (System.currentTimeMillis() - startTime) + "ms or " +
                       (System.currentTimeMillis() - startTime)/1000.0 + "s"
                       );

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

  public static void insertionSort(int[] data){
    int place = 0;
    int temp = 0;
    int temp2 = 0;

    for (int i = 0; i < data.length; i++){
      int n = 0;
      place = data[i];

      while(data[n] < place && n < i){
        n++;
      }
      temp = data[n];
      for (int k = n; k < i; k++){
        temp2 = data[k+1];
        data[k+1] = temp;
        temp = temp2;
      }
      data[n] = place;

    }

  }

  public static void bubbleSort(int[] data){
    int upTo = data.length - 1;
    int temp = 0;

    while (upTo > 0){
      for (int i = 0; i < upTo; i++){
        if (data[i] > data[i + 1]){
          temp = data[i+1];
          data[i+1] = data[i];
          data[i] = temp;
        }
      }

      upTo -= 1;
    }

  }

}

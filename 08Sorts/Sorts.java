public class Sorts{

  public static String name(){
    return "09,Zhang,Ivan";
  }

  /**Selection sort of an int array.
   *Upon completion, the elements of the array will be in increasing order.
   *@param data  the elements to be sorted.
   */
  public static void selectionSort(int[] data){
      int temp = 0;
      for (int i = 0; i < data.length; i++){
	  for (int inside = i; inside < data.length; inside++){
	      if (data[i] > data[inside]){
		  temp = data[i];
		  data[i] = data[inside];
		  data[inside] = temp;
	      }
	  }
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

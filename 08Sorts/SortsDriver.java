import java.util.Arrays;

public class SortsDriver{
  public static void main(String[]artie){
    long startTime = System.currentTimeMillis();
    int[] randish = new int[1000];
    //int[] randish = new int[0];
    //int[] randish = new int[1];
    //int[] randish = new int[2];
    //int[] randish = new int[3];
    //int[] randish = new int[100000];

    if (artie.length == 0 || artie.length > 1){
      System.out.println("Making default random array!");
      System.out.println("Enter:\n" +
                         "0 for an array with the same numbers\n"+
                         "1 for an array: big to small #s\n" +
                         "2 for an array: small to big #s\n"
                         );
      for(int i = 0 ; i < randish.length; i++){ //PURELY RANDOM
        randish[i] = (int)(Math.random()*100);
      }
    } else if (artie[0].equals("0")){
      for(int i = 0 ; i < randish.length; i++){ //ALL THE SAME NUMBER OR YOU CAN JUST RUN MAIN WITHOUT ANY FOR LOOPS
        randish[i] = 1;
      }
    } else if (artie[0].equals("1")){
      for(int i = 0 ; i < randish.length; i++){ //BIGGEST TO SMALLEST
        randish[i] = randish.length - i;
      }
    } else if (artie[0].equals("2")){
      for(int i = 0 ; i < randish.length; i++){ //SMALLEST TO BIGGEST
        randish[i] = i;
      }
    }
    else{
      for(int i = 0 ; i < randish.length; i++){ //PURELY RANDOM
        randish[i] = (int)(Math.random()*100);
      }
    }

    System.out.println(Arrays.toString(randish));

    //Sorts Tests Here:

    System.out.println("selectionSort:");
    Sorts.selectionSort(randish);

    //System.out.println("insertionSort:");
    //Sorts.insertionSort(randish);

    //System.out.println("bubbleSort:");
    //Sorts.bubbleSort(randish);

    System.out.println(Arrays.toString(randish));

    System.out.println("Runtime: " +
                       (System.currentTimeMillis() - startTime) + "ms or " +
                       (System.currentTimeMillis() - startTime)/1000.0 + "s"
                       );

  }
}

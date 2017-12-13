public class TemperatureConversions{
  public static void main (String[] args){
    System.out.println(CtoF(-40.0)); // -> -40.0
    System.out.println(CtoF(100.0)); // -> 212.0
    System.out.println(FtoC(212.0)); // -> 100.0
  }
  public static double CtoF(double num){
    return num * 1.8 + 32;
  }
  public static double FtoC(double num){
    return (num - 32)/1.8;
  }
}

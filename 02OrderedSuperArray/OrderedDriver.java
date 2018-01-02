public class OrderedDriver{
    public static void main(String args[]){
      OrderedSuperArray ordered = new OrderedSuperArray();
      System.out.println(ordered.add("Happy"));
      System.out.println(ordered.add("Apple"));
      System.out.println(ordered.add("Bable"));
      System.out.println("happy".compareTo("Happy"));
      System.out.println(ordered);
      System.out.println(ordered.add("bable"));

      System.out.println(ordered.add("happy"));
      System.out.println(ordered.add("zappy"));      System.out.println(ordered.add("Zappy"));

      System.out.println(ordered);
    }
}

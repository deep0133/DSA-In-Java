import java.util.Scanner;

class evennumber {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    if (n <= 0) {
      System.out.println("Entered number should be greater than zero : ");
      return;
    }

    String x = "odd";
    for (int i = 1; i <= n; i++) {

      if (n % 2 == 0) {
        x = "even";
        break;
      }
    }
    System.out.println("Number is : " + x);
  }
}

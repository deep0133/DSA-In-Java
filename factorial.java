package sum;

import java.util.Scanner;
public class factorial {
  public static void main(String[] args) { 
  Scanner sc = new Scanner(System.in);
  int result=1;
   int n= sc.nextInt();
   for(int i=0; i<n; i++){
     result = result*(n-i);
     }
    System.out.println(result);
  }
}

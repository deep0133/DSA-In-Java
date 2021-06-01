package sum;

import java.util.Scanner;
 public class  evennumber {
 public static void main(String[] args) { 
Scanner sc= new Scanner(System.in);
  int n= sc.nextInt();
  String x =  "odd";
  for( int i=1; i<=n; i++){
    
   if( n % 2 ==0){
      x = "even";
    break;
    }
      }
  System.out.println(" number is =" +x);
  }
}

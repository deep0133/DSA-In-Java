package sum;

import java.util.Scanner;


public class primeornot {

  public static void main(String[] args) {
   Scanner sc= new Scanner(System.in);
   int a = sc.nextInt();
  boolean isprime = true;
   for( int i=2; i<a; i++){
     if( a % i ==0){
       isprime = false;
       break;
   }
         }if( a<2) isprime=false;
     System.out.println("is prime ="+
     isprime);

 }
 }


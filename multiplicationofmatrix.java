package ARRAYS;

import java.util.Scanner;


public class multiplicationofmatrix {

  public static void main(String[] args) {
System.out.println("Enter the row of first  array");
     Scanner sc= new Scanner(System.in);
     int x = sc.nextInt();
    System.out.println("Enter the coln of first array or row of the second array ");
    int y = sc.nextInt();
    
    int a[][]=new int[x][y];
    
    System.out.println("Enter the coln of second array = ");
    
    int t= sc.nextInt();
    
    int b[][]=new int[y][t];
    
      int c[][]=new int[x][t];

    System.out.println(" Enter the array a ");
    for(int i=0; i<x; i++){
    
      for(int j=0; j<y;j++){
      
        a[i][j] = sc.nextInt();
        
      }
      System.out.println();
    }
    for(int i=0; i<x; i++){
      for(int j=0; j<y;j++){
        System.out.print(" " + a[i][j]);
      }
      System.out.println();
      
    }
    
    System.out.println(" Enter the array b ");
    for(int i=0; i<y; i++){
      for(int j=0; j<t;j++){
        b[i][j]=sc.nextInt();
      }
      System.out.println();
    }
    
    for(int i=0; i<y; i++){
      for(int j=0; j<t;j++){
        System.out.print( " "+ b[i][j]);
      }
      System.out.println();
    }
       
    for(int i=0; i<x; i++){    
           for(int j=0; j<t;j++){
            for(int k=0;k<t-1;k++){
           c[i][j] += a[i][k]*b[k][j];
      }
      
      }
      
      }
          System.out.println(" The array c is = ");
  
  for(int i=0; i<x; i++){
  
      for(int j=0; j<t;j++){
    
    System.out.print(c[i][j] +" ");
    
      }
      
      System.out.println();
    }
  }

}

package Heap_DS;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargestEle {

    /*      Algorithm steps :
    *       use pq
    *       store first k elements in pq
    *       start from  i = k to n:
    *       if  pq.peek()  < a[i]  then poll() and add(a[i])
    *       print  pq.peek()
    */

    static void solve(int a[], int n,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        
        for (int i = 0; i < k; i++) {
            pq.add(a[i]);
        }

        for (int i = k; i < n; i++) {
            if(pq.peek() < a[i]){
                pq.poll();
                pq.add(a[i]);
            }
        }
        System.out.println(pq.peek());

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        sc.close();

        solve(a,n,k);

    }
}

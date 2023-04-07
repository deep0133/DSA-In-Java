package Heap_DS;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectNropes {

    static void connectRopesWithMinCost(int a[], int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++)
            pq.add(a[i]);

        int cost = 0;

        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            cost += sum;

            pq.add(sum);
        }

        System.out.println(cost);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        sc.close();
        connectRopesWithMinCost(a, n);

    }
}

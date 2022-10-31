package Heap_DS;

import java.io.PrintStream;
import java.util.Scanner;

public class heapSort {
    /**
     *
     */
    private static final PrintStream OUT = System.out;

    // swap method:
    static int[] swap(int a[], int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;

        return a;
    }

    // heapify method: Create a heap from given point: ex : i
    static int[] heapify(int a[], int n, int i) {

        int largest = i;
        int l = 2 * i; // left child of i_th parent:
        int r = 2 * i + 1; // right child of i_th parent:

        if (l < n && a[l] > a[largest])
            largest = l;
        if (r < n && a[r] > a[largest])
            largest = r;

        if (largest != i) {
            a = swap(a, i, largest); // swapping with largest element:
            a = heapify(a, n, largest);
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();

        sc.close();

        // Building Heap:
        for (int i = n / 2; i >= 0; i--) {
            a = heapify(a, n, i);
        }

        OUT.println("HEAP OF ARRAY:");
        for (int i = 0; i < n; i++)
            OUT.print(a[i] + " ");

        OUT.println("\nSORTED ARRAY:");
        for (int i = n - 1; i >= 0; i--) {
            a = swap(a, 0, i);
            a = heapify(a, i - 1, 0);
        }

        for (int i = 0; i < n; i++)
            OUT.print(a[i] + " ");
    }
}
import java.util.Scanner;

class QuickSort {

    static int[] swap(int a[], int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    static int partition(int a[], int l, int h) {

        int i = l, j = h, pivot = a[l];

        while (i < j) {

            while (i<a.length && pivot >= a[i])
                i++;

            while ( pivot < a[j])
                j--;

            if (i < j) {
                a = swap(a, i, j);
            }
        }
        a = swap(a, j, l);
        return j;
    }

    static int[] sort(int a[], int l, int h) {

        if (l < h) {
            int pivot = partition(a, l, h);
            sort(a, l, pivot - 1);
            sort(a, pivot + 1, h);
        }
        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
        int l = 0;

        array = sort(array, l, n - 1);

        for (int e : array) {
            System.out.print(e + " ");
        }
    }
}
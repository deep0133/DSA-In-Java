import java.util.Scanner;

public class InsertionSort {

    static int[] sort(int a[], int n) {

        for (int i = 1; i < n; i++) {

            int j = i - 1;
            int temp = a[i];
            while (j >= 0 && a[j] > temp ) { // 5 3 1 6 2
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;

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

        array = sort(array, n);

        for (int e : array) {
            System.out.print(e + " ");
        }

    }
}

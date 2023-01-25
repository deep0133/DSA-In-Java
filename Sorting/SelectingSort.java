import java.util.Scanner;

public class SelectingSort {

    static int[] sort(int a[], int n) {

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = 1 + i; j < n; j++) {

                if (a[j] < a[min]) {
                    min = j;
                }

            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
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

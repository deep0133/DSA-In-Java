import java.util.Scanner;

public class MergeSort {

    static int[] merge(int a[], int l, int mid, int r) {

        int i = l, j = mid + 1;
        int b[] = new int[a.length];
        int k = l;

        while (i <= mid && j <= r) {     

            if (a[i] > a[j]) {
                b[k] = a[j];
                j++;
            } else {
                b[k] = a[i];
                i++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= r) {
                b[k] = a[j];
                j++;
                k++;
            }
        } 
        
        else {
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }

        System.out.print("B Array : ");
        for (int k2 = l; k2 <= r; k2++) {
            a[k2] = b[k2];
            System.out.print(a[k2]+" ");
        }
        System.out.println();
        return a;
    }

    static int[] mergeSort(int a[], int l, int r) {

        if (l < r) {                   
            int mid = (l + r) / 2;     
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            a = merge(a, l, mid, r);
        }

        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int index = 0; index < a.length; index++) {
            a[index] = sc.nextInt();
        }

        sc.close();
        a = mergeSort(a, 0, n - 1);

        for (int index = 0; index < a.length; index++) {
            System.out.print(a[index] + " ");
        }
    }
}

import java.util.ArrayDeque;
import java.util.Scanner;

public class Slide {

    static void solve(int a[], int n, int k) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int ans[] = new int[n - k + 1];
        int i = 0;
        for (i = 0; i < k; i++) {
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i])
                dq.remove(dq.peekLast());

            dq.addLast(i);
        }

        ans[0] = a[dq.peekFirst()];
        int j = 1;

        for (; i < n; i++) {

            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.remove(dq.peekFirst());

            while (!dq.isEmpty() && a[i] >= a[dq.peekLast()])
                dq.removeLast();

            dq.addLast(i);
            ans[j] = a[dq.peekFirst()];
            j++;
        }

        for (i = 0; i < n - k + 1; i++)
            System.out.println(ans[i]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.print("Enter element : ");
        int a[] = new int[n];

        for (int index = 0; index < a.length; index++) {
            a[index] = sc.nextInt();
        }
        sc.close();

        solve(a, n, k);
    }
}

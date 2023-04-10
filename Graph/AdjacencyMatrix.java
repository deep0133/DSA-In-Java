import java.util.Scanner;

class AdjacencyMatrix {

    public static void addElement(int a[][], int src, int dst, int data) {
        a[src][dst] = data;
        a[dst][src] = data;
    }

    static void showGraph(int a[][], int n) {
        System.out.print("[");
        for (int i = 1; i <= n; i++) {
            System.out.print("[");
            for (int j = 1; j <= n; j++) {
                if (j == n)
                    System.out.print(a[i][j]);
                else
                    System.out.print(a[i][j] + ",");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter number of vertices: ");
        int v = sc.nextInt();

        int a[][] = new int[n + 1][n + 1];

        System.out.println("Enter 1 to connect nodes and Enter -1 to Exit");
        int enter = sc.nextInt();

        while (enter != -1 && v > 0) {
            System.out.println("Enter node 1 index: ");
            int n1 = sc.nextInt();
            System.out.println("Enter node 2 index: ");
            int n2 = sc.nextInt();
            System.out.println("Enter distance between them: ");
            int d = sc.nextInt();

            addElement(a, n1, n2, d);
            System.out.println("Enter Again 1 to continue , otherwise enter -1: ");
            v--;
            if (v == 0) {
                System.out.println("ALl edges are connected: ");
                break;
            }
            enter = sc.nextInt();
        }
        sc.close();

        showGraph(a, n);
    }

}
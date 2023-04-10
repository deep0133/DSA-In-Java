import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {

    static void addElementToList(ArrayList<ArrayList<Integer>> list, int src, int dst) {
        list.get(src).add(dst);
        list.get(dst).add(src);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        System.out.println("Enter number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter number of edges: ");
        // int e = sc.nextInt();

        for (int i = 0; i < v; i++)
            list.add(new ArrayList<Integer>());

        sc.close();
    }
}

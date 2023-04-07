import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class implementation {

    static Scanner sc = null;
    static Node<Integer> prev = null, head = null;
    static int diameter = 0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Node<Integer> root = createTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);

        int height = getHeight(root);
        System.out.println("\nHeight of tree is " + height);

        int size = getSize(root);
        System.out.println("Size of tree is " + size);

        View(root, 0);
        View(root, 1);

        topView(root);

        bottomView(root);

        convertToList(root);

        // calculateDiameter(root);
        System.out.print("\nDiameter of Tree is " + diameter);

        System.out.print("\nConverting Tree to List :");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }

        // diameter = calculateDiameter(root);
        // System.out.print("\nDiameter of Tree is " + diameter);
    }

    // Create Tree:
    static Node<Integer> createTree() {
        Node<Integer> root;

        System.out.println("Enter data : ");
        int data = sc.nextInt();

        if (data == -1)
            return null;
        root = new Node<>(data);

        System.out.println("Enter left child of " + data);
        root.left = createTree();

        System.out.println("Enter right child of " + data);
        root.right = createTree();

        return root;
    }

    // Left Node Right: LNR
    static void inOrder(Node<Integer> root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Node Left Right: NLR
    static void preOrder(Node<Integer> root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Left Right Node: LRN
    static void postOrder(Node<Integer> root) {
        if (root == null)
            return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Level order traversal ------Pending to implement-------

    // Find height of the tree:
    static int getHeight(Node<Integer> root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // Size of the Tree:
    static int getSize(Node<Integer> root) {
        if (root == null)
            return 0;
        return getSize(root.left) + getSize(root.right) + 1;
    }

    // View Of Tree:
    static void getLeftView(Node<Integer> root, HashMap<Integer, Integer> map, int level) {
        if (root == null)
            return;

        if (!map.containsKey(level))
            map.put(level, (Integer) root.data);

        getLeftView(root.left, map, level + 1);
        getLeftView(root.right, map, level + 1);
    }

    // Right View Print:
    static void getRightView(Node<Integer> root, HashMap<Integer, Integer> list, int level) {
        if (root == null)
            return;

        if (!list.containsKey(level))
            list.put(level, root.data);

        getRightView(root.right, list, level + 1);
        getRightView(root.left, list, level + 1);
    }

    // Left View Print:
    static void View(Node<Integer> root, int chooseView) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (chooseView == 0) {
            getLeftView(root, map, 0);
            System.out.print("Left view Found : ");

        } else {
            getRightView(root, map, 0);
            System.out.print("Right view Found : ");
        }

        // Iterating over the map using entrySet()
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            System.out.print(value + " ");
        }
    }

    // Top View Print:
    static void topView(Node<Integer> root) {
        Queue<Pair> qu = new ArrayDeque<>();

        if (root == null)
            return;

        qu.add(new Pair(0, root));
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!qu.isEmpty()) {
            Pair cur = qu.poll();
            if (!map.containsKey(cur.hd)) {
                map.put((Integer) cur.hd, (Integer) cur.node.data);
            }
            if (cur.node.left != null)
                qu.add(new Pair(cur.hd - 1, cur.node.left));
            if (cur.node.right != null)
                qu.add(new Pair(cur.hd + 1, cur.node.right));
        }

        System.out.print("\nTop View is : ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // Bottom View Print
    static void bottomView(Node<Integer> root) {
        Queue<Pair> qu = new ArrayDeque<>();

        if (root == null)
            return;

        qu.add(new Pair(0, root));

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!qu.isEmpty()) {
            Pair cur = qu.poll();
            map.put((Integer) cur.hd, (Integer) cur.node.data);
            if (cur.node.left != null)
                qu.add(new Pair(cur.hd - 1, cur.node.left));
            if (cur.node.right != null)
                qu.add(new Pair(cur.hd + 1, cur.node.right));
        }

        System.out.print("\nBottom View is : ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // Convert Binary to Doubly LinkedList : without extra space
    static void convertToList(Node<Integer> root) { // order of list is look
                                                    // like Inorder_Traversal
        if (root == null)
            return;
        convertToList(root.left);

        // logic for converting into list
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        convertToList(root.right);
    }

    // Diameter of the Tree :
    static int calculateDiameter(Node<Integer> root) {
        if (root == null)
            return 0;
        int lh = 0;
        if (root.left != null)
            lh = calculateDiameter(root.left);
        int rh = 0;
        if (root.right != null)
            rh = calculateDiameter(root.right);
        diameter = Math.max(lh + rh + 1, diameter);
        return 1 + Math.max(lh, rh);

    }

    // Lowest Common Ancestor:
    /*
     * ------------------------- ALGORITHM -----------------------------------------
     * 1) current = a || current = b ------>>>>> current = root.data
     * 2.1) a --> may be present in the left subtree
     * 2.2) b --> may be present in the right subtree
     * 3) both ( a and b ) --> may be present in any one subtree
     * 4) none of ( a and b ) --> present in any one subtree
     */

    static int lowestCommonAncestor(Node<Integer> root, int n1, int n2) {
        if (root == null)
            return 0;

        if (root.data == n1 || root.data == n2)
            return root.data;

        int left = lowestCommonAncestor(root.left, n1, n2);
        int right = lowestCommonAncestor(root.right, n1, n2);

        if (root.left == null)
            return right;
        if (root.right == null)
            return left;
        return root.data;
    }

    // Min Time require to burn Tree:
    static int minTime(Node<Integer> root, int target) {
        Depth depth = new Depth(-1);
        int ans = burn(root, target, depth, ans = Integer.MIN_VALUE);
        return ans;
    }

    static int burn(Node<Integer> root, int target, Depth depth, int ans) {

        if (root == null)
            return 0;
        if (root.data == target) {
            depth.d = 1;
            return 1;
        }
        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);

        int lh = burn(root.left, target, ld, ans);
        int rh = burn(root.right, target, rd, ans);

        if (ld.d != -1) {
            int temp = ld.d + 1 + rh;
            ans = Math.max(temp, ans);
            depth.d = ld.d + 1;
        } else if (rd.d != -1) {
            int temp = rd.d + 1 + lh;
            ans = Math.max(temp, ans);
            depth.d = rd.d + 1;
        }

        return Math.max(lh, rh) + 1;
    }

    // pair class for print Top View and Bottom View:
    static class Pair {
        int hd; // the horizontal distance
        Node<?> node;

        Pair(int hd, Node<?> node) {
            this.hd = hd;
            this.node = node;
        }
    }

    // Depth class for passing the reference instead of value:
    static class Depth {
        int d;

        Depth(int d) {
            this.d = d;
        }
    }
}

class Node<T> {
    T data;
    Node<Integer> left, right;

    Node(T data) {
        this.data = data;
    }
}
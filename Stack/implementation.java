package Stack;

public class implementation<E> {

    Node<E> head;

    // add function
    void push(E x) {
        Node<E> addData = new Node<E>(x);
        if (head == null) {
            head = addData;
            return;
        }

        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = addData;
        return;
    }

    // peek element in stack
    E peek() {

        if (head == null) {
            return head.data;
        }
        Node<E> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    // pop function => remove last element from list
    E pop() {

        if (head == null)
            return head.data;

        Node<E> temp = head;

        if (head.next == null) {
            head = null;
            return temp.data;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }

        Node<E> lastElement = temp.next;
        temp.next = null;
        return lastElement.data;
    }

    // isEmpty function
    boolean isEmpty() {
        if (head == null) {
            System.out.println("List is Empty:");
            return true;
        }
        return false;
    }

    // print function
    void print() {

        Node<E> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {

        implementation<Integer> in = new implementation<>();

        in.push(5);
        in.push(2);
        in.push(6);
        in.push(9);
        in.push(3);

        System.out.print("Array element : ");
        in.print();

        System.out.println("peek element : " + (in.peek()));
        System.out.println("poped element : " + (in.pop()));

        in.print();
    }
}

class Node<E> {

    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        next = null;
    }
}

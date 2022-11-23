package LinkedList;

public class implementation {

    public static void main(String[] args) {

        myLL<Integer> mll = new myLL<>();

        mll.add(4);
        mll.add(7);
        mll.add(5);

        mll.insert(1,2);

        mll.remove(2);

        mll.print();

        System.out.print("size of list : "+mll.size());

    }


    static class myLL<T>{
            Node head;

//          add function:
            void add(T data){
                Node<T> toAdd = new Node(data);
                if(head == null){
                    head = toAdd;
                    return;
                }
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = toAdd;
                return;
            }

//          print function:
            void print(){

                if(head == null){
                    System.out.println("List is Empty:");
                    return;
                }
                Node temp = head;
                while(temp != null){
                    System.out.print(temp.data +" ");
                    temp = temp.next;
                }
                System.out.println();
                return;
            }

//          insert function:
            void insert(int pos,T data){

                Node<T> toAdd = new Node(data);

                if(pos == 0){
                    toAdd.next = head;
                    head = toAdd;
                    return;
                }

                Node temp = head;
                while(pos-->1){
                    temp = temp.next;
                }
                toAdd.next = temp.next;
                temp.next = toAdd;
                return;
            }

//          delete function:
            void remove(T data){
                if(head == null){
                    System.out.println("List is Empty you can't perform remove function:");
                    return;
                }
                Node temp = head;
                if(head.data == data){
                    head = head.next;
                    return;
                }

                while(temp.next != null){
                    if(temp.next.data == data){
                        break;
                    }
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                return;
            }

//          boolean function:
            boolean isEmpty(){
                if(head == null){
                    return true;
                }
                else{
                    return false;
                }
            }

//          size function:
            int size(){

                if(head == null){
                    return 0;
                }
                Node temp = head;
                int count = 0;
                while(temp != null){
                    count++;
                    temp = temp.next;
                }
                return count;

            }

    }

    static class Node<T>{
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }
}

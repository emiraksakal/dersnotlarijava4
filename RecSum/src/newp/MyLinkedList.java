package newp;

public class MyLinkedList {
    Node first;
    Node last;
    int size;

    MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        MyLinkedList m1 = new MyLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        m1.insertLast(1);
        m1.insertLast(3);
        m1.insertLast(4);
        m1.insertLast(1);
        m1.mergeAll();
        m1.print();

    }

    public void print() {
        while (first != null) {
            System.out.println(first.data);
            first = first.next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public MyLinkedList mergeAll() {
        Node tmp = this.first;
        int sum=0;
        while (tmp!=null) {
            sum+=tmp.data;
            tmp=tmp.next;
            this.removeFirst();
        } Node newNode = new Node(sum);
        this.insertLast(newNode.data);
        return this;
    }


    public void insertFirst(int v) {
        Node newNode = new Node(v);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void insertLast(int v) {
        Node newNode = new Node(v);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode; //you shouldnt write this newNode = last.next;
            last = newNode;
        }
        size++;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = first;
        first = first.next;
        size--;
        return tmp;
    }

    public Node removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node secondLast = first;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        Node lastNode = secondLast.next;// you save last node
        secondLast.next = null;
        last = secondLast;
        size--;
        return last;

    }

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

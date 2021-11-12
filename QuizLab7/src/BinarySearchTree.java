import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<Item> {

    Node<Item> root;

    public BinarySearchTree() {
        root = null;
    }

    public void addNode(int key, Item nm) {
        Node n = new Node(key, nm);
        // if the tree is empty
        if (root == null) {
            root = n;
        } else {
            Node tmp = root;
            Node parent = root;
            while (tmp != null) {
                parent = tmp;
                if (key < tmp.key) {
                    tmp = tmp.left;
                } else if (key >= tmp.key) {
                    tmp = tmp.right;
                }
            }
            if (key < parent.key) {
                parent.left = n;
            } else {
                parent.right = n;
            }
        }
    }

//breadth first

    public void traverseLevelOrder(Node focus){

        java.util.LinkedList<Node> que = new java.util.LinkedList<Node>();

        que.enqueue(focus);

        while(!que.isEmpty()){

            Node d = que.removeFirst();

            if(d.left != null){

                que.addLast(d.left);

            }

            if(d.right != null){

                que.addLast(d.right);

            }

            System.out.println(d);

        }

    }

    void reverseLevelOrder(Node node)
    {
        Stack<Node> S = new Stack();
        Queue<Node> Q = new LinkedList();
        Q.add(node);

        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false)
        {
            /* Dequeue node and make it root */
            node = Q.peek();
            Q.remove();
            S.push(node);

            /* Enqueue right child */
            if (node.right != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(node.right);

            /* Enqueue left child */
            if (node.left != null)
                Q.add(node.left);
        }

        // Now pop all items from stack one by one and print them
        while (S.empty() == false)
        {
            node = S.peek();
            System.out.print(node.data + " ");
            S.pop();
        }
    }



    public class Node<Item> {

        int key;
        Item data; // change this for other objects
        Node<Item> left = null;
        Node<Item> right = null;

        public Node(int key, Item name) {
            this.key = key;
            this.data = name;
        }

        @Override
        public String toString() {
            return ("Node(k= " + key + ", name= " + data.toString() + ")");
        }
    }

}
package newp;
//https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
//https://www.geeksforgeeks.org/avl-tree-set-2-deletion/

import java.time.LocalTime;
import java.util.Date;


public class StorePrice extends Store {
    Flight  ceil1 = new Flight(new Date(1,1,1), LocalTime.of(1, 1),"1","1","1",1);

    Flight insert(Flight node, int price, Date date, LocalTime time, String from, String to, String carrier) {


        if (node == null)
            return (new Flight(date, time, from, to, carrier, price));

        if (price < node.price)
            node.left = insert(node.left, price, date, time, from, to, carrier);
        else if (price > node.price)
            node.right = insert(node.right, price, date, time, from, to, carrier);

        if (price == node.price) {
            (node.count)++;
            return node;
        }


        return node;
    }

    void preOrder(Flight node) {
        if (node != null) {
            System.out.print(node.price + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }



    Flight deleteNode(Flight root, int price) {

        if (root == null)
            return null;

        if (price < root.price)
            root.left = deleteNode(root.left, price);

        else if (price > root.price)
            root.right = deleteNode(root.right, price);

        else {
            if (root.count > 1) {
                (root.count)--;
                return null;
            }


            if ((root.left == null) || (root.right == null)) {
                Flight temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;


                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;

            } else {


                Flight temp = minValueNode(root.right);

                root.price = temp.price;
                root.count = temp.count;
                temp.count = 1;
                root.right = deleteNode(root.right, temp.price);
            }
        }


        if (root == null)
            return null;


        return root;
    }


    public Flight ceil(Flight focus, int price) {
        if (focus == null) {
            return null;
        }
        if (price == focus.price) {
            return focus;
        }
        if (price > focus.price) {
            return ceil(focus.right, price);
        }
        Flight x = ceil(focus.left, price);

        if (x != null) {
            return x;
        } else {
            return focus;
        }
    }
    public Flight searchLessThan(int price) {
        Flight focus = root;
        while (focus != null) {
            if (price < focus.price) {
                focus = focus.left;
            } else if (price > focus.price) {
                focus = focus.right;
            } else {
                return focus;
            }
        }
        return ceil(root,price);
    }



    public Flight Search(int price) {
        Flight focus = root;
        while (focus != null) {
            if (price < focus.price) {
                focus = focus.left;
            } else if (price > focus.price) {
                focus = focus.right;
            } else {
                return focus;
            }
        }
        return null;
    }

    public Flight SearchRecursive(Flight focus, int price) {
        if (focus == null) {
            return null;
        }
        if (focus.price == price) //found return the node
        {
            return focus;
        } else if (price < focus.price) //check which side to go
        {
            return SearchRecursive(focus.left, price);
        } else //
        {
            return SearchRecursive(focus.right, price);
        }
    }

    public Flight lessThanRec(Flight root,int price){
        if (root!=null && root.price>price) {
            return lessThanRec(root.left,price);
        }
        assert root != null;
        if (root.price<price) {

            System.out.println(root.toStringg());
            return lessThanRec(root.right,price);
        }
        throw new NullPointerException("verilen bilgilerle uyuşan uçuş bulunamadı.");
    }






}

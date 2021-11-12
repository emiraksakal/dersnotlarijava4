package newp;

import java.time.LocalTime;
import java.util.Date;
import java.util.NoSuchElementException;

public class StoreFromCity extends Store {


    public Flight insert(Flight node, String from, Date date, LocalTime time, String to, String carrier, int price) {
        int i = 0;

        if (node == null) {
            return (new Flight(date, time, from, to, carrier, price));
        }
        node.from.toUpperCase();
        from.toUpperCase();
        if (node.from.charAt(i) < from.charAt(i)) {
            root.right = insert(node.right, from, date, time, to, carrier, price);

        } else if (node.from.charAt(i) > root.from.charAt(i)) {
            root.left = insert(node.left, from, date, time, to, carrier, price);
        } else if (node.from.charAt(i) == root.from.charAt(i)) {
            return null;
        }

        return node;
    }


    public Flight search(String from) throws Exception {
        try {
            Flight flight = searchRec(root, from);
            System.out.println(flight.toStringg());
            return flight;
        } catch (Exception exception) {
            System.out.println("bu bilgilerde bir uçuş yok");;
        }
       throw new Exception("");
    }
//if (flight == null) {
//
//               return null;


    public Flight searchRec(Flight root, String from) throws Exception {

        if (root == null || root.from.equals(from)) {
            return root;
        }
        root.from.toUpperCase();
        from.toUpperCase();
        int i=0;
        if (root.from.charAt(i) < from.charAt(i)) {
            return searchRec(root.right, from);
        }
        if (root.from.charAt(i) > from.charAt(i)) {
            return searchRec(root.left, from);
        }
       /* for (int i = 0; i < from.length(); i++) {
            if (root.from.charAt(i) < from.charAt(i)) {
                return searchRec(root.right, from);
            }
            if (root.from.charAt(i) > from.charAt(i)) {
                return searchRec(root.left, from);
            }
        }*/
        throw new Exception("");
    }


    Flight deleteNode(Flight root, String from) {

        if (root == null)
            return null;
        int i = 0;


        if (from.toUpperCase().charAt(i) < root.from.toUpperCase().charAt(i))
            root.left = deleteNode(root.left, from);


        else if (from.toUpperCase().charAt(i) > root.from.toUpperCase().charAt(i))
            root.right = deleteNode(root.right, from);


        else {
            i++;
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

                root.from = temp.from;
                root.count = temp.count;
                temp.count = 1;
                root.right = deleteNode(root.right, temp.from);
            }
        }

    if (root == null)
            return null;


        return root;
}


           /* if (root.from.charAt(i) < from.charAt(i)) {
                return search(root.right, from);
            }

            if (root.from.charAt(i) > from.charAt(i)) {
                return search(root.left, from);
            }

            if (root.from.charAt(i) == from.charAt(i)) {
                i++;
                return search(root, from);
            }*/


}



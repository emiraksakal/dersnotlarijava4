package newp;

public class Store {                         //AVL TREE  -----> BST YE ÇEVİRDİM

    // diğer değerle için de avl tree açabilirim hepsinin rotateleri aynı olur o yüzden Store classını extends ederler.

    Flight root;

    int height(Flight N) {
        if (N == null)
            return 0;

        return N.height;
    }


    Flight rightRotate(Flight y) {
        Flight x = y.left;
        Flight T2 = x.right;


        x.right = y;
        y.left = T2;


        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;


        return x;
    }


    Flight leftRotate(Flight x) {
        Flight y = x.right;
        Flight T2 = y.left;


        y.left = x;
        x.right = T2;


        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;


        return y;
    }
    public Flight doubleRotateLeftSide(Flight focus) { //LR
        focus.left = rightRotate(focus.left);
        return leftRotate(focus);
    }

    public Flight doubleRotateRightSide(Flight focus) { //RL
        focus.right = leftRotate(focus.right);
        return rightRotate(focus);
    }


    int getBalance(Flight N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }


    Flight minValueNode(Flight flight)
    {
        Flight current = flight;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }




}




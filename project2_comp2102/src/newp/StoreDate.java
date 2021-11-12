package newp;

import java.time.LocalTime;
import java.util.Date;

public class StoreDate extends Store {
    Flight floor1 = new Flight(new Date(1,1,1), LocalTime.of(1, 1),"1","1","1",1);
    Flight  ceil1 = new Flight(new Date(1,1,1), LocalTime.of(1, 1),"1","1","1",1);

    Flight insert(Flight node, Date date, LocalTime time, String from, String to, String carrier,int price) {




        long date1 = date.getTime();

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Flight(date, time, from, to, carrier, price));



        if (date1 < node.date.getTime())
            node.left = insert(node.left, date, time, from, to, carrier,price);
        else if (date1 > node.date.getTime())
            node.right = insert(node.right,date, time, from, to, carrier, price);


        if (date1 == node.date.getTime()) {
            (node.count)++;
            return node;
        }


        return node;
    }


    Flight deleteDate(Flight root, Date date)
    {


        if (root == null)
            return null;

        long datex= date.getTime();
        long nodeDate = root.date.getTime();


        if (datex < nodeDate)
            root.left = deleteDate(root.left, date);

        else if (datex > nodeDate)
            root.right = deleteDate(root.right, date);

        else
        {  if (root.count > 1) {
            (root.count)--;
            return null;
        }


            if ((root.left == null) || (root.right == null)) {
                Flight temp = root.left != null ? root.left : root.right;


                if (temp == null) {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else
            {

                Flight temp = minValueNode(root.right);

                root.date = temp.date;
                root.count = temp.count;
                temp.count = 1;
                root.right = deleteDate(root.right, temp.date);
            }
        }


        if (root == null)
            return null;


        return root;
    }



    void preOrder(Flight node)
    {
        if (node != null)
        {
            System.out.println(node.date + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public Flight search(Flight root,Date date) {


        if (root.date.compareTo(date)==0) {                  // eğer date yoksa en yakındakini atıcaz
            return root;
        }
        if (root.date.compareTo(date)>0) {
            return   search(root.left, date);
        }
        else if (root.date.compareTo(date)<0) {
            return search(root.right, date);
        }

        ceil1 = ceil(root,date);//might return null
        floor1= floorRecursive(root,date);//might return null

        return null;
        //return  ceil1;

    }

    public Flight floorRecursive(Flight focus, Date date) {
        if (focus == null) {
            return null;
        }
        if (date == focus.date) {
            return focus;
        }
        if (focus.date.after(date)) {
            return floorRecursive(focus.left, date);
        }

        Flight x = floorRecursive(focus.right, date);

        if (x != null) {
            return x;
        } else {
            return focus;
        }
    }

    public Flight ceil(Flight focus, Date date) {
        if (focus == null) {
            return null;
        }
        if (date == focus.date) {
            return focus;
        }
        if (date.after(focus.date)) {
            return ceil(focus.right, date);
        }
        Flight x = ceil(focus.left, date);

        if (x != null) {
            return x;
        } else {
            return focus;
        }
    }





    public Flight search(Date k)
    {
        Flight flight = search(root,k);
        if (flight==null){
            return null;
        }
        System.out.println(flight.toStringg());
        return flight;
    }
    //search



    /*

    Flight search(Flight flight, Date date)
    {
        long k =date.getTime()/86400000;
        long a= flight.date.getTime()/86400000;
        while ((flight != null) && (k != a)) {
            if (k < a)
                flight = flight.left;
            else

            flight = flight.right;
        }

        if (flight != null){
            return flight;
        }
        else {
            throw new NoSuchElementException("Not Found");
        }
    } //search

     */

    Flight searchBetween2Dates(Flight flight,Date date1, Date date2) {

        long d1 = date1.getTime();
        long d2 = date2.getTime();
        long nodeDate = flight.date.getTime();


        //miliseconds yapınca aynı tarihten 1 kaç tane yazabilir.
        //86400000 1 gündeki milisaniyeler
        // 2 tarih arası flight ları çıkartmamız gerek

        while ((flight != null) && (d1!=nodeDate  || d2!=nodeDate ) ) {

            if ((( d1<nodeDate && d2>nodeDate) || (( d1>nodeDate) && d2<nodeDate))){
                return flight;
            }
            if (d1<nodeDate && d2<nodeDate) { // eğer iki tarihten de büyükse sola daha küçük tarihlere baksın
                return searchBetween2Dates(flight.left,date1,date2);
            }
            if (d1>nodeDate && d2>nodeDate){
                return searchBetween2Dates(flight.right,date1,date2);
            }
        }
       return null;
    }



   /* Flight between2Date(Flight node, Date date1, Date date2)
    {
        // Base Case
        if(node == null)
            return null;

        long d1 = date1.getTime();
        long d2 = date2.getTime();
        long nodeDate = node.date.getTime();

        // If current node is in range, then
        // include it in count and recur for
        // left and right children of it
        if(nodeDate >= d1 && nodeDate <= d2)
            return node + this.between2Date(node.left, date1, date2)+
                    this.between2Date(node.right, date1, date2);

            // If current node is smaller than low,
            // then recur for right child
        else if(nodeDate < d1)
            return this.between2Date(node.right, date1, date2);

            // Else recur for left child
        else
            return this.between2Date(node.left, date1, date2);
    }*/



    Flight searchBetween2Dates(Date d1, Date d2) {
        Flight f1 = searchBetween2Dates(root,d1,d2);
        if (f1==null) {
            System.out.println("no flights between given dates");
            return null;}
        System.out.println(f1.toStringg());
        return f1;
    }




}





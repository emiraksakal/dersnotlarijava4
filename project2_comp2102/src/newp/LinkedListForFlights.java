package newp;

import java.time.LocalTime;
import java.util.Date;

public class LinkedListForFlights {
    Flight first;
    Flight last;
    int size = 0;
    public LinkedListForFlights(){
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert( Date date, LocalTime time, String from, String to, String carrier, int price) {
        Flight n = new Flight(date, time, from, to, carrier, price); // create the node
        size++;
        // list may be empty
        if (first == null && last == null) {
            first = n;
            last = n;
            first.left = null;
            first.right=null;
        }
        else {
            last.right = n;

        }
        n.left = last;
        last = n;
        n.right= null;
    }


    public Flight search(Flight flight){
        Flight tmp = first;
        while(tmp!=null){
            if (tmp.date==flight.date && tmp.time==flight.time && tmp.from.equals(flight.from) && tmp.to.equals(flight.to) && tmp.carrier.equals(flight.carrier) && tmp.price==flight.price )
                return tmp;
            tmp = tmp.right;
        }

        return null;
    }

    Flight removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Flight r = first;
        first = first.right;
        if (first == null) {
            last = null;
        } else {
            first.left = null;
        }
        size--;
        return r;
    }

    Flight removeLast() { // you can also return int
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Flight r = last;
        last = last.left;
        if (last == null) {
            first = null;
        } else {
            last.right = null;
        }
        size--;
        return r;
    }

    Flight delete(Flight flight) {
        if (first == null) {
            return null;
        }

        if (first == flight) {
            first = flight.right;
        }
        if (flight.right != null) {
            flight.right.left = flight.left;
        }
        if (flight.left != null) {
            flight.left.right = flight.right;
        }
        return flight;
    }
    /*Flight remove(Flight n) {
        if (isEmpty() || n == null) {
            throw new java.util.NoSuchElementException();
        }
        if (n == first) {
            return removeFirst();
        } else if (n == last) {
            return removeLast();
        } else {
            //Flight back = n.left;
           //Flight front = n.right;
            n.left.right = n.right;
            n.right.left = n.left;
            size--;
            return n; //n.getElement();
        }*/





    public String print() {
        Flight tmp = this.first;
        String s = "";
        while (tmp != null) {
            int date=tmp.date.getMonth();
            int realdate = date+1;
            s += tmp.date.getDate() +"-" +realdate +"-" + tmp.date.getYear() +" "+tmp.time.getHour() +":"+ tmp.time.getMinute()+" "+tmp.from +" "+tmp.to+" "+tmp.carrier+" "+tmp.price+"TL\n" ;
            System.out.println();
            tmp = tmp.right;
        }
        return s;
    }


}

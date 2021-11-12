package newp;

public class StacksForSearch<T> {               //KULLANILMADI!!!!

    Flight a[]; // array to hold items
    int top; // the top most item index

    public StacksForSearch(int capacity) {
        a = new Flight[capacity];
        top = -1;
    }

    public void push(Flight item) {
        if (top == a.length) resize(2 * a.length); // double size of array if necessary
        a[++top] = item; // add item
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        Flight[] temp = (Flight []) new Object[capacity];
        for (int i = 0; i <= top; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Flight pop() {
        top--;
        return a[top + 1];
    }

    public String toString() {
        String s = "";
        for(int i=0;i<a.length;i++) {
            s+= a[i].date.getDate() +"/" +a[i].date.getMonth() +"/" + a[i].date.getYear() +" "+a[i].time.getHour() +":"+ a[i].time.getMinute()+" "+a[i].from +" "+a[i].to+" "+a[i].carrier+" "+a[i].price +"\n";
        } return s;
    }
}




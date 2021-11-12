public class Box {
    int value;
    Box small;
    Box(int value){
        this.value=value;
        small = null;
    }
    void putin(Box e){
        this.small=e;
    }

    int getValue() {
        int sum=0;
        Box tmp = this;
        while (tmp!=null) {
            sum+=tmp.value;
            tmp=tmp.small;
        }
        return sum;
    }

    public static void main(String[] args) {
        Box b1 = new Box(5);
        Box b2 = new Box(4);
        Box b3 = new Box(3);
        Box b4 = new Box(1);
        Box b5 = new Box(10);

        b1.putin(b2);
        b2.putin(b3);
        b3.putin(b4);
        b4.putin(b5);

        System.out.println(b1.getValue());
        System.out.println(b2.getValue());

    }

}

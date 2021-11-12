public class GenericStack<Type> {
    private Type [] stack;
    private int top;

    GenericStack(int capacity){
        this.stack = (Type[]) new Object[capacity];
        this.top=-1;
    }
    boolean isFull() { return top == stack.length-1; }
    public boolean isEmpty() { return top == -1; }
    Type pop() {
        if (!isEmpty()){
            top--;
            return stack[top+1];
        }
        return null;
    }
    void push(Type e) {
        if (!isFull()) {
            top++;
            stack[top]=e;
        }
    }

    public Type peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.exit(1);
        }
        return null;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("");
            return;
        }
        Type x = peek();
        pop();
        printStack();
        System.out.print(x + " ");
        push(x);
    }

   /* void resize(int capacity) {
       Type[] tmp = (Type[]) new Object[capacity];
        for (int i=0;i<=top;i++){
            tmp[i]= stack[i];
        }
        stack =tmp;
    }*/

    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>(10);
        stack1.push("anan");
        stack1.printStack();

        GenericStack<Integer> stack2 = new GenericStack<Integer>(100);
        stack2.push(101);
        Integer a = stack2.pop();
       stack2.printStack();


        GenericStack<Student> gstack = new GenericStack<>(10);
        Student s1 = new Student("Ozay", 1111);
        gstack.push(s1);
        Student s2 = new Student("Mert", 2222);
        Student s3 = new Student("Büşra", 3333);
        Student s4 = new Student("John", 4444);
        gstack.push(s2);
        gstack.push(s3);
        gstack.push(s4);
        System.out.println(gstack.pop());
        System.out.println(gstack.pop());
        System.out.println(gstack.pop());
        System.out.println(gstack.pop());
    }

    static class Student {

        private int no;
        private String name;

        public Student(String name, int no) {
            this.no = no;
            this.name = name;
        }

        public String toString() {
            return "Student name: " + name + " No: " + no;
        }
    }
}

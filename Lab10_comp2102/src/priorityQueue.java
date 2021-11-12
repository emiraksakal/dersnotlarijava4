
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ozay
 */
public class priorityQueue {

    public static void main(String[] args) {
        // TODO code application logic here
        //Comparator<Integer cmp = new Natura<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(15);
        pq.add(25);
        pq.add(10);
        pq.add(1);
        for (int i = 0; i < pq.size(); i++) {
            System.out.println(pq.remove());
        }

        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        pq2.add(new Student("Ece", 101, 3.00f));
        pq2.add(new Student("Kerem", 201, 2.50f));
        pq2.add(new Student("Asli", 124, 2.05f));
        pq2.add(new Student("Cemil", 267, 3.02f));

        System.out.println("Student queue");
        int n = pq2.size();
        for (int i = 0; i < n; i++) {
            System.out.println(pq2.remove());
        }
    }
}

class Student implements Comparable<Student> {

    float gpa;
    int idNo;
    String name;

    public Student(String name, int id, float gpa) {
        this.name = name;
        this.idNo = id;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student a) {

        if (this.gpa - ((Student) a).gpa > 0) {
            return 1;
        } else if (this.gpa - ((Student) a).gpa < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student : " + name + " id: " + idNo + " gpa: " + gpa + "\n";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listgraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author btek
 */
public class ListGraph {



    LinkedList<Integer>[] edges;
    private int numV;
    private int numE;

    /**
     * @param args the command line arguments
     */
    public ListGraph(int V) {
        this.numV = V;
        edges = (LinkedList<Integer>[]) new LinkedList[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Integer>();
        }
    }

    public int getNumE() {
        return numE;
    }

    public int getNumV() {
        return numV;
    }

    public void addEdge(int from, int to) {
        if (from >= 0 && from < numV && to >= 0 && to < numV) {
            edges[from].add(to);
            edges[to].add(from);
            numE++;
        } else {
            System.out.println("Vertex out of bounds!");

        }
    }

    public void removeEdge(int from, int to) {
        if (edges[from].contains(to)) {
            edges[from].remove(to);
        } else {
            System.out.println("Edge not found!");
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < numV; i++) {
            sb.append(i + " " + edges[i].toString() + "\n");
        }

        return sb.toString();
    }

    public boolean isAdjacent(int from, int to) {
        return edges[from].contains(to);
    }

    public LinkedList<Integer> neighborsList(int from) {
        return (LinkedList<Integer>) edges[from].clone();
    }

    public Integer[] neighborsArray (int from) {
        Integer[] ar = new Integer[edges[from].size()];
        edges[from].toArray(ar);
        return ar;
    }

    public int degree(int from) {
        return edges[from].size();
    }



    public static void main(String[] args) {
        // TODO code application logic here
        ListGraph g1 = new ListGraph(9);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);

        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(4, 5);
        g1.addEdge(3, 6);
        g1.addEdge(4, 6);
        g1.addEdge(7, 8);
        System.out.println("Printing graph");
        System.out.println(g1);


        System.out.println("Testing DFS....");
        int e = 0; int m = 6;
        DepthFirstPaths p = new DepthFirstPaths(g1, e);
        System.out.println(e+" DFS hasPathTo "+m+": "+ p.hasPathTo(m));
        p.printPathTo(m);

        System.out.println("Testing BFS....");
        e = 0;  m = 6;
        BreadthFirstSearch p2 = new BreadthFirstSearch(g1, e);
        System.out.println(e+" BFS hasPathTo "+m+": "+ p.hasPathTo(m));
        p2.printPathTo(m);
        System.out.println(" Dist ="+p2.distTo(m));
        /*
        ListGraph g2 = readfromFile("graph1.txt");
        System.out.print(g2);
         *
         */
    }

    public static ListGraph readfromFile(String f) {
        // TODO code application logic here

        try {
            Scanner sc = new Scanner(new File(f));
            int v = sc.nextInt();
            int e = sc.nextInt();
            System.out.println("constructing a graph of " + v + " vertices and "
                    + "" + e + " edges ");
            ListGraph g1 = new ListGraph(v);
            for (int i = 0; i < e; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                g1.addEdge(v1, v2);
            }
            System.out.println("Loaded " + e + " edges ");
            return g1;

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}

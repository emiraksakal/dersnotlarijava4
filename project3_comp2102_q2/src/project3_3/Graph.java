/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class Graph<T>{
    City vertices;
    static Stack<Edge> edgeStack = new Stack();
    int numV,numE;
    //LinkedList<Edge> [] adjacencylist;
    HashMap<LinkedList<String>, Integer> map;


    Graph(int numV,int numE){
        this.numE=numE;
        this.numV=numV;

        map = new HashMap<>();
    }



    public void printGraph(){
        for (LinkedList<String> keyList : map.keySet()) {
            System.out.print(keyList);
            System.out.print("---");
            System.out.print(map.get(keyList));
            System.out.println();


        }
       /*  for (Map.Entry<LinkedList<T>, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey()+" : "+entry.getValue());
}
*/
    }


    public void addEdges(City city1, City city2, int distance){
        Edge newEdge = new Edge(city1, city2, distance);
        edgeStack.push(newEdge);

        LinkedList<String> l = new LinkedList<String>();
        l.add(city1.name);
        l.add(city2.name);
        map.put(l, distance);
        city1.neighbours.add(city2);
        city2.neighbours.add(city1);
    }

    public void printPathTo(String city1, String city2) {


        Stack<String> path = new Stack<>();

        int b = 0;
        int a = 0;
        for(int i = 0; i < edgeStack.size(); i++){


            if((edgeStack.get(i).from.name == city1) && (b == 0)){
                System.out.print(edgeStack.get(i).from.name + "---");
                b = 1;
            }
            else{
                a++;

            }
        }
        b = 0;

        for(int j = 0; j < edgeStack.size(); j++){
            if(edgeStack.get(j).to.name == city2 && b == 0){
                System.out.println(edgeStack.get(j).to.name);
                b = 1;
            }
        }




    }


    public boolean isConnected (String city, String city2) {
        boolean con = false;
        for(int i = 0; i < edgeStack.size(); i++){
            if(edgeStack.get(i).from.name.equals(city) || edgeStack.get(i).to.name.equals(city) && edgeStack.get(i).from.name.equals(city2)){
                con = true;
            }

        }
        return con;
    }







    public static Graph readFromFile(String f){
        // TODO code application logic here

        try {
            Scanner sc = new Scanner(new File(f));
            int v = sc.nextInt();
            int e = sc.nextInt();
            System.out.println("constructing a graph of " + v + " vertices and "
                    + "" + e + " edges ");
            Graph<String> g1 = new Graph(10,16);
            for (int i = 0; i < e; i++) {
                City v1 = new City("");
                City v2 = new City("");
                v1.name = sc.next();
                v2.name = sc.next();
                g1.addEdges(v1, v2, (int) (Math.random() * (1000 - 80)) + 80);

            }
            System.out.println("Loaded " + e + " edges ");
            return g1;

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public int getNumV() {
        return numV;
    }

    public void minimumDistance(String city1, String city2){
        System.out.println("Minimum distance is: ");
    }
    public void cityGroups(){
        System.out.println("City Groups: ");
    }



    public void printCloseCities(){
        System.out.println("Close cities are:");
        for(int i = 0; i < edgeStack.size(); i++){
            if(edgeStack.get(i).weight < 100.0){
                System.out.println(edgeStack.get(i).from + "----" + edgeStack.get(i).to + "----" + edgeStack.get(i).weight);
            }

        }
    }

    public void printFartherCities(){
        System.out.println("Farther cities are:");
        for(int i = 0; i < edgeStack.size(); i++){
            if(edgeStack.get(i).weight > 500.0){
                System.out.println(edgeStack.get(i).from + "----" + edgeStack.get(i).to + " " + edgeStack.get(i).weight);
            }

        }
    }


  /*  public static void main(String args[]) {
        Graph g = readFromFile("C:\\Users\\emira\\Desktop\\citiesProject.txt");
        City city = new City("muğla");
        City city2 = new City("kütahya");
        City city3 = new City("manisa");
        City city4 = new City("bursa");


        g.addEdges(city, city2, 200);
        g.addEdges(city2, city3, 50);
        g.addEdges(city, city4, 120);
        g.addEdges(city4, city3, 70);
        g.printGraph();
        System.out.println();
        System.out.println("---------------------");
        g.printCloseCities();
        System.out.println("---------------------");
        g.printFartherCities();
        System.out.println("-----------------");



        g.printPathTo(city.name, city3.name);

    }
*/
}



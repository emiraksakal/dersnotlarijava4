/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_3;


import java.util.Scanner;

import static project3_3.Graph.readFromFile;

public class TestClass {

    public static void main(String[] args) {
        int option=1;
        Scanner input = new Scanner(System.in);
        Graph g = null;
        System.out.println("WELCOME");
        while (option<=8 && option>0){
            System.out.println("1- Create cities from file.\n" +
                    "2- Print Graph\n" +
                    "3- Print Close cities(distance is less than 100km.)\n" +
                    "4- Print Farther Cities(distance is higher than 500km.)\n" +
                    "5- Check for two cities are connected.\n" +
                    "6- Find a path between cities with least number of hopes.\n" +
                    "7- Find a minimum distance between two cities.\n" +
                    "8- Number of City Groups.");
            System.out.print("SELECT: ");
            System.out.print("");

            option=input.nextInt();
            if (option==1){
                g = readFromFile("C:\\Users\\emira\\Desktop\\citiesProject.txt");
                System.out.println();
            }
            if (option==2){
                g.printGraph();
                System.out.println();

            }
            if (option==3){
                g.printCloseCities();
                System.out.println();
            }
            if (option==4){
                g.printFartherCities();
                System.out.println();
            }
            if (option==5){
                System.out.println("city 1:");
                String city1 = input.next();
                System.out.println("city 2:");
                String city2 = input.next();

                if(g.isConnected(city1,city2)){
                    System.out.println(city1 + " and " + city2  + " are connected");
                }
                else{
                    System.out.println(city1 + " and " + city2  + " are not connected");
                }
                System.out.println();
            }
            if (option == 6){
                System.out.println("city 1:");
                String city1 = input.next();
                System.out.println("city 2:");
                String city2 = input.next();

                g.printPathTo(city1, city2);
                System.out.println();
            }

            if(option == 7){
                System.out.println("city 1:");
                String city1 = input.next();
                System.out.println("city 2:");
                String city2 = input.next();

                g.minimumDistance(city1, city2);
                System.out.println();


            }
            if (option == 8){
                System.out.println("Number of city groups: ");
                g.cityGroups();
            }


        }
    }
}

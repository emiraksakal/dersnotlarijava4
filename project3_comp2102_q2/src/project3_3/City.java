/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_3;

import java.util.LinkedList;

public class City{
    String name;
    LinkedList<City> neighbours;

    public City(String name) {
        this.name = name;
        this.neighbours = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }



}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_3;

public class Edge<T> {

    City from;
    City to;
    double weight;

    public Edge(City from, City to, double weight) {
        if (Double.isNaN(weight)){
            throw new IllegalArgumentException("Weight is NaN");
        }
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }



    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    public String toString() {
        return String.format("%d-%d %.5f", from, to, weight);
    }

    public static void main(String[] args) {

    }




}
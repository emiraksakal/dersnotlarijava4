/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ozay
 */
public class MergeSort {
    public static void main(String[] args) {
        // TODO code application logic here
        testMergeSort();
    }

    // abstraction of  less than <
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

    // swap
    private static void swap(Comparable[] a, int i, int j) {
        if (i == j) {
            return;
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void print(Comparable[] ar) {
        System.out.print("Array: ");
        for (Comparable e : ar) {
            System.out.print(e.toString() + ",");
        }
        System.out.println("..");
    }

    public static void testMergeSort() {
        Integer[] a2 = {4, 7, 2, 67, 8, 2, 1, 0, -4};
        System.out.println("Testing Merge Sort");
        print(a2);
        mergeSort(a2);
        print(a2);
    }

    public static void mergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    private static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo+hi)/2;// potential bug overflow for large arrays

        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // to merge first copy a to aux
        System.arraycopy(a, 0, aux, 0, a.length);

        int j = lo;  // first half index
        int k = mid + 1; // second half index

        // in each iteration copy from first half or second
        for (int i = lo; i <= hi; i++) {
            if (j <= mid && k <= hi) {
                if (less(aux[j], aux[k])) {
                    a[i] = aux[j++];
                } else {
                    a[i] = aux[k++];
                }
            } else if (j <= mid) { // first half is finished
                a[i] = aux[j++];
            } else if (k <= hi) // second half is finished
            {
                a[i] = aux[k++];
            }
        }
    }
}

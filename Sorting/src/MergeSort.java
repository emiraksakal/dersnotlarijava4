
public class MergeSort {
    public static int recCount = 0;

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
        int mid = (lo + hi) / 2;// potential bug overflow for large arrays

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

    public static void mergeHalves(Comparable[][] array,
                                   Comparable[][] aux,
                                   int start, int middle,
                                   int end,
                                   int index) {

        if (start >= end) {
            return;
        }

        int ls = start, le = middle, rs = middle + 1, re = end, size = end - start + 1;

        for (int i = 0; i < size; i++) {
            if (rs > re) {
                aux[i] = array[ls++];
            } else if (ls > le) {
                aux[i] = array[rs++];
            } else if (Double.parseDouble((String)array[ls][index])
                    <= Double.parseDouble((String)array[rs][index])) {
                aux[i] = array[ls++];
            } else {
                aux[i] = array[rs++];
            }
        }

        System.arraycopy(aux, 0, array, start, size);

    }
}

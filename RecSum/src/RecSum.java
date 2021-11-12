public class RecSum {

    static int recsum(int x) {

        if (x == 1) return 1;

        int sum = 0;

        for (int i = 1; i <= x; i++)

            sum += 1;

        return sum + recsum(x - 1);
    }

    public static void main(String[] args) {
        System.out.println(        recsum(8));;
    }
}

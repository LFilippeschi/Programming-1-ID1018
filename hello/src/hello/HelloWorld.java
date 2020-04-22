package hello;

public class HelloWorld {
    public static double pow(double x, double pow) {
        if (x == 0)
            return -1;
        if (pow == 0)
            return 1;
        if (pow == 1)
            return x;
        else
            return x * pow(x, pow - 1);
    }

    public static int gcd(int m, int n) {
        if (m < n)
            return gcd(n, m);
        if (m % n == 0)
            return n;
        if (m % n == 1)
            return 1;
        return gcd(n, m % n);
    }

    public static void binaryStrings(String[] start){
        String[] tmp=new String[start.length*2];
        int i=0;
        for (String s : start) {
            tmp[i]=s+'0';
            tmp[++i]=s+'1';
            i++;
        }
        for (String string : tmp) {
            System.out.println(string+" ");
        }
        binaryStrings(tmp);
    }

    public static void main(String[] args) {

        /* power recursive */
        /*
         * System.out.println("Hello Java"); System.out.println(pow(2, 1));
         * System.out.println(pow(2, 0)); System.out.println(pow(2, 5));
         * System.out.println(pow(2, 1000)); System.out.println("Hello Java");
         * System.out.println(pow(3, 1)); System.out.println(pow(3, 0));
         * System.out.println(pow(3, 5)); System.out.println(pow(3, 1000));
         * System.out.println(pow(15, 5));
         */

        /* gcd recursive */
        /*
         * int x = 3; int y = 5; System.out.println("gcd(" + x + "," + y + ")=" + gcd(x,
         * y)); x = 3; y = 15; System.out.println("gcd(" + x + "," + y + ")=" + gcd(x,
         * y)); x = 4711; y = 777; System.out.println("gcd(" + x + "," + y + ")=" +
         * gcd(x, y)); x = 4711; y = 77734531; System.out.println("gcd(" + x + "," + y +
         * ")=" + gcd(x, y)); x = 61545; y = 9131; System.out.println("gcd(" + x + "," +
         * y + ")=" + gcd(x, y));
         */

         /* binary string recursive */
/*         String[] start ={"0","1"}; */
/*         binaryStrings(start); */

    }
}

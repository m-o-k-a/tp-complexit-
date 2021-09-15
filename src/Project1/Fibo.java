package Project1;

import java.util.Arrays;

public class Fibo {
    public static void main(String[] args) {
        Fibo fiboRec = new Fibo();
        final int maxValue = 10;
        /*for(int i = 0; i<maxValue; i++) {
            System.out.println(fiboRec.fiboIter(i));
        }*/
        System.out.println(fiboRec.fiboExpoMatrix(5));
    }

    public double fiboRec(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        else return (fiboRec(n-1) + fiboRec(n-2));
    }

    public double fiboIter(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        double f0 = 0;
        double f1 = 1;
        double fn = 0;
        for(int i=2; i <= n; i++){
            fn= f1+f0;
            f0= f1;
            f1= fn;
            }
        return fn;
    }

    public double fiboExpoMatrix(int n) {
        n--;
        int[][] result = {{0},
                          {1}};
        int[][] base = {{0, 1},
                        {1, 1}};
        //power product to n-1
        if(n%2 == 0) {
            int[][] baseTemp = base.clone();
            while(n != 1) {
                base = squareMatrixProduct(base, base);
                n /= 2;
            }
            base = squareMatrixProduct(baseTemp, base);
        } else {
            while(n != 1) {
                base = squareMatrixProduct(base, base);
                n /= 2;
            }
        }
        System.out.println(base[0][0]+" "+base[0][1]+"/"+base[1][0]+" "+base[1][1]);
        result = columnMatrixProduct(base, result);
        return result[0][1];
    }

    private int[][] columnMatrixProduct(int[][] a, int[][] b) {
        int[][] p = {{1, 0},
                {0, 1}};
        for(int i = 0; i<a.length; i++) {
            for(int j = 0; j<a.length; j++) {
                int r = 0;
                for(int k = 0; k<b.length; k++) {
                    r += a[i][k] * b[k][0];
                }
                p[i][j] = r;
            }
        }
        return p;
    }

    private int[][] squareMatrixProduct(int[][] a, int[][] b) {
        int[][] p = {{1, 0},
                     {0, 1}};
        for(int i = 0; i<a.length; i++) {
            for(int j = 0; j<a.length; j++) {
                int r = 0;
                for(int k = 0; k<b.length; k++) {
                    r += a[i][k] * b[k][j];
                }
                p[i][j] = r;
            }
        }
        return p;
    }
}

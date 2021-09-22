package Project1;

/**
 * Fibo (for Fibonacci Suite) is the class featuring 3 implementations of the fibonacci algorithm:
 * - Recursive (rec)
 * - Iterative (iter)
 * - Matrix exponentiation (expoMatrix)
 */
public class Fibo {

    public double rec(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        else return (rec(n-1) + rec(n-2));
    }

    public double iter(int n) {
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

    private double[][] matrixProduct(double[][] a, double[][] b) {
        //we assert that both k are checked
        //m1[i][k] * m2[k][j]
        //result[i][j]
        int kSize = b.length;
        int iSize = a.length;
        int jSize = b[0].length;
        double result[][] = new double[iSize][jSize];
        for(int i=0; i<iSize; i++){
            for(int j=0; j<jSize; j++){
                result[i][j] = 0;
                for(int k=0; k<kSize;k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

 public double expoMatrix(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        double[][] result = {{0}, {1}};
        double[][] base =   {{0, 1},
                          {1, 1}};
        //get base^n
        //issue: if n = no, its result will be in the top row of the final result
        //issue: we also know that for even n, x^n = (x^2)^(n/2)
        //and if not even n, x^n = x*x^(n-1) = x*(x^2)^(n-1/2)
        base = expoMatrixRec(n, base);
        result = matrixProduct(base, result);
        return result[0][0];
    }

    private double[][] expoMatrixRec(int n, double[][] base) {
        if(n == 1) return base;
        if(n%2 == 0) {
            return expoMatrixRec(n/2, matrixProduct(base, base));
        } else {
            return matrixProduct(base, expoMatrixRec(n-1, base));
        }
    }
}
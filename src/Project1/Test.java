package Project1;

public class Test {
    public static void main(String[] args) {
        System.out.println("[TEST FIBONACCI w/ n values = 30, 40 and 50]");
        Fibo fibo = new Fibo();
        double time = System.currentTimeMillis();
        System.out.println("-> Recursive");
        System.out.println("30: "+fibo.rec(30));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms"); time = System.currentTimeMillis();
        System.out.println("40: "+fibo.rec(40));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms"); time = System.currentTimeMillis();
        System.out.println("50: "+fibo.rec(50));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms"); time = System.currentTimeMillis();
        System.out.println("");
        System.out.println("-> Iterative");
        time = System.currentTimeMillis();
        System.out.println("30: "+fibo.iter(30));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms"); time = System.currentTimeMillis();
        System.out.println("40: "+fibo.iter(40));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms"); time = System.currentTimeMillis();
        System.out.println("50: "+fibo.iter(50));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms");
        System.out.println("");
        System.out.println("-> Matrix exponentiation");
        time = System.currentTimeMillis();
        System.out.println("30: "+fibo.expoMatrix(30));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms"); time = System.currentTimeMillis();
        System.out.println("40: "+fibo.expoMatrix(40));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms"); time = System.currentTimeMillis();
        System.out.println("50: "+fibo.expoMatrix(50));
        time = (System.currentTimeMillis() - time); System.out.println("in: "+time+"ms");
    }
}

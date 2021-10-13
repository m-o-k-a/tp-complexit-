package TP1;

public class Main {
    public static void main(String[] args) throws Exception {
        FNCBuilder fnc = new FNCBuilder("./src/TP1/files/FNC-formula");
        System.out.println(fnc);
        System.out.println("accept model1 ? (waited: false): "+fnc.isModel("./src/TP1/files/model1"));
        System.out.println("accept model2 ? (waited: true): "+fnc.isModel("./src/TP1/files/model2"));
    }
}

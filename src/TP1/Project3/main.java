public class main {

    public static void main(String[] args) throws Exception {
        /*TuringMachine tm1 = new TuringMachine("./src/machines/oneState");
        System.out.println(tm1.isWord("sss"));
        TuringMachine tm2 = new TuringMachine("./src/machines/recognizeNot-aaa");
        System.out.println(tm2.isWord("a"));
        System.out.println(tm2.isWord("aaa"));
        System.out.println(tm2.isWord("aaaaaaaa"));
        System.out.println(tm2.isWord("wd"));*/

        TuringMachine td3ex1 = new TuringMachine("./src/machines/td3machine1");
        System.out.println(td3ex1.isWord("aaa"));
        System.out.println(td3ex1.isWord("abc"));
        System.out.println(td3ex1.isWord("bbbc"));
        System.out.println(td3ex1.isWord("aba"));
        System.out.println(td3ex1.isWord("ccccccba"));

        /*TuringMachine bckws = new TuringMachine("./src/machines/backwards-only-a");
        System.out.println(bckws.isWord("a"));*/

    }
}

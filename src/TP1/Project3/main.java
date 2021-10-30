package TP1.Project3;

public class main {

    public static void main(String[] args) throws Exception {
        /*
        TuringMachine tm1 = new TuringMachine("./src/TP1/Project3/machines/oneState");
        System.out.println(tm1.isWord("sss", false));
        */
        /*
        TuringMachine tm2 = new TuringMachine("./src/TP1/Project3/machines/recognizeNot-aaa");
        System.out.println(tm2.isWord("a", false));
        System.out.println(tm2.isWord("aaa", false));
        System.out.println(tm2.isWord("aaaaaaaa"));
        System.out.println(tm2.isWord("wd", false));
         */

        TuringMachine td3ex1 = new TuringMachine("./src/TP1/Project3/machines/td3machine1");
        System.out.println(td3ex1.isWord("aaa", true));
        System.out.println(td3ex1.isWord("abc", false));
        System.out.println(td3ex1.isWord("bbbc", false));
        System.out.println(td3ex1.isWord("aba", false));
        System.out.println(td3ex1.isWord("ccccccba", false));

        /*
        TuringMachine bckws = new TuringMachine("./src/machines/backwards-only-a");
        System.out.println(bckws.isWord("a", false));
        */

        /*
        TuringMachine nondeterminist = new TuringMachine("./src/TP1/Project3/machines/nonDeterminist");
        */

    }
}

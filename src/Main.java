import java.lang.*;

public class Main {


    public static void main(String[] args) {
        try {
            WordsProcessing fw = new WordsProcessing();
            fw.solve("src/automaton.txt");
        } catch (Exception e) {
            System.out.println("Error!");
        }


    }
}
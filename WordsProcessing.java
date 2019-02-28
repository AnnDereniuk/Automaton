import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class WordsProcessing {

    public ArrayList<State> automaton;
    public ArrayList<Transition> transitions = new ArrayList<>();
    public State firstState;
    public ArrayList<String> words = new ArrayList<>();
    HashSet<String> automatonWords = new HashSet<>();


    public void exceptionProcessing(String inFile) {
        try {
            this.readFile(inFile);
        } catch (FileNotFoundException exptn) {
            System.out.println("File not found");
        }
    }

    private void readFile(String inFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(inFile));
        this.automaton = new ArrayList<>();
        int first = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < k; ++i) {
            if (i == first) {
                this.firstState = new State(first);
                this.firstState.setFirst();
                this.automaton.add(new State(i));
            } else {
                this.automaton.add(new State(i));
            }
        }



}




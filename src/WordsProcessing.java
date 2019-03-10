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

        int i;
        for (i = scanner.nextInt(); i-- > 0; ((State) this.automaton.get(i)).isFinal = true) {
            i = scanner.nextInt();
        }

        while (scanner.hasNextLine()) {
            i = scanner.nextInt();
            char current = scanner.next().charAt(0);
            int to = scanner.nextInt();
            Transition transition = new Transition(i, to, current);
            transition.setCheck(false);
            if (transition != null) {
                this.transitions.add(transition);
                ((State) this.automaton.get(to)).addPrevious((State) this.automaton.get(i));
                ((State) this.automaton.get(to)).addTransitionToThis(transition);
                ((State) this.automaton.get(i)).addNext((State) this.automaton.get(to));

            }
        }
        this.transitions.sort(Comparator.comparingInt(Transition::getFrom));
        for (i = this.automaton.size() - 1; i >= 0; --i) {
            if (((State) this.automaton.get(i)).isFinal) {
                Iterator iterator = this.transitions.iterator();
                while (iterator.hasNext()) {
                    Transition tr = (Transition) iterator.next();
                    tr.setCheck(false);
                }
                iterator = this.automaton.iterator();
                while (iterator.hasNext()) {
                    State atm = (State) iterator.next();
                    atm.setCheck(0);
                }
                this.findWords((State) this.automaton.get(i));
            }
        }
        this.printWords();
    }

    public void printWords() {
        Iterator<String> iterator = this.automatonWords.iterator();
        for (int i = 1; iterator.hasNext(); ++i) {
            System.out.println(i + ": " + (String) iterator.next());
        }
    }

    public void findWords(State findWrds) {


    }


}




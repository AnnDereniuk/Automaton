import java.util.ArrayList;
import java.util.Comparator;

public class State {

    public int state;
    public boolean isFinal;
    public boolean isFirst;
    public int check;
    public ArrayList<State> previousState = new ArrayList();
    public ArrayList<State> nextState = new ArrayList();
    public ArrayList<Transition> transitionToThis = new ArrayList();

    public State (int num){
        this.state = num;
        this.isFirst= false;
        this.check=0;
    }

    public boolean isTerminate(){
        return this.isFinal;
    }

    public void setFirst() {
        this.isFirst=true;
    }

    public void setFinal(boolean theFinal){
        this.isFinal=theFinal;
    }

    public int getState (){
        return this.state;
    }

    public void addPrevious (State previous){
        this.previousState.add(previous);
        this.previousState.sort(Comparator.comparingInt(State::getState).reversed());
    }

    public void addNext(State theNext){
        this.nextState.add(theNext);
        this.nextState.sort(Comparator.comparingInt(State::getState));
    }

    public void setCheck(int check){
        this.check=check;
    }


    public void addTransitionToThis(Transition transition) {
        this.transitionToThis.add(transition);
        this.transitionToThis.sort(Comparator.comparingInt(Transition::getFrom).reversed());
    }

}

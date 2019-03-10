public class Transition {
public int from;
public int to;
public char letter;
public boolean check;

Transition(int from, int to, char letter) {
    this.from = from;
    this.to = to;
    this.letter = letter;
}

Transition(){}

    public int getFrom() {
        return this.from;
    }

    public char getLetter(){
    return this.letter;
    }

    public int getTo(){
    return this.to;
    }

    public boolean getCheck(){
    return this.check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String toString(){
    return "{"+ this.from+", "+this.letter+", "+this.to+" }";}

}

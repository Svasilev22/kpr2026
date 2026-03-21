package core;

public class Transition {

    private String fromState;
    private char readSymbol;

    private String toState;
    private char writeSymbol;

    private Move move;

    public Transition(String fromState, char readSymbol,
                      String toState, char writeSymbol, Move move) {

        this.fromState = fromState;
        this.readSymbol = readSymbol;
        this.toState = toState;
        this.writeSymbol = writeSymbol;
        this.move = move;
    }

    public String getFromState() {
        return fromState;
    }

    public char getReadSymbol() {
        return readSymbol;
    }

    public String getToState() {
        return toState;
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "(" + fromState + ", " + readSymbol + ") -> (" +
                toState + ", " + writeSymbol + ", " + move + ")";
    }
}

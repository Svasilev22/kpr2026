package core;

import java.util.HashMap;
import java.util.Map;

public class Tape {

    private Map<Integer, Character> cells;
    private int headPosition;

    public Tape() {
        cells = new HashMap<>();
        headPosition = 0;
    }

    public char read() {
        return cells.getOrDefault(headPosition, '_');
    }

    public void write(char c) {
        cells.put(headPosition, c);
    }

    public void move(Move move) {

        if (move == Move.L) {
            headPosition--;
        } else if (move == Move.R) {
            headPosition++;
        }
    }


    public String getTapeContents(int from, int to) {

        StringBuilder sb = new StringBuilder();

        for (int i = from; i <= to; i++) {

            char c = cells.getOrDefault(i, '_');

            if (i == headPosition) {
                sb.append("[").append(c).append("] ");
            } else {
                sb.append(" ").append(c).append("  ");
            }
        }

        return sb.toString();
    }

    public void reset() {
        cells.clear();
        headPosition = 0;
    }
}

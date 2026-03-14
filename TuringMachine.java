package core;

import java.util.HashSet;
import java.util.Set;

public class TuringMachine {

    private int id;
    private String name;

    private Set<String> states;
    private String startState;

    private Set<String> acceptStates;
    private Set<String> rejectStates;

    public TuringMachine(int id, String name) {
        this.id = id;
        this.name = name;

        states = new HashSet<>();
        acceptStates = new HashSet<>();
        rejectStates = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addState(String state) {
        states.add(state);
    }

    public void setStartState(String state) {

        if (!states.contains(state)) {
            System.out.println("State does not exist.");
            return;
        }

        startState = state;
    }

    public void addAcceptState(String state) {

        if (!states.contains(state)) {
            System.out.println("State does not exist.");
            return;
        }

        acceptStates.add(state);
    }

    public void addRejectState(String state) {

        if (!states.contains(state)) {
            System.out.println("State does not exist.");
            return;
        }

        rejectStates.add(state);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Turing Machine\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");

        sb.append("States: ").append(states).append("\n");
        sb.append("Start state: ").append(startState).append("\n");

        sb.append("Accept states: ").append(acceptStates).append("\n");
        sb.append("Reject states: ").append(rejectStates).append("\n");

        return sb.toString();
    }
}

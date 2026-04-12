package core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TuringMachine {

    private int id;
    private String name;

    private Set<String> states;
    private String startState;

    private Set<String> acceptStates;
    private Set<String> rejectStates;
    
    private Map<String, Map<Character, Transition>> transitions;

    public TuringMachine(int id, String name) {
        this.id = id;
        this.name = name;

        states = new HashSet<>();
        acceptStates = new HashSet<>();
        rejectStates = new HashSet<>();
        transitions = new HashMap<>();
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


    public void addTransition(String from, char read,
                              String to, char write, Move move) {

        if (!states.contains(from) || !states.contains(to)) {
            System.out.println("Invalid state.");
            return;
        }

        transitions.putIfAbsent(from, new HashMap<>());

        Map<Character, Transition> inner = transitions.get(from);

        if (inner.containsKey(read)) {
            System.out.println("Transition already exists.");
            return;
        }

        Transition t = new Transition(from, read, to, write, move);
        inner.put(read, t);

        System.out.println("Transition added.");
    }

    public void removeTransition(String from, char read) {

        if (!transitions.containsKey(from)) {
            System.out.println("No transitions for this state.");
            return;
        }

        Map<Character, Transition> inner = transitions.get(from);

        if (!inner.containsKey(read)) {
            System.out.println("Transition not found.");
            return;
        }

        inner.remove(read);
        System.out.println("Transition removed.");
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

        sb.append("Transitions:\n");

        for (String state : transitions.keySet()) {
            for (Transition t : transitions.get(state).values()) {
                sb.append("  ").append(t).append("\n");
            }
        }

        return sb.toString();
    }
    public boolean isDeterministic() {

    for (String state : transitions.keySet()) {

        Map<Character, Transition> inner = transitions.get(state);


        Set<Character> seen = new HashSet<>();

        for (Character c : inner.keySet()) {

            if (seen.contains(c)) {
                return false;
            }

            seen.add(c);
        }
    }

    return true;
}
    public String getStartState() {
    return startState;
}

public boolean isAcceptState(String state) {
    return acceptStates.contains(state);
}

public boolean isRejectState(String state) {
    return rejectStates.contains(state);
}

public Transition getTransition(String state, char symbol) {

    if (!transitions.containsKey(state)) {
        return null;
    }

    return transitions.get(state).get(symbol);
}
}

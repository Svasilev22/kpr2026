package manager;

import core.TuringMachine;

import java.util.HashMap;
import java.util.Map;

public class MachineManager {

    private Map<Integer, TuringMachine> machines;
    private Map<Integer, Tape> tapes = new HashMap<>();
    private int nextId;

    public MachineManager() {
        machines = new HashMap<>();
        nextId = 1;
    }

public void createMachine(String name) {

    TuringMachine machine = new TuringMachine(nextId, name);

    machines.put(nextId, machine);
    tapes.put(nextId, new Tape());

    System.out.println("Machine created with ID: " + nextId);

    nextId++;
}

    public void listMachines() {

        if (machines.isEmpty()) {
            System.out.println("No machines available.");
            return;
        }

        for (Integer id : machines.keySet()) {
            TuringMachine tm = machines.get(id);
            System.out.println("ID: " + id + " | Name: " + tm.getName());
        }
    }

    public void printMachine(int id) {

        TuringMachine machine = machines.get(id);

        if (machine == null) {
            System.out.println("Machine not found.");
            return;
        }
        public void printTape(int id) {

    Tape tape = tapes.get(id);

    if (tape == null) {
        System.out.println("Machine not found.");
        return;
    }
        public void resetTape(int id) {

    Tape tape = tapes.get(id);

    if (tape == null) {
        System.out.println("Machine not found.");
        return;
    }

    tape.reset();
    System.out.println("Tape reset.");
}

    System.out.println(tape.getTapeContents(-5, 5));
}

        System.out.println(machine);
    }

    public void addState(int id, String state) {

        TuringMachine machine = machines.get(id);

        if (machine == null) {
            System.out.println("Machine not found.");
            return;
        }

        machine.addState(state);
        System.out.println("State added.");
    }

    public void setStart(int id, String state) {

        TuringMachine machine = machines.get(id);

        if (machine == null) {
            System.out.println("Machine not found.");
            return;
        }

        machine.setStartState(state);
        System.out.println("Start state set.");
    }

    public void addAccept(int id, String state) {

        TuringMachine machine = machines.get(id);

        if (machine == null) {
            System.out.println("Machine not found.");
            return;
        }

        machine.addAcceptState(state);
        System.out.println("Accept state added.");
    }

    public void addReject(int id, String state) {

        TuringMachine machine = machines.get(id);

        if (machine == null) {
            System.out.println("Machine not found.");
            return;
        }

        machine.addRejectState(state);
        System.out.println("Reject state added.");
    }
    public void addTransition(int id, String from, char read,
                          String to, char write, String moveStr) {

    TuringMachine machine = machines.get(id);

    if (machine == null) {
        System.out.println("Machine not found.");
        return;
    }

    Move move;

    try {
        move = Move.valueOf(moveStr);
    } catch (Exception e) {
        System.out.println("Invalid move (use L, R, S).");
        return;
    }

    machine.addTransition(from, read, to, write, move);
}

public void removeTransition(int id, String from, char read) {

    TuringMachine machine = machines.get(id);

    if (machine == null) {
        System.out.println("Machine not found.");
        return;
    }

    machine.removeTransition(from, read);
}
public void checkDeterministic(int id) {

    TuringMachine machine = machines.get(id);

    if (machine == null) {
        System.out.println("Machine not found.");
        return;
    }

    if (machine.isDeterministic()) {
        System.out.println("The machine is deterministic.");
    } else {
        System.out.println("The machine is NOT deterministic.");
    }
}
private Map<Integer, execution.MachineExecution> executions = new HashMap<>();
}


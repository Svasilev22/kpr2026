package manager;

import core.TuringMachine;
import core.Move;
import core.Tape;
import execution.MachineExecution;

import java.util.HashMap;
import java.util.Map;

public class MachineManager {

    private Map<Integer, TuringMachine> machines;
    private Map<Integer, Tape> tapes;
    private Map<Integer, MachineExecution> executions;

    private int nextId;

    public MachineManager() {
        machines = new HashMap<>();
        tapes = new HashMap<>();
        executions = new HashMap<>();
        nextId = 1;
    }

    // ---------- BASIC ----------

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

        System.out.println(machine);
    }

    // ---------- STATES ----------

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

    // ---------- TRANSITIONS ----------

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

    // ---------- CHECK DET ----------

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

    // ---------- TAPE ----------

    public void printTape(int id) {

        Tape tape = tapes.get(id);

        if (tape == null) {
            System.out.println("Machine not found.");
            return;
        }

        System.out.println(tape.getTapeContents(-5, 5));
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

    // ---------- EXECUTION ----------

    public void initExecution(int id, String input) {

        TuringMachine machine = machines.get(id);
        Tape tape = tapes.get(id);

        if (machine == null || tape == null) {
            System.out.println("Machine not found.");
            return;
        }

        MachineExecution exec = new MachineExecution(machine, tape);
        exec.init(input);

        executions.put(id, exec);
    }

    public void step(int id) {

        MachineExecution exec = executions.get(id);

        if (exec == null) {
            System.out.println("Execution not initialized.");
            return;
        }

        exec.step();
    }

    public void status(int id) {

        MachineExecution exec = executions.get(id);

        if (exec == null) {
            System.out.println("Execution not initialized.");
            return;
        }

        exec.printStatus();
    }

    public void resetExecution(int id) {

        if (!executions.containsKey(id)) {
            System.out.println("Execution not initialized.");
            return;
        }

        executions.remove(id);
        System.out.println("Execution reset.");
    }
}

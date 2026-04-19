package execution;

import core.TuringMachine;
import core.Tape;
import core.Transition;

public class MachineExecution {

    private TuringMachine machine;
    private Tape tape;

    private String currentState;
    private boolean halted;
    private int steps;

    public MachineExecution(TuringMachine machine, Tape tape) {
        this.machine = machine;
        this.tape = tape;
        this.halted = false;
        this.steps = 0;
    }

    public void init(String input) {

        tape.reset();

        for (int i = 0; i < input.length(); i++) {
            tape.write(input.charAt(i));
            tape.move(core.Move.R);
        }

        for (int i = 0; i < input.length(); i++) {
            tape.move(core.Move.L);
        }

        currentState = machine.getStartState();
        halted = false;
        steps = 0;

        System.out.println("Execution initialized.");
    }

    public void step() {

        if (halted) {
            System.out.println("Machine already halted.");
            return;
        }

        char symbol = tape.read();

        Transition t = machine.getTransition(currentState, symbol);

        if (t == null) {
            halted = true;
            System.out.println("No transition found. Machine halted.");
            return;
        }

        tape.write(t.getWriteSymbol());
        tape.move(t.getMove());

        currentState = t.getToState();
        steps++;

        if (machine.isAcceptState(currentState)) {
            halted = true;
            System.out.println("Machine ACCEPTED.");
        } else if (machine.isRejectState(currentState)) {
            halted = true;
            System.out.println("Machine REJECTED.");
        }
    }

    public void run(int maxSteps) {

        while (!halted && steps < maxSteps) {
            step();
        }

        if (!halted) {
            System.out.println("Max steps reached.");
        }
    }

    public void printStatus() {
        System.out.println("Current state: " + currentState);
        System.out.println("Halted: " + halted);
        System.out.println("Steps: " + steps);
    }

    public boolean isHalted() {
        return halted;
    }
}

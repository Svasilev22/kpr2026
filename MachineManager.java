package manager;

import core.TuringMachine;

import java.util.HashMap;
import java.util.Map;

public class MachineManager {

    private Map<Integer, TuringMachine> machines;
    private int nextId;

    public MachineManager() {
        machines = new HashMap<>();
        nextId = 1;
    }

    public void createMachine(String name) {
        TuringMachine machine = new TuringMachine(nextId, name);
        machines.put(nextId, machine);

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
}
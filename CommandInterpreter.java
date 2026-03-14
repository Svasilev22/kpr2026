package cli;

import manager.MachineManager;

import java.util.Scanner;

public class CommandInterpreter {

    private Scanner scanner;
    private MachineManager manager;
    private boolean running;

    public CommandInterpreter() {
        scanner = new Scanner(System.in);
        manager = new MachineManager();
        running = true;
    }

    public void start() {

        System.out.println("DTM System started.");
        System.out.println("Type 'help' to see available commands.");

        while (running) {

            System.out.print("> ");
            String input = scanner.nextLine();

            processCommand(input);
        }
    }

    private void processCommand(String input) {

        if (input == null || input.trim().isEmpty()) {
            return;
        }

        String[] parts = input.split("\\s+");
        String command = parts[0];

        switch (command) {

            case "help":
                printHelp();
                break;

            case "exit":
                running = false;
                System.out.println("Exiting program...");
                break;

            case "newTM":

                if (parts.length < 2) {
                    System.out.println("Usage: newTM <name>");
                } else {
                    manager.createMachine(parts[1]);
                }

                break;

            case "list":

                manager.listMachines();
                break;

            case "print":

                if (parts.length < 2) {
                    System.out.println("Usage: print <id>");
                } else {
                    try {
                        int id = Integer.parseInt(parts[1]);
                        manager.printMachine(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }

                break;

            case "addState":

                if (parts.length < 3) {
                    System.out.println("Usage: addState <id> <state>");
                } else {
                    try {
                        int id = Integer.parseInt(parts[1]);
                        manager.addState(id, parts[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }

                break;

            case "setStart":

                if (parts.length < 3) {
                    System.out.println("Usage: setStart <id> <state>");
                } else {
                    try {
                        int id = Integer.parseInt(parts[1]);
                        manager.setStart(id, parts[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }

                break;

            case "addAccept":

                if (parts.length < 3) {
                    System.out.println("Usage: addAccept <id> <state>");
                } else {
                    try {
                        int id = Integer.parseInt(parts[1]);
                        manager.addAccept(id, parts[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }

                break;

            case "addReject":

                if (parts.length < 3) {
                    System.out.println("Usage: addReject <id> <state>");
                } else {
                    try {
                        int id = Integer.parseInt(parts[1]);
                        manager.addReject(id, parts[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }

                break;

            default:
                System.out.println("Unknown command. Type 'help'.");
        }
    }

    private void printHelp() {

        System.out.println("Available commands:");
        System.out.println("  newTM <name>        - create new Turing Machine");
        System.out.println("  list                - list all machines");
        System.out.println("  print <id>          - print machine information");

        System.out.println("  addState <id> <s>   - add state");
        System.out.println("  setStart <id> <s>   - set start state");
        System.out.println("  addAccept <id> <s>  - add accept state");
        System.out.println("  addReject <id> <s>  - add reject state");

        System.out.println("  help                - show commands");
        System.out.println("  exit                - exit program");
    }
}

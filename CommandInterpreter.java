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
                    } catch (Exception e) {
                        System.out.println("Invalid ID.");
                    }
                }

                break;

            case "addState":

                if (parts.length < 3) {
                    System.out.println("Usage: addState <id> <state>");
                } else {
                    int id = Integer.parseInt(parts[1]);
                    manager.addState(id, parts[2]);
                }

                break;

            case "setStart":

                if (parts.length < 3) {
                    System.out.println("Usage: setStart <id> <state>");
                } else {
                    int id = Integer.parseInt(parts[1]);
                    manager.setStart(id, parts[2]);
                }

                break;

            case "addAccept":

                if (parts.length < 3) {
                    System.out.println("Usage: addAccept <id> <state>");
                } else {
                    int id = Integer.parseInt(parts[1]);
                    manager.addAccept(id, parts[2]);
                }

                break;

            case "addReject":

                if (parts.length < 3) {
                    System.out.println("Usage: addReject <id> <state>");
                } else {
                    int id = Integer.parseInt(parts[1]);
                    manager.addReject(id, parts[2]);
                }

                break;

            case "addTrans":

                if (parts.length < 7) {
                    System.out.println("Usage: addTrans <id> <q> <read> <q2> <write> <move>");
                } else {
                    try {
                        int id = Integer.parseInt(parts[1]);

                        String from = parts[2];
                        char read = parts[3].charAt(0);

                        String to = parts[4];
                        char write = parts[5].charAt(0);

                        String move = parts[6];

                        manager.addTransition(id, from, read, to, write, move);

                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
                }

                break;

            case "removeTrans":

                if (parts.length < 4) {
                    System.out.println("Usage: removeTrans <id> <q> <read>");
                } else {
                    try {
                        int id = Integer.parseInt(parts[1]);
                        String from = parts[2];
                        char read = parts[3].charAt(0);

                        manager.removeTransition(id, from, read);

                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
                }

                break;

            default:
                System.out.println("Unknown command. Type 'help'.");
        }
    }

    private void printHelp() {

        System.out.println("Available commands:");
        System.out.println("  newTM <name>");
        System.out.println("  list");
        System.out.println("  print <id>");

        System.out.println("  addState <id> <state>");
        System.out.println("  setStart <id> <state>");
        System.out.println("  addAccept <id> <state>");
        System.out.println("  addReject <id> <state>");

        System.out.println("  addTrans <id> <q> <read> <q2> <write> <move>");
        System.out.println("  removeTrans <id> <q> <read>");

        System.out.println("  help");
        System.out.println("  exit");
    }
    case "checkDet":

    if (parts.length < 2) {
        System.out.println("Usage: checkDet <id>");
    } else {
        try {
            int id = Integer.parseInt(parts[1]);
            manager.checkDeterministic(id);
        } catch (Exception e) {
            System.out.println("Invalid ID.");
        }
    }

    break;
}

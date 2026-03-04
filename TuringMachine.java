package core;

public class TuringMachine {

    private int id;
    private String name;

    public TuringMachine(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Turing Machine\n" +
                "ID: " + id + "\n" +
                "Name: " + name;
    }
}
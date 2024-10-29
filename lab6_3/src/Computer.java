import java.lang.Math;

public class Computer extends Player{

    public Computer(String name) {
        super(name);
    }
    public int turn() {
        return (int)(Math.random()*3 + 1);
    }
}

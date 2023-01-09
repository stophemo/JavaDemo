package decorator;

public class App {
    public static void main(String[] args) {
        RobotDecorator robotDecorator = new RobotDecorator(new FirstRobot());
        robotDecorator.doSomething();
        robotDecorator.doMorething();
    }
}

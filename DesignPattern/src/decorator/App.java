package decorator;

public class App {
    public static void main(String[] args) {
        new RobotDecorator(new FirstRobot()).doSomething();
    }
}

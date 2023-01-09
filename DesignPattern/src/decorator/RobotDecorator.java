package decorator;

public class RobotDecorator implements Robot {
    private Robot robot;
    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMorething() {
//        robot.doSomething();
        System.out.println("dance");
    }
}

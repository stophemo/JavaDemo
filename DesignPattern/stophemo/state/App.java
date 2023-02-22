package state;

public class App {
    public static void main(String[] args) {
        Context context = new Context();
        context.changeState(new Happy());
        context.dosomething();
        context.changeState(new Angry());
        context.dosomething();
        context.changeState(new Sad());
        context.dosomething();
    }
}

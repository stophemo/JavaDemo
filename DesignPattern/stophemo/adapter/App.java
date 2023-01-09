package adapter;

public class App {
    public static void main(String[] args) {
        String r = new Adapter(new Speaker()).translate();
        System.out.println(r);
    }
}

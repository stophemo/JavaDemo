package observer.second;

public class Lisi implements Credit{
    @Override
    public void takebackMoney() {
        System.out.println("李四收回债款了");
    }
}

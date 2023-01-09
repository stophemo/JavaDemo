package observer.first;

public class Creditor extends People implements Credit  {

    protected Creditor(String name) {
        super.name = name;
    }

    @Override
    public void takebackMoney() {
        System.out.println(super.name + "收回了欠款" );
    }
}

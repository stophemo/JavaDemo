package observer.second;

import java.util.ArrayList;

public class Zhangsan implements Debit {
    private ArrayList<Credit> allCredit = new ArrayList<>();
    @Override
    public void borrow(Credit credit) {
        allCredit.add(credit);
        System.out.println("张三向" + credit.getClass().getSimpleName() + "借钱了");
    }

    @Override
    public void notifyCredits() {
        allCredit.forEach(Credit::takebackMoney);
    }
}

package observer.second;

import java.util.ArrayList;

public class zhangsan implements Debit {
    private ArrayList<Credit> allCredit = new ArrayList<>();
    @Override
    public void borrow(Credit credit) {
        allCredit.add(credit);
    }

    @Override
    public void notifyCredits() {
        allCredit.forEach(Credit::takebackMoney);
    }
}

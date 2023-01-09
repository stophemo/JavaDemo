package observer.first;

import java.util.ArrayList;
import java.util.List;

public class Debitor extends People implements Debit {
    
    private List<Creditor> allCreditor = new ArrayList<>();

    protected Debitor(String name) {
        super.name = name;
    }


    @Override
    public void borrow(Creditor creditor) {
        allCreditor.add(creditor);
        System.out.println(super.name + "向" + creditor.name + "借了一笔款");
    }
    @Override
    public void notifyCredits() {
        allCreditor.forEach(creditor -> creditor.takebackMoney());
    }
}

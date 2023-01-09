package observer.second;


/**
 * 借款人
 */
public interface Debit {
    void borrow(Credit credit);
    void notifyCredits();
}
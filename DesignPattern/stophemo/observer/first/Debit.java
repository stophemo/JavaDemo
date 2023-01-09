package observer.first;

/**
 * 借款人
 */
interface Debit {
    void borrow(Creditor creditor);
    void notifyCredits();
}

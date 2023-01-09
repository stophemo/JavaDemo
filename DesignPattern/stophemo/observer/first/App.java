package observer.first;

public class App {
    public static void main(String[] args) {
        Debitor zhangsan = new Debitor("张三");
        Creditor lisi = new Creditor("李四");
        Creditor wangwu = new Creditor("王五");
        Creditor zhaoliu = new Creditor("赵六");
        zhangsan.borrow(lisi);
        zhangsan.borrow(wangwu);
        zhangsan.borrow(zhaoliu);
        System.out.println("~~~ 一段时间后，张三有钱了");
        zhangsan.notifyCredits();
    }
}

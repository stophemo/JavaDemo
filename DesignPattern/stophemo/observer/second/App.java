package observer.second;



public class App {
    public static void main(String[] args) {
        Zhangsan zhangsan = new Zhangsan();
        Lisi lisi = new Lisi();
        Wangwu wangwu = new Wangwu();
        Zhaoliu zhaoliu = new Zhaoliu();
        zhangsan.borrow(lisi);
        zhangsan.borrow(wangwu);
        zhangsan.borrow(zhaoliu);
        System.out.println("~~~ 一段时间后，张三有钱了");
        zhangsan.notifyCredits();
    }
}

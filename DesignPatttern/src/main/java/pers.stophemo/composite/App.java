package pers.stophemo.composite;

public class App {
    public static void main(String[] args) {
        Composite china = new Composite();
        china.add(new City(1000)); //直辖市 -- 北京
        china.add(new City(2000)); //直辖市 -- 上海

        Composite ShanXi = new Composite();
        ShanXi.add(new City(3000)); //大同市
        ShanXi.add(new City(3000)); //太原市
        //...
        china.add(ShanXi);
        System.out.println(china.count());
    }
}

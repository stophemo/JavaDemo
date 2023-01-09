package pers.stophemo.singleton;
/**
 * 确保一个类只有一个实例,
 * 而且自行实例化
 * 并向整个系统提供这个实例
 *
 * 1. 如何确保一个类只有一个实例?
 * 构造方法不能公开, 不能被外界实例化使用 private修饰
 * 这个实例是当前类的类成员变量 用static修饰
 * 2. 向整个系统提供这个实例
 * 使用方法向外界提供这个实例
 *
 * 3. 根据对象实例化时机不同可以分为饿汉式和懒汉式
 */
public class App {
    public static void main(String[] args) {

    }
}

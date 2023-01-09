package singleton;

// 懒汉式
public class LazySingleton {
    /**
     * singleton = new Singleton() 可以拆解为3步：
     * 1、分配内存，2、初始化对象，3、指向刚分配的地址，
     * 若CPU优化，可能发生重排序，假设 A 线程执行了1和3，还没有执行2，B线程来到判断 NULL，
     * B线程就会直接返回还没初始化的instance了。volatile 可以避免重排序。
     */
    private volatile static LazySingleton singleton;

    private LazySingleton() {
    }

    public synchronized static LazySingleton getInstance1() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    // 第一次实例化后不会在进行实例化，但是同步代码块依然重复执行  => 写成双重检查锁
    public static LazySingleton getInstance2() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}

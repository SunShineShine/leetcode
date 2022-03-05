package leetcode.singleton;

/**
 * 双锁单例
 * @date 2022/3/5 16:45
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton() {

    }
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

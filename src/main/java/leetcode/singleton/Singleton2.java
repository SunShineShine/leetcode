package leetcode.singleton;

/**
 * 静态内部类单例
 * @date 2022/3/5 16:56
 */
public class Singleton2 {

    private Singleton2() {

    }

    public static Singleton2 getSingleTon() {
        return Inner.singleton2;
    }

    private static class Inner {
        private static final Singleton2 singleton2 = new Singleton2();
    }

}
